package com.mcp.stdio.server.mcpserverstdio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseTools {
    private static final Logger log = LoggerFactory.getLogger(CourseTools.class);

    private final CourseRepository courseRepository;

    public CourseTools(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Tool(name = "get_all_courses", description = "Get all available learning courses")
    public List<Course> getAllCourses() {
        log.info("Fetching all courses");
        return courseRepository.findAll();
    }

    @Tool(name = "search_courses", description = "Search courses by title keyword")
    public List<Course> searchCourses(String title) {
        log.info("Searching courses with title keyword: {}", title);
        return courseRepository.findByTitleContainingIgnoreCase(title);
    }

    @Tool(name = "get_courses_by_category", description = "Get courses in a specific category (e.g. Java, Spring Boot, DevOps, Generative AI)")
    public List<Course> getCoursesByCategory(String category) {
        log.info("Fetching courses by category: {}", category);
        return courseRepository.findByCategoryIgnoreCase(category);
    }

    @Tool(name = "get_course_by_title", description = "Get details of a specific course by its exact title")
    public Course getCourseByTitle(String title) {
        log.info("Fetching course by exact title: {}", title);
        return courseRepository.findByTitle(title).orElse(null);
    }
}
