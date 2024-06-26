
import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of subjects:");
        int numSubjects = sc.nextInt();
        
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter marks obtained in subject " + (i + 1) + " (out of 100):");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / numSubjects;
        char grade = calculateGrade(averagePercentage);

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }

    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 85) {
            return 'A';
        } else if (averagePercentage >= 70) {
            return 'B';
        } else if (averagePercentage >= 55) {
            return 'C';
        } else if (averagePercentage >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
