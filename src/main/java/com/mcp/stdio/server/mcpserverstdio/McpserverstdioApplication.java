package com.mcp.stdio.server.mcpserverstdio;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class McpserverstdioApplication {

	public static void main(String[] args) {
		SpringApplication.run(McpserverstdioApplication.class, args);
	}

	@Bean
	public List<ToolCallback> toolCallbacks(CourseTools courseTools) {
		return List.of(ToolCallbacks.from(courseTools));
	}

}
