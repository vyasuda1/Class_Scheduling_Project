package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

    public void printClassesMostUsedToLeast(String majorNameParam) {
        ArrayList<Degree> degrees = new ArrayList<>();
        for (Degree d : degreeList_) {
            if (d.getDegreeName_().toLowerCase().contains(majorNameParam.toLowerCase())) {
                degrees.add(d);
            }
        }
        HashMap<String, Integer> courseRecurrenceMap = new HashMap<>();
        for (Degree d : degrees) {
            for (String courseID : d.getCourseList_()) {
                //map has key (courseID) and value (number of times the course occurs in the list of degrees)
                //if the map already contains the name of a course
                //  increment the value of the element
                //else (if the map does not contain the course yet)
                // add course to map, set value to 1
                if (courseRecurrenceMap.containsKey(courseID)) {
                    courseRecurrenceMap.replace(courseID, courseRecurrenceMap.get(courseID) + 1);
                }
                else {
                    courseRecurrenceMap.put(courseID, 1);
                }
            }
        }
        courseRecurrenceMap = sortByValue(courseRecurrenceMap);
        for (Map.Entry<String, Integer> entry : courseRecurrenceMap.entrySet()) {
            System.out.println("Course: " + entry.getKey() +
                    ", Recurrence: " + entry.getValue());
        }

    }

    /**
     * Sorts a hashmap by value. This code was borrowed from geeksforgeeks.org.
     * Link: https://www.geeksforgeeks.org/sorting-a-hashmap-according-to-values/
     * @param hm the hashmap to sort
     * @return a sorted version of the original hashmap
     * @author geeksforgeeks.org
     */
    private HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue().compareTo(o1.getValue()) != 0) {
                    return (o2.getValue()).compareTo(o1.getValue());
                }
                else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    /**
     * Prints all courses with a specified number of units.
     * @param unitParam the units a course should have if printed
     */
    public void printCoursesByUnits(double unitParam) {
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
