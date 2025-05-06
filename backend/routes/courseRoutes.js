const express = require("express");
const { authenticateUser, authorizeRoles } = require("../middlewares/authMiddleware");
const {
  createCourse,
  getCourses,
  updateCourse,
  deleteCourse,
} = require("../controllers/courseController");

const router = express.Router();

router.post("/createCourse", authenticateUser, authorizeRoles("instructor", "admin"), createCourse);
router.get("/", authenticateUser, getCourses);
router.put("/:id", authenticateUser, updateCourse);  // Anyone logged in can hit it, but logic inside will restrict
router.delete("/:id", authenticateUser, deleteCourse);

module.exports = router;
