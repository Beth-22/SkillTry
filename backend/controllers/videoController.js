const Course = require("../models/Course");
const multer = require("multer");
const fs = require("fs");
const path = require("path");

// Ensure the Videos directory exists
const videosStoragePath = path.join(__dirname, "..", "Videos");
if (!fs.existsSync(videosStoragePath)) {
  fs.mkdirSync(videosStoragePath, { recursive: true });
}

const uploadVideo = async (req, res) => {
  try {
    const { courseId } = req.params;
    const { filename } = req.file; // The name of the uploaded file

    // Find the course
    const course = await Course.findById(courseId);
    if (!course) {
      return res.status(404).json({ message: "Course not found" });
    }

    // Only the instructor or admin can upload videos for the course
    if (course.instructor.toString() !== req.user.id && req.user.role !== "admin") {
      return res.status(403).json({ message: "You are not authorized to upload videos to this course" });
    }

    // Save video information to the course model
    course.content.push({
      type: "video",  // Indicate the content type is video
      title: req.body.title || "Untitled",  // Optional: You can set the title from the request body or default to "Untitled"
      url: filename,  // Save the filename (or full URL if needed)
    });

    await course.save();
    res.status(200).json({ message: "Video uploaded successfully", video: filename });
  } catch (error) {
    if (error instanceof multer.MulterError) {
      return res.status(400).json({ message: `File upload error: ${error.message}` });
    }
    res.status(500).json({ message: error.message });
  }
};

const streamVideo = (req, res) => {
  const videoPath = path.join(__dirname, "..", "Videos", req.query.path); // Using the filename stored in the course model

  fs.stat(videoPath, (err, stats) => {
    if (err || !stats.isFile()) {
      return res.status(404).json({ message: "Video not found" });
    }

    const range = req.headers.range;
    if (!range) {
      return res.status(416).send("Requires Range header");
    }

    const videoSize = stats.size;
    const CHUNK_SIZE = 10 ** 6; // 1MB per chunk
    const start = Number(range.replace(/\D/g, ""));  // Parse the start of the range
    const end = Math.min(start + CHUNK_SIZE, videoSize - 1);  // Calculate end range

    // Validate that the range is within the video bounds
    if (start >= videoSize || end > videoSize) {
      return res.status(416).send("Requested range not satisfiable");
    }

    const contentLength = end - start + 1;
    const headers = {
      "Content-Range": `bytes ${start}-${end}/${videoSize}`,
      "Accept-Ranges": "bytes",
      "Content-Length": contentLength,
      "Content-Type": "video/mp4",
    };

    res.writeHead(206, headers);
    const stream = fs.createReadStream(videoPath, { start, end });
    stream.pipe(res);
  });
};

module.exports = { uploadVideo, streamVideo };
// This code handles video uploads and streaming for a course management system.