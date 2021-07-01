package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Represents a Catalog.
 * @author Tanya Gupta and Viola Yasuda
 * @version 1.0 6/30/2021
 */
public class Catalog {
    private TreeSet<Degree> degreeList_;
    private TreeSet<Course> courseList_;

    /**
     * Constructs a Catalog object.
     */
    public Catalog() {
        degreeList_ = new TreeSet<>();
        courseList_ = new TreeSet<>();
        //add degrees to degreeList_ from degree.txt
        File degreeFile = new File("degrees.txt");
        try {
            //load degrees from degrees.txt
            Scanner degreeSc = new Scanner(degreeFile);
            String degreeName, degreeType, degreeYear, degreeCourseList, degreeComment;
            while (degreeSc.hasNextLine()) {
                degreeName = degreeSc.nextLine();
                degreeType = degreeSc.nextLine();
                degreeYear = degreeSc.nextLine();
                degreeCourseList = degreeSc.nextLine();
                degreeComment = degreeSc.nextLine();
                degreeList_.add(new Degree(degreeName, degreeType, degreeYear, degreeCourseList, degreeComment));
            }
            System.out.println("Loading of degrees is done!");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Loading of degrees failed.");
        }
        //add courses to courseList_ from course.txt
        File courseFile = new File("courses.txt");
        try {
            //load degrees from courses.txt
            Scanner courseSc = new Scanner(courseFile);
            String courseInfo;
            while (courseSc.hasNextLine()) {
                courseInfo = courseSc.nextLine();
                courseList_.add(new Course(courseInfo));
            }
            System.out.println("Loading of courses is done!");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Loading of courses failed.");
        }
    }

    /**
     * Prints the degrees in the catalog.
     */
    public void printDegrees() {
        for (Degree d : degreeList_) {
            System.out.println(d.toString());
        }
    }

    /**
     * Prints the courses in the catalog.
     */
    public void printCourses() {
        for (Course c : courseList_) {
            System.out.println(c.toString());
        }
    }
}
