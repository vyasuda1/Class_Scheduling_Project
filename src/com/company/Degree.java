package com.company;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Represents a degree.
 * @author Viola Yasuda and Tanya Gupta
 * @version 1.0 6/30/2021
 */
public class Degree implements Comparable {
    private final String degreeName_;
    private final String degreeType_;
    private final String catalogYear_;
    private TreeSet<String> courseList_; //make a TreeSet of Courses later
    private final String comment_;

    /**
     * Constructs a degree object
     * @param nameParam the degree name
     * @param typeParam the type of degree
     * @param yearParam the catalog year for the degree
     * @param courseListParam the list of courses required by the degree
     * @param commentParam any comments regarding the degree
     */
    public Degree(String nameParam, String typeParam, String yearParam, String courseListParam, String commentParam) {
        degreeName_ = nameParam;
        degreeType_ = typeParam;
        catalogYear_ = yearParam;
        comment_ = commentParam;

        courseList_ = new TreeSet<>();
        Scanner sc = new Scanner(courseListParam);
        while (sc.hasNext()) {
            courseList_.add(sc.next());
        }
    }

    /**
     * Gets the name of the degree.
     * @return the degree name
     */
    public String getDegreeName_() {
        return degreeName_;
    }

    /**
     * Creates a string with the degree's information.
     * @return string version of the degree
     */
    @Override
    public String toString() {
        return "Name: " + degreeName_ +
                "\nType: " + degreeType_ +
                "\nYear: " + catalogYear_ +
                "\nCourse List: " + courseList_ +
                "\nComment: " + comment_ + "\n";
    }

    /**
     * Compares this degree with another degree for ordering purposes.
     * @param o the other degree
     * @return a negative value if this degree should come before o when being ordered, a positive value if this degree
     * should come after o when being ordered, and 0 if this degree equals o
     */
    @Override
    public int compareTo(Object o) {
        Degree otherDegree = (Degree) o;
        return degreeName_.compareTo(otherDegree.getDegreeName_());
    }
}
