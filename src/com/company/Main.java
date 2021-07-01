package com.company;

/**
 * Tests the Catalog, Degree, and Course classes.
 * @author Viola Yasuda and Tanya Gupta
 * @version 1.0 6/30/2021
 */
public class Main {
    public static void main(String[] args) {
	   // Degree testDegree = new Degree("testName", "testType", "testYear",
        //        "PHYS-141 CS-102 MM-102", "test comment");
	    //System.out.println(testDegree.toString());
        Catalog myCatalog = new Catalog();
        myCatalog.printDegrees();
        myCatalog.printCourses();

	    //look up different degrees
        //look up different courses
        //look at the courses inside of a degree
    }
}
