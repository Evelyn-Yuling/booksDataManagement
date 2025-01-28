/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  evely
 * Created: Jan 27, 2025
 */
DROP DATABASE IF EXISTS recipients;

CREATE DATABASE recipients;

USE recipients;

CREATE TABLE recipients
(
   AwardID INT NOT NULL PRIMARY KEY,
   Name varchar(80) NOT NULL,
   Year Int NOT NULL,
   City varchar(30) Not Null,
   Category varchar(30) Not Null
);




INSERT INTO recipients (AwardID, Name, Year, City, Category) VALUES
(1, 'John Smith', 1987, 'New York', 'Science'),
(2, 'Jane Doe', 1988, 'Los Angeles', 'Literature'),
(3, 'Michael Brown', 1989, 'Chicago', 'Art'),
(4, 'Sarah Johnson', 1990, 'Houston', 'Technology'),
(5, 'David Wilson', 1991, 'Phoenix', 'Innovation'),
(6, 'Emily Davis', 1992, 'Philadelphia', 'Education'),
(7, 'James Miller', 1993, 'San Antonio', 'Healthcare'),
(8, 'Anna Martinez', 1994, 'San Diego', 'Engineering'),
(9, 'Robert Anderson', 1995, 'Dallas', 'Mathematics'),
(10, 'Jessica Taylor', 1996, 'San Jose', 'Environment'),
(11, 'Daniel Lee', 1997, 'Austin', 'Science'),
(12, 'Laura Harris', 1998, 'Fort Worth', 'Literature'),
(13, 'Mark Clark', 1999, 'Columbus', 'Art'),
(14, 'Sophia Walker', 2000, 'San Francisco', 'Technology'),
(15, 'Anthony Hall', 2001, 'Charlotte', 'Innovation'),
(16, 'Olivia Allen', 2002, 'Seattle', 'Education'),
(17, 'Christopher Young', 2003, 'Denver', 'Healthcare'),
(18, 'Isabella King', 2004, 'Washington', 'Engineering'),
(19, 'Andrew Wright', 2005, 'Boston', 'Mathematics'),
(20, 'Emma Scott', 2006, 'El Paso', 'Environment'),
(21, 'Matthew Green', 2007, 'Detroit', 'Science'),
(22, 'Sophia Baker', 2008, 'Memphis', 'Literature'),
(23, 'Ethan Adams', 2009, 'Nashville', 'Art'),
(24, 'Mia Nelson', 2010, 'Portland', 'Technology'),
(25, 'Alexander Perez', 2011, 'Oklahoma City', 'Innovation'),
(26, 'Ava Torres', 2012, 'Las Vegas', 'Education'),
(27, 'Benjamin Ramirez', 2013, 'Louisville', 'Healthcare'),
(28, 'Charlotte Sanchez', 2014, 'Baltimore', 'Engineering'),
(29, 'William Rivera', 2015, 'Milwaukee', 'Mathematics'),
(30, 'Abigail Bell', 2016, 'Albuquerque', 'Environment');                                                   ;

