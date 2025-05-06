const express = require("express");
const multer = require("multer");
const path = require("path");
const { authenticateUser, authorizeRoles } = require("../middlewares/authMiddleware");
const { uploadVideo } = require("../controllers/videoController");
const { streamVideo } = require("../controllers/videoController");

const router = express.Router();

// Multer config
const storage = multer.diskStorage({
  destination: (req, file, cb) => cb(null, "videos/"),
  filename: (req, file, cb) => cb(null, Date.now() + path.extname(file.originalname))
});
const upload = multer({ storage });

// Route
router.post(
  "/upload",
  authenticateUser,
  authorizeRoles("instructor", "admin"),
  upload.single("video"),
  uploadVideo
);
router.get("/stream/:id", authenticateUser, streamVideo);

module.exports = router;
