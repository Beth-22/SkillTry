const express = require("express");
const { streamVideo } = require("../controllers/videoController");

const upload = require("../middlewares/videoUpload"); // Import the multer configuration
const { authenticateUser, authorizeRoles } = require("../middlewares/authMiddleware");
const { uploadVideo } = require("../controllers/videoController"); // Controller method for uploading videos

const router = express.Router();

// Route to stream video
router.get("/stream", streamVideo); // Use the `path` query parameter to get the video file

// Video upload route
router.post(
  "/upload/:courseId",
  authenticateUser, // Ensure the user is logged in
  authorizeRoles("instructor", "admin"), // Only instructor or admin can upload videos
  upload.single("video"), // Multer middleware to handle video upload
  uploadVideo // Controller function to handle after upload (save the video link to the course)
);

module.exports = router;