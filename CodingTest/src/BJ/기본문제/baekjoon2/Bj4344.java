package BJ.기본문제.baekjoon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bj4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> students = new ArrayList<>();

        ArrayList<Double> results = new ArrayList<>();
        ArrayList<Double> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            students.add(new ArrayList<>());
            String[] s = br.readLine().split(" ");

            for (String value : s) {
                students.get(i).add(Integer.parseInt(value));
            }
        }

        int totalStudent;
        double totalScore;


        for (ArrayList<Integer> student : students) {
            totalScore = 0;
            totalStudent = 0;


            for (int i = 1; i < student.size(); i++) {
                totalStudent = student.get(0);
                totalScore += (double) student.get(i);
            }

            results.add(totalScore / totalStudent);

        }

        int studentCount;

        for (int j = 0; j < n; j++) {
            ArrayList<Integer> student = students.get(j);
            totalStudent = 0;
            studentCount = 0;

            for (int i = 1; i < student.size(); i++) {
                totalStudent = student.get(0);

                if (student.get(i) > results.get(j)) {
                    studentCount++;
                }

            }

            answer.add(studentCount / (double) totalStudent * 100);

        }

        for (Double aDouble : answer) {
            System.out.printf("%.3f%%%n", aDouble);
        }

    }
}
