



create table professor (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    department varchar(255)
);

create table course (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    credits INTEGER,
    professorId INTEGER,
    FOREIGN KEY (professorId) REFERENCES Professor(id)
);

create table student (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    email varchar(255)
);

create table course_student (
    studentId INTEGER,
    courseId INTEGER,
    PRIMARY KEY (studentId, courseId),
    FOREIGN KEY (studentId) REFERENCES student(id),
    FOREIGN KEY (courseId) REFERENCES course(id)
);









































