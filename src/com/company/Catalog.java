package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
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

    /**
     * Prints all degrees of a specified major.
     * @param nameParam the name of the major
     */
    public void printMajors(String nameParam) {
        System.out.println("List of " + nameParam + " degrees");
        System.out.println("----------------------------------");
        for (Degree d : degreeList_) {
            if (d.getDegreeName_().toLowerCase().contains(nameParam.toLowerCase())) {
                System.out.println(d.toString());
            }
        }
    }

    /**
     * Prints all courses with a specified number of units.
     * @param unitParam the units a course should have if printed
     */
    public void printCoursesByUnits(int unitParam) {
        for (Course course : courseList_) {
            if (course.getUnits_() == unitParam)
                System.out.println(course);
        }
    }

    /**
     * Prints all degrees that contain at least one course in a list of courses.
     * @param courseIDs the list of courses
     */
    public void printAllDegreesWithCourses(ArrayList<String> courseIDs) {
        for (Degree degree : degreeList_) {
            for (String id : courseIDs) {
                if (degree.getCourseList_().contains(id)) {
                    System.out.println(degree);
                    break;
                }
            }
        }
    }

    public void printDegreesWithAllCourses(ArrayList<String> courseIDs) {

        for (Degree degree : degreeList_) {
            boolean allCoursesApply = true;
            for (String id : courseIDs) {
                if (!degree.getCourseList_().contains(id)) {
                    allCoursesApply = false;
                    break;
                }
            }
            if (allCoursesApply) {
                System.out.println(degree);
            }
        }
    }
}
