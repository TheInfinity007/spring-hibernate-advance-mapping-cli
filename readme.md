

# OneToOneMapping

```
CREATE TABLE `instructor_detail` (
	`id` int NOT NULL AUTO_INCREMENT,
	`youtube_channel` varchar(128) DEFAULT NULL,
	`hobby` varchar(128) DEFAULT NULL,
	Primary Key(`id`)
) Engine=InnoDB AUTO_INCREMENT=1 charset = latin1;
```
```
CREATE TABLE `instructor` (
	`id` int AUTO_INCREMENT NOT NULL,
	`first_name` varchar(45) DEFAULT NULL,
	`last_name`varchar(45) DEFAULT NULL,
	`email`varchar(45) DEFAULT NULL,
	`instructor_detail_id` int DEFAULT NULL,
	PRIMARY KEY(`id`),
	KEY `FK_DETAIL_idx` (`instructor_detail_id`),
	CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`)
	REFERENCES `instructor_detail`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) Engine=InnoDB AUTO_INCREMENT=1 Charset=Latin1;
```


# ManyToOne or OneToMany Mapping
``` SQL
CREATE TABLE `course` (
    `id` int AUTO_INCREMENT NOT NULL,
    `title` varchar(256) DEFAULT NULL,
    `instructor_id` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `TITLE_UNIQUE` (`title`),
    KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
    CONSTRAINT `FK_INSTRUCTOR` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) Engine = InnoDB AUTO_INCREMENT=10
```

# OneToMany
## Review Table Script
```SQL
CREATE TABLE `review` (
	`id` int NOT NULL AUTO_INCREMENT,
    `comment` varchar(256) DEFAULT NULL,
	`course_id` int DEFAULT NULL,
	PRIMARY KEY (`id`),
	KEY `FK_COURSE_ID_IDX` (`course_id`),
	CONSTRAINT `FK_COURSE` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)

	ON UPDATE NO ACTION ON DELETE NO ACTION
) engine=InnoDB
```

#ManyToMany
## Create Table
`student`
```
CREATE TABLE student (
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(45) DEFAULT NULL,
    last_name varchar(45) DEFAULT NULL,
    email varchar(45) DEFAULT NULL,
    PRIMARY KEY (id)
) Engine=InnoDB
```

## Create Join Table 
`course_student` 
```
CREATE TABLE course_student(
    course_id int NOT NULL,
    student_id int NOT NULL,
    PRIMARY KEY (course_id, student_id),
    KEY FK_STUDENT_idx (student_id),
    CONSTRAINT FK_REFERENCE_COURSE FOREIGN KEY (course_id) REFERENCES course(id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT FK_REFERENCE_STUDENT FOREIGN KEY (student_id) REFERENCES student(`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) Engine = InnoDB
```