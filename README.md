# Course Catalog MCP Server (STDIO)

A Model Context Protocol (MCP) Server built with **Spring Boot** and **Spring AI** that provides tools to search and retrieve course catalog data over standard I/O (STDIO) transport.

---

## 🛠️ Tech Stack & Features

- **Java Version**: 21
- **Framework**: Spring Boot 3.5.5
- **AI Integration**: Spring AI 1.0.2 (`spring-ai-starter-mcp-server`)
- **Persistence**: Spring Data JPA with in-memory H2 Database
- **Transport**: Standard I/O (STDIO)

---

## 🧰 Available MCP Tools

This MCP server registers four tools via Spring AI (`CourseTools`):

| Tool Name | Parameters | Description |
| :--- | :--- | :--- |
| `get_all_courses` | *None* | Retrieves the entire catalog of available learning courses. |
| `search_courses` | `title` (String) | Performs a case-insensitive search for courses matching a title keyword. |
| `get_courses_by_category` | `category` (String) | Filters courses by category (e.g. `Spring Boot`, `Java`, `DevOps`, `Generative AI`). |
| `get_course_by_title` | `title` (String) | Fetches full course details for an exact course title match. |

---

## 🚀 Building the Project

Ensure Java 21+ is installed on your machine.

To compile and package the executable JAR file:

```bash
./mvnw clean package -DskipTests
```

The output JAR file will be generated at:
```
target/mcp-server-stdio.jar
```

---

## 🧪 Testing with MCP Inspector

You can test and interact with the tools visually using the official `@modelcontextprotocol/inspector`.

### Option A: Via Command Line (CLI)

Run the following command from the project root directory:

```bash
npx @modelcontextprotocol/inspector java -jar target/mcp-server-stdio.jar
```

> ⚠️ **Important**: Do not enclose `-jar` and the file path inside the same string argument! Java requires them as two separate space-delimited arguments.

### Option B: Via MCP Inspector Web Interface (`http://127.0.0.1:6274`)

If launching or configuring via the Web UI:
- **Transport Type**: `STDIO`
- **Command**: `java`
- **Arguments**: Add as **two separate entries**:
  - Item 1: `-jar`
  - Item 2: `/Users/rajesh/Desktop/Java/mcpserverstdio/target/mcp-server-stdio.jar`

---

## ⚙️ Client Integration (`mcp.json`)

To connect this server to AI clients like **Claude Desktop** or **Antigravity IDE**, add the following configuration to your `claude_desktop_config.json` or `mcp.json`:

```json
{
  "mcpServers": {
    "course-catalog": {
      "command": "java",
      "args": [
        "-jar",
        "/Users/rajesh/Desktop/Java/mcpserverstdio/target/mcp-server-stdio.jar"
      ]
    }
  }
}
```

---

## 📊 Database Schema & Initial Data

The server automatically initializes an H2 database schema (`schema.sql`) on startup:

### Table Structure (`courses`)

```sql
create table courses
(
    id          bigserial    not null,
    title       varchar(255) not null unique,
    description varchar(1000),
    category    varchar(100) not null,
    url         varchar(500) not null,
    primary key (id)
);
```

### Seed Data Categories
- **Spring Boot**: Modular Monoliths, Microservices, JdbcClient
- **Java**: Modern Java 21, Testcontainers, IntelliJ IDEA tips
- **Generative AI**: LangChain4j, OpenAI, Ollama integration
- **DevOps**: Kubernetes tutorial, Docker Compose support

---

## 📁 Project Structure

```
.
├── pom.xml
├── src
│   ├── main
│   │   ├── java/com/mcp/stdio/server/mcpserverstdio
│   │   │   ├── Course.java                 # JPA Entity
│   │   │   ├── CourseRepository.java       # Spring Data JPA Repository
│   │   │   ├── CourseTools.java            # Spring AI @Tool definitions
│   │   │   └── McpserverstdioApplication.java  # Spring Boot Main Application
│   │   └── resources
│   │       ├── application.properties      # MCP & STDIO configuration
│   │       └── schema.sql                  # Database schema & sample data
└── target
    └── mcp-server-stdio.jar                # Executable Spring Boot JAR
```
