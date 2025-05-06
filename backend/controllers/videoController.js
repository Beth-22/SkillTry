const Video = require("../models/Video");
const Course = require("../models/Course");
const path = require("path");
const fs = require("fs");

const uploadVideo = async (req, res) => {
  try {
    const { title, courseId } = req.body;

    if (!req.file) {
      return res.status(400).json({ message: "No video file uploaded" });
    }

    // Optional: check course exists
    const course = await Course.findById(courseId);
    if (!course) return res.status(404).json({ message: "Course not found" });

    const video = new Video({
      title,
      course: courseId,
      videoPath: req.file.path,
      uploadedBy: req.user.id,
    });

    await video.save();
    res.status(201).json({ message: "Video uploaded successfully", video });
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};
const streamVideo = async (req, res) => {
    const videoId = req.params.id;
    const video = await Video.findById(videoId);
    if (!video) return res.status(404).json({ message: "Video not found" });
  
    const videoPath = video.videoPath;
    const stat = fs.statSync(videoPath);
    const fileSize = stat.size;
    const range = req.headers.range;
  
    if (!range) {
      return res.status(416).json({ message: "Range header required" });
    }
  
    const CHUNK_SIZE = 1 * 1e6; // 1MB
    const start = Number(range.replace(/\D/g, ""));
    const end = Math.min(start + CHUNK_SIZE, fileSize - 1);
  
    const contentLength = end - start + 1;
    const headers = {
      "Content-Range": `bytes ${start}-${end}/${fileSize}`,
      "Accept-Ranges": "bytes",
      "Content-Length": contentLength,
      "Content-Type": "video/mp4",
    };
  
    res.writeHead(206, headers);
    const stream = fs.createReadStream(videoPath, { start, end });
    stream.pipe(res);
  };

  module.exports = {
    uploadVideo,
    streamVideo,
  };
