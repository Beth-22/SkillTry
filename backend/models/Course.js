const mongoose = require("mongoose");

const courseSchema = new mongoose.Schema({
  title: { type: String, required: true },
  description: String,
  instructor: { type: mongoose.Schema.Types.ObjectId, ref: "User" },
  content: [
    {
      type: { type: String, enum: ["video", "pdf"], required: true },
      title: String,
      url: String,
    },
  ],
  enrolledStudents: [{ type: mongoose.Schema.Types.ObjectId, ref: "User" }]
}, { timestamps: true });

module.exports = mongoose.model("Course", courseSchema);
// This schema defines a Course model with fields for title, description, instructor, content (which can be videos or PDFs), and enrolled students.