CREATE DATABASE IF NOT EXISTS `laboratory`
  DEFAULT CHARACTER SET utf8;
USE laboratory;

CREATE TABLE `teacher` (
  `id`               INT(11)     NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`             VARCHAR(30) NOT NULL,
  `age`              INT(8)      NOT NULL,
  `is_administrator` BOOLEAN              DEFAULT FALSE
)
  ENGINE = InnoDB;
CREATE TABLE `fault` (
  `id`          INT(10)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `time`        TIMESTAMP NOT NULL,
  `description` TEXT      NOT NULL,
  `is_checked`  BOOLEAN,
  `teacher_id`  INT(10)   NOT NULL,

  FOREIGN KEY (teacher_id) REFERENCES teacher (id)
)
  ENGINE = InnoDB;
CREATE TABLE `curriculum` (
  `id`         INT(10)     NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `start_time` TIME        NOT NULL,
  `end_time`   TIME        NOT NULL,
  `name`       VARCHAR(20) NOT NULL,
  `during`     TIME        NOT NULL,
  `date`       DATE        NOT NULL,
  `teacher_id` INT(10)     NOT NULL,
  FOREIGN KEY (teacher_id) REFERENCES teacher (id)
)
  ENGINE = InnoDB;
CREATE TABLE `signin` (
  `id`         INT(10)   NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `time`       TIMESTAMP NOT NULL,
  `teacher_id` INT(10)   NOT NULL,

  FOREIGN KEY (teacher_id) REFERENCES teacher (id)
)