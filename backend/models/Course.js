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
}, { timestamps: true });

module.exports = mongoose.model("Course", courseSchema);
