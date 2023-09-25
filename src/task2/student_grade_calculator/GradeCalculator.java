package task2.student_grade_calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GradeCalculator {
    ArrayList<String> subjects;
    HashMap<String, Integer> gradeWithSubjects;
    ArrayList<String> addSubjects(int totalSubject) {
        subjects = new ArrayList<>();

        for (int i = 0; i < totalSubject; i++) {
            System.out.println("Enter Subject No. " + (i+1) + " : ");
            String subject = new Scanner(System.in).nextLine();
            subjects.add(subject);
        }
        return subjects;
    }
    HashMap<String, Integer> addMarks() {
        gradeWithSubjects = new HashMap<>();
        for (String subject : subjects) {
            System.out.println("Enter Grades of " + subject + " : ");
            int grades = new Scanner(System.in).nextInt();
            gradeWithSubjects.put(subject, grades);
        }
        return gradeWithSubjects;
    }
    void showGrades() {

        if (subjects.isEmpty() || gradeWithSubjects.isEmpty())
            System.out.println("All Data is not available");
        else {
            for (String i : subjects) {
                System.out.println(i + "\t:\t" + gradeWithSubjects.get(i)+" out of 100");
            }
        }
    }
    void showResult(){
        int totalGrades=0;
        float average;
        for (String i : subjects) totalGrades += gradeWithSubjects.get(i);

        average = totalGrades/subjects.size();
         System.out.println("\nResults are following--------+" +
                 "\nTotal Grades\t:\t"+totalGrades+"" +
                 "\nAverage\t\t:\t"+average+"" +
                 "\nPercentage\t:\t"+average+"%");
    }
    public GradeCalculator(){
        System.out.println("Enter Number of Subjects : ");
        int number = new Scanner(System.in).nextInt();

        subjects=addSubjects(number);
        gradeWithSubjects = addMarks();
        showGrades();
        showResult();
    }



}