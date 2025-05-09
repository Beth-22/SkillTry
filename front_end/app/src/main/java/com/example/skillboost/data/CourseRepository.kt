package com.example.skillboost.data

import com.example.skillboost.model.Course

class CourseRepository {
    suspend fun fetchCourses(): List<Course> {
        // TODO: Implement backend API call to fetch courses
        // Example: Call API to get list of courses
        return getMockCourses()
    }

    suspend fun getCourseByName(name: String): Course? {
        val courses = fetchCourses()
        return courses.find { it.name.equals(name, ignoreCase = true) }
    }

    private fun getMockCourses(): List<Course> {
        return listOf(
            Course(
                id = 1,
                name = "Algebra",
                credit = 3,
                level = "Level - Beginner",
                category = "Mathematics",
                imageUrl = "https://th.bing.com/th/id/OIP.DORlDIyOY2PvOgjmwXG28gHaEK?cb=iwp1&rs=1&pid=ImgDetMain"
            ),
            Course(
                id = 2,
                name = "Geometry",
                credit = 3,
                level = "Level - Beginner",
                category = "Mathematics",
                imageUrl = "https://th.bing.com/th/id/OIP.DORlDIyOY2PvOgjmwXG28gHaEK?cb=iwp1&rs=1&pid=ImgDetMain"
            ),
            Course(
                id = 3,
                name = "Calculus",
                credit = 3,
                level = "Level - Intermediate",
                category = "Mathematics",
                imageUrl = "https://th.bing.com/th/id/OIP.DORlDIyOY2PvOgjmwXG28gHaEK?cb=iwp1&rs=1&pid=ImgDetMain"
            ),
            Course(
                id = 4,
                name = "Statistics",
                credit = 3,
                level = "Level - Beginner",
                category = "Mathematics",
                imageUrl = "https://th.bing.com/th/id/OIP.DORlDIyOY2PvOgjmwXG28gHaEK?cb=iwp1&rs=1&pid=ImgDetMain"
            ),
            Course(
                id = 5,
                name = "Molecules",
                credit = 3,
                level = "Level - Beginner",
                category = "Chemistry",
                imageUrl = "https://th.bing.com/th/id/OIP.DORlDIyOY2PvOgjmwXG28gHaEK?cb=iwp1&rs=1&pid=ImgDetMain"
            ),
            Course(
                id = 6,
                name = "Organic Chemistry",
                credit = 3,
                level = "Level - Beginner",
                category = "Chemistry",
                imageUrl = "https://th.bing.com/th/id/OIP.DORlDIyOY2PvOgjmwXG28gHaEK?cb=iwp1&rs=1&pid=ImgDetMain"
            ),
            Course(
                id = 7,
                name = "Inorganic Chemistry",
                credit = 3,
                level = "Level - Intermediate",
                category = "Chemistry",
                imageUrl = "https://th.bing.com/th/id/OIP.DORlDIyOY2PvOgjmwXG28gHaEK?cb=iwp1&rs=1&pid=ImgDetMain"
            ),
            Course(
                id = 8,
                name = "Genetics",
                credit = 3,
                level = "Level - Beginner",
                category = "Biology",
                imageUrl = "https://th.bing.com/th/id/OIP.DORlDIyOY2PvOgjmwXG28gHaEK?cb=iwp1&rs=1&pid=ImgDetMain"
            ),
            Course(
                id = 9,
                name = "Cell Biology",
                credit = 3,
                level = "Level - Beginner",
                category = "Biology",
                imageUrl = "https://th.bing.com/th/id/OIP.DORlDIyOY2PvOgjmwXG28gHaEK?cb=iwp1&rs=1&pid=ImgDetMain"
            ),
            Course(
                id = 10,
                name = "Ecology",
                credit = 3,
                level = "Level - Beginner",
                category = "Biology",
                imageUrl = "https://th.bing.com/th/id/OIP.DORlDIyOY2PvOgjmwXG28gHaEK?cb=iwp1&rs=1&pid=ImgDetMain"
            ),
            Course(
                id = 11,
                name = "Mechanics",
                credit = 3,
                level = "Level - Beginner",
                category = "Physics",
                imageUrl = "https://th.bing.com/th/id/OIP.DORlDIyOY2PvOgjmwXG28gHaEK?cb=iwp1&rs=1&pid=ImgDetMain"
            ),
            Course(
                id = 12,
                name = "Thermodynamics",
                credit = 3,
                level = "Level - Intermediate",
                category = "Physics",
                imageUrl = "https://th.bing.com/th/id/OIP.DORlDIyOY2PvOgjmwXG28gHaEK?cb=iwp1&rs=1&pid=ImgDetMain"
            )
        )
    }
}