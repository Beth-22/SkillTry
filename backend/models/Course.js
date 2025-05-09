// models/Course.js
const mongoose = require("mongoose");

const courseSchema = new mongoose.Schema({
  title: { type: String, required: true },
  instructor: { type: mongoose.Schema.Types.ObjectId, ref: "User", required: true },
  introductoryVideo: { type: String, default: null }, // Store the video filename
  lessons: [{ type: mongoose.Schema.Types.ObjectId, ref: "Lesson" }],
});

module.exports = mongoose.model("Course", courseSchema);
