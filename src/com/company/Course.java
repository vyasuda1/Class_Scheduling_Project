package com.company;

import java.util.Scanner;

/**
 * Represents a course at Ohlone College. Contains a course ID, a name, and a number of semester units.
 * @author Viola Yasuda
 * @version 1.0 6/30/2021
 */
public class Course implements Comparable {
    private final String courseID_;
    private final String courseName_;
    private final double units_;
    private int occurrencesInDegrees_;

    /**
     * Constructs a Course object.
     * @param idParam the course id
     * @param nameParam the course name
     * @param unitsParam the number of units the course is worth
     */
    public Course(String idParam, String nameParam, double unitsParam) {
        courseID_ = idParam;
        courseName_ = nameParam;
        units_ = unitsParam;
    }

    /**
     * Constructs a Course object given the course information.
     * @param info the course information
     */
    public Course(String info) {
        String tempInfo = info.substring(0, info.length() - 1);
        Scanner sc = new Scanner(tempInfo);
        courseID_ = sc.next();
        courseName_ = sc.nextLine().trim();
        units_ = Integer.parseInt(info.substring(info.length() - 1));
    }

    /**
     * Gets the course ID.
     * @return the course's ID
     */
    public String getCourseID_() {
        return courseID_;
    }

    /**
     * Gets the course's name.
     * @return the course's name
     */
    public String getCourseName_() {
        return courseName_;
    }

    /**
     * Gets the number of units the course is worth.
     * @return the number of units
     */
    public double getUnits_() {
        return units_;
    }

    /**
     * Produces a string containing all the information about the course
     * @return a string with the course's ID, name, and units
     */
    @Override
    public String toString() {
        return "" + courseID_ + " " + courseName_ + " (" + units_ + ")";
    }

    /**
     * Compares this course with another.
     * @param o the other course
     * @return a value < 0 if this course is < o, a value > 0 if this course is > o, and 0 if this course = o
     */
    @Override
    public int compareTo(Object o) {
        Course otherCourse = (Course) o;
        return courseID_.compareTo(otherCourse.getCourseID_());
    }
}
