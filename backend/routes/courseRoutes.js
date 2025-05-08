const express = require("express");
const uploadPdf = require("../middlewares/uploadPdfMiddleware");

const { authenticateUser, authorizeRoles } = require("../middlewares/authMiddleware");
const {
  createCourse,
  getCourses,
  getCourse,
  updateCourse,
  deleteCourse,
  updateVideoInCourse,
  deleteVideoFromCourse,
  enrollInCourse,
  
  getEnrolledCourses
  
  
} = require("../controllers/courseController");
const { uploadPdfToCourse } = require("../controllers/courseController");

const router = express.Router();
router.post(
  "/:id/upload/pdf",
  authenticateUser,
  authorizeRoles("instructor", "admin"),
  uploadPdf.single("pdf"),
  uploadPdfToCourse
);

router.post("/createCourse", authenticateUser, authorizeRoles("instructor", "admin"), createCourse);
router.get("/", authenticateUser, getCourses);                 // all courses
router.get("/:id", authenticateUser, getCourse);               // single course
router.put("/:id", authenticateUser, updateCourse);            // update course
router.delete("/:id", authenticateUser, deleteCourse);         // delete course
router.post("/:id/enroll", authenticateUser, enrollInCourse);  // enroll
router.get("/student/enrolled", authenticateUser, getEnrolledCourses);  // student enrolled list
router.put("/:courseId/videos/:videoId", authenticateUser, updateVideoInCourse);
router.delete("/:courseId/videos/:videoId", authenticateUser, deleteVideoFromCourse);
module.exports = router;
// This code defines the routes for course-related operations in an Express application. It includes routes for creating, retrieving, updating, deleting courses, enrolling students, and getting enrolled courses. The routes are protected by authentication and authorization middleware to ensure that only authorized users can access them.