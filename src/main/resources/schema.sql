create table courses
(
    id          bigserial    not null,
    title       varchar(255) not null unique,
    description varchar(1000),
    category    varchar(100) not null,
    url         varchar(500) not null,
    primary key (id)
);

insert into courses(title, description, category, url) VALUES
('Spring Modulith Crash Course : Building Modular Monoliths', 'Learn how to build clean, maintainable modular monoliths using Spring Modulith and Spring Boot.', 'Spring Boot', 'https://www.youtube.com/watch?v=FkP2aZiBrhg'),
('Spring Boot Microservices Complete Tutorial', 'Comprehensive guide to building microservices with Spring Boot, Spring Cloud, and API Gateway.', 'Spring Boot', 'https://www.youtube.com/watch?v=ZKQWwCUEABY'),
('Getting Started with Generative AI using Java, LangChain4j, OpenAI and Ollama', 'Build AI-powered applications in Java using Spring AI, LangChain4j, and local Ollama LLMs.', 'Generative AI', 'https://www.youtube.com/watch?v=ld0ZU6bd9bM'),
('Modern Spring Boot Application Development using Java 21 and Testcontainers', 'Supercharge Java integration testing with Testcontainers and modern Java features.', 'Java', 'https://www.youtube.com/watch?v=q2LSz7cnC1g'),
('Spring Boot + Kubernetes Tutorial Series : Introduction', 'Learn how to containerize and deploy Spring Boot microservices to Kubernetes clusters.', 'DevOps', 'https://www.youtube.com/watch?v=pGbBuwzyiV4'),
('IntelliJ IDEA Tips for Java Developers - Code Faster', 'Essential IntelliJ keyboard shortcuts, live templates, and debugging strategies for Java devs.', 'Java', 'https://www.youtube.com/watch?v=Kiry69tEIOE'),
('Spring JdbcClient: A better alternative to JdbcTemplate', 'Explore Spring 6.1 JdbcClient for cleaner, functional database access in Java.', 'Spring Boot', 'https://youtu.be/oF7vlaJhySE'),
('Spring Boot Docker Compose Support : Local Development Made Simple', 'Use Spring Boot Docker Compose integration to launch PostgreSQL, Redis, and Kafka automatically.', 'DevOps', 'https://www.youtube.com/watch?v=PZt5EJTLH4o');