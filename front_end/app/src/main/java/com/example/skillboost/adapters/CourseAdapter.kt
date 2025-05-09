package com.example.skillboost.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.skillboost.model.Course
import com.example.skillboost.R

class CourseAdapter(private val courses: List<Course>) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    class CourseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val courseTitle: TextView = view.findViewById(R.id.courseName)
        val courseCredit: TextView = view.findViewById(R.id.courseCredit)
        val courseLevel: TextView = view.findViewById(R.id.courseLevel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.course_item, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.courseTitle.text = course.name
        holder.courseCredit.text = course.credit.toString() // Convert Int to String
        holder.courseLevel.text = course.level
    }

    override fun getItemCount() = courses.size
}