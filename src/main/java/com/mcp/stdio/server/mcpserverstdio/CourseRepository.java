package com.mcp.stdio.server.mcpserverstdio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByTitle(String title);

    List<Course> findByTitleContainingIgnoreCase(String title);

    List<Course> findByCategoryIgnoreCase(String category);
}
