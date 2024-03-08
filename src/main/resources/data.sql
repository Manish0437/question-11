-- -- Inserting data into Professor table
-- INSERT INTO professor (id, name, department) VALUES (1, 'John Smith', 'Computer Science');
-- INSERT INTO professor (id, name, department) VALUES (2, 'Mary Johnson', 'Physics');
-- INSERT INTO professor (id, name, department) VALUES (3, 'David Lee', 'Mathematics');

-- -- Inserting data into Course table
-- INSERT INTO course (id, name, credits, professorId) VALUES (1, 'Introduction to Programming', 3, 1);
-- INSERT INTO course (id, name, credits, professorId) VALUES (2, 'Quantum Mechanics', 4, 2);
-- INSERT INTO course (id, name, credits, professorId) VALUES (3, 'Calculus', 4, 3);

-- -- Inserting data into Student table
-- INSERT INTO student (id, name, email) VALUES (1, 'Alice Johnson', 'alice@example.com');
-- INSERT INTO student (id, name, email) VALUES (2, 'Bob Davis', 'bob@example.com');
-- INSERT INTO student (id, name, email) VALUES (3, 'Eva Wilson', 'eva@example.com');

-- -- Inserting data into Junction table
-- INSERT INTO course_student (courseId, studentId) VALUES (1, 1);
-- INSERT INTO course_student (courseId, studentId) VALUES (1, 2);
-- INSERT INTO course_student (courseId, studentId) VALUES (2, 2);
-- INSERT INTO course_student (courseId, studentId) VALUES (2, 3);
-- INSERT INTO course_student (courseId, studentId) VALUES (3, 1);
-- INSERT INTO course_student (courseId, studentId) VALUES (3, 3);





-- Inserting data into Professor table
INSERT INTO professor (name, department) VALUES ('John Smith', 'Computer Science');
INSERT INTO professor (name, department) VALUES ('Mary Johnson', 'Physics');
INSERT INTO professor (name, department) VALUES ('David Lee', 'Mathematics');

-- Inserting data into Course table
INSERT INTO course (name, credits, professorId) VALUES ('Introduction to Programming', 3, 1);
INSERT INTO course (name, credits, professorId) VALUES ('Quantum Mechanics', 4, 2);
INSERT INTO course (name, credits, professorId) VALUES ('Calculus', 4, 3);

-- Inserting data into Student table
INSERT INTO student (name, email) VALUES ('Alice Johnson', 'alice@example.com');
INSERT INTO student (name, email) VALUES ('Bob Davis', 'bob@example.com');
INSERT INTO student (name, email) VALUES ('Eva Wilson', 'eva@example.com');

-- Inserting data into Junction table
INSERT INTO course_student (courseId, studentId) VALUES (1, 1);
INSERT INTO course_student (courseId, studentId) VALUES (1, 2);
INSERT INTO course_student (courseId, studentId) VALUES (2, 2);
INSERT INTO course_student (courseId, studentId) VALUES (2, 3);
INSERT INTO course_student (courseId, studentId) VALUES (3, 1);
INSERT INTO course_student (courseId, studentId) VALUES (3, 3);





