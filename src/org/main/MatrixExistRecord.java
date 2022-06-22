package org.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixExistRecord {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<List<Integer>> list = new ArrayList();
        List<List<Integer>> numberOfQueries = new ArrayList<>();

        int numberOfRows = scanner.nextInt();
        for (int i = 0; i < numberOfRows; i++) {
            int numberofnumbersInRow = scanner.nextInt();
            List<Integer> tempList = new ArrayList();
            for (int j = 0; j < numberofnumbersInRow; j++) {
                tempList.add(scanner.nextInt());
            }
            list.add(tempList);
        }
        int numberofQueries = scanner.nextInt();
        for (int i = 0; i < numberofQueries; i++) {

            List<Integer> query = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                query.add(scanner.nextInt());
            }
            numberOfQueries.add(query);
        }
        printOutput(list, numberOfQueries);
    }

    private static void printOutput(List<List<Integer>> list, List<List<Integer>> numberOfQueries) {
        for (int i = 0; i < numberOfQueries.size(); i++) {
            List<Integer> query = numberOfQueries.get(i);
            Integer val1 = query.get(0);
            Integer val2 = query.get(1);
            try {
                List<Integer> row = list.get(val1 - 1);
                Integer requiredValue = row.get(val2 - 1);
                if (requiredValue == null) {
                    System.out.println("ERROR!\n");
                } else {
                    System.out.println(requiredValue);
                }
            } catch (Exception exception) {
                System.out.println("ERROR!\n");
            }
        }
    }

}
