package Projects;

import java.util.Scanner;

public class Grade_Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        // Array to hold marks for each subject
        int[] marks = new int[numSubjects];
        
        // Input marks for each subject with validation
        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks for subject " + (i + 1) + " (0-100): ");
                int mark = scanner.nextInt();
                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    break;
                } else {
                    System.err.println("Invalid input. Please enter marks between 0 and 100.");
                }
            }
        }
        
        // Calculate total marks
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        
        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        
        // Calculate grade
        char grade;
        if (averagePercentage >= 80) {
            grade = 'A';
        } else if (averagePercentage >= 75) {
            grade = 'B';
        } else if (averagePercentage >= 65) {
            grade = 'C';
        } else if (averagePercentage >= 45) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        
        // Display results
        System.out.println("=================================================");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("=================================================");
        scanner.close();
        
    }
    static{
    	System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
    	System.out.println("Grade Calculator");
    	System.err.println("Disclamer : It is used to calculate the totalmarks, percentage, grade that are being obtained...");
    	System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=--=-=-=-=-=-==-=-=-=-=-=-==-==-=-=");
    	System.out.println();
    }
}
