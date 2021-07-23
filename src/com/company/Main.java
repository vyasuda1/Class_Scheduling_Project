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
	    while (!input.equals("8")) {
	        System.out.println("\nMain Menu");
	        System.out.println("-------------------------------------------------------------");
	        System.out.println("1. Search for Major"); //example: Math -AST, BS, COA, etc.
            System.out.println("2. List All Degrees");
            System.out.println("3. List All Courses");
            System.out.println("4. See All Degrees a List of Courses Applies Toward");
            System.out.println("5 See Degrees All Courses in a List Applies Toward");
            System.out.println("6. See Courses Ordered from Most Used in a Major to Least");
            System.out.println("7. List all courses with a certain number of units");
	        System.out.println("8. Quit");
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
                    input4 = in.next();
                    if (!input4.equals("Q")) {
                        listOfCourses.add(input4);
                    }
                }
                myCatalog.printAllDegreesWithCourses(listOfCourses);
            }
            else if (input.equals("5")) {
                String input4 = "";
                ArrayList<String> listOfCourses = new ArrayList<>();
                while (!input4.equals("Q")) {
                    System.out.print("Course ID: ");
                    input4 = in.next();
                    if (!input4.equals("Q")) {
                        listOfCourses.add(input4);
                    }
                }
                myCatalog.printDegreesWithAllCourses(listOfCourses);
            }
            else if (input.equals("6")) {
                //establish counters for each course, reorder it according to that in the array list, and display
                //environmental, aerospace, mechanical
                //main goal: figure out best courses to take
                //1. search through school database and see if each school provides one of the above majors
                //2. after making the list, go through each articulation agreement and list out ohlone classes that apply towards the major
                //3. put values next to all classes applying to each major that represent how many degrees require a particular class.
                //4. sort each class by the value (occurrences) from most to least
                //5. classes that apply toward more schools have higher priority

                // ["a", "b", "c", "b", "b", "a"]
                // hashmap<product, occurrence>
                //        if (hashmap contains a product) { increment the value }
                //        else { add the product to the hashmap, set value to 1 }
            }
            else if (input.equals("7")) {
                System.out.print("Specify the number of units: ");
                myCatalog.printCoursesByUnits(in.nextInt());
            }
            else if (input.equals("8")) {
                System.out.println("Goodbye!");
            }
            else {
                System.out.println("Error: invalid input. Type a single letter to choose an option.");
            }
        }

    }
}
