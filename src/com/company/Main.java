package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Tests the Catalog, Degree, and Course classes.
 * @author Viola Yasuda and Tanya Gupta
 * @version 1.0 6/30/2021
 */
public class Main {
    public static void main(String[] args) {
	    Catalog myCatalog = new Catalog();
	    Scanner in = new Scanner(System.in);
	    String input = "";
	    while (!input.equals("7")) {
	        System.out.println("\nMain Menu");
	        System.out.println("-------------------------------------------------------------");
	        System.out.println("1. Search for Major"); //example: Math -AST, BS, COA, etc.
            System.out.println("2. List All Degrees");
            System.out.println("3. List All Courses");
            System.out.println("4. See All Degrees a List of Courses Applies Toward");
            System.out.println("5. See Courses Ordered from Most Used in Degrees to Least");
            System.out.println("6. List all courses with a certain number of units");
	        System.out.println("7. Quit");
            /*
            System.out.println("2. Search for Degree");
            System.out.println("3. Search for Course");
            System.out.println("4. Add Degree");
            System.out.println("5. Add Course");
            System.out.println("6. Delete Degree");
            System.out.println("7. Delete Course");
             */
	        System.out.print("Choose an option: ");
	        input = in.next();
	        in.nextLine();
	        if (input.equals("1")) {
	            System.out.print("Input the name of a major: ");
	            String input1 = in.nextLine();
	            myCatalog.printMajors(input1);
            }
	        else if (input.equals("2")) {
	            myCatalog.printDegrees();
            }
	        else if (input.equals("3")) {
	            myCatalog.printCourses();
            }
            else if (input.equals("4")) {
                String input4 = "";
                ArrayList<String> listOfCourses = new ArrayList<>();
                while (!input4.equals("Q")) {
                    System.out.print("Course ID: ");
                    //if (!input4.equals("Q"));
                }
            }
            else if (input.equals("5")) {//establish counters for each course, reorder it according to that in the array list, and display}
            else if (input.equals("6")) {}
            else if (input.equals("7")) {
                System.out.println("Goodbye!");
            }
            else {
                System.out.println("Error: invalid input. Type a single letter to choose an option.");
            }
        }

    }
}
