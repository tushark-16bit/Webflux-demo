CREATE TABLE IF NOT EXISTS tasks (
    id IDENTITY PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(1000),
    completed BOOLEAN DEFAULT FALSE,
    create_at TIMESTAMP,
    due_date TIMESTAMP
);