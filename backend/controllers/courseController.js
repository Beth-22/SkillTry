const Course = require("../models/Course");

const createCourse = async (req, res) => {
  try {
    const course = new Course({
      ...req.body,
      instructor: req.user.id,
    });
    await course.save();
    res.status(201).json(course);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};
const updateCourse = async (req, res) => {
    try {
      const course = await Course.findById(req.params.id);
  
      if (!course) return res.status(404).json({ message: "Course not found" });
  
      // Only creator or admin can update
      if (course.instructor.toString() !== req.user.id && req.user.role !== "admin") {
        return res.status(403).json({ message: "Unauthorized to update this course" });
      }
  
      const updatedCourse = await Course.findByIdAndUpdate(
        req.params.id,
        req.body,
        { new: true, runValidators: true }
      );
  
      res.status(200).json(updatedCourse);
    } catch (err) {
      res.status(500).json({ error: err.message });
    }
  };
  const deleteCourse = async (req, res) => {
    try {
      const course = await Course.findById(req.params.id);
  
      if (!course) return res.status(404).json({ message: "Course not found" });
  
      // Only creator or admin can delete
      if (course.instructor.toString() !== req.user.id && req.user.role !== "admin") {
        return res.status(403).json({ message: "Unauthorized to delete this course" });
      }
  
      await course.deleteOne();
      res.status(200).json({ message: "Course deleted successfully" });
    } catch (err) {
      res.status(500).json({ error: err.message });
    }
  };
  
  
const getCourses = async (req, res) => {
  try {
    const courses = await Course.find().populate("instructor", "name");
    res.status(200).json(courses);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};
module.exports = {
    createCourse,
    getCourses,
    updateCourse,
    deleteCourse,
  };
  