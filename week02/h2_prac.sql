# create table
CREATE TABLE IF NOT EXISTS courses (
                                       id bigint NOT NULL AUTO_INCREMENT,
                                       title varchar(255) NOT NULL,
                                       tutor varchar(255) NOT NULL,
                                       PRIMARY KEY (id)
);

# insert value
INSERT INTO courses (title, tutor) VALUES
                                       ('웹개발의 봄, Spring', '남병관'), ('웹개발 종합반', '이범규');

# select
SELECT * FROM courses;


# 연습퀴즈 - SQL
CREATE TABLE IF NOT EXISTS tutors (
                                  id bigint NOT NULL AUTO_INCREMENT,
                                  name varchar(255) NOT NULL,
                                  age bigint(5) NOT NULL,
                                  PRIMARY KEY (id)
);

INSERT INTO tutors (name, age) VALUES
    ('김소은', 24);

SELECT * FROM tutors;
