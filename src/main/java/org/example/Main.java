package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void test(String[] args) {

    }

    public static void main(String[] args) {
        System.out.println(("For 1: "));
        for (int i = 0; i <= 10; i++) {
            System.out.print(i + ", ");
        }
        System.out.println();

        System.out.println("For 2: ");
        int i = 1;
        for (; i <= 10; ) {
            System.out.print(i + ", ");
            i++;
        }

        System.out.println("While: ");
        int j = 0;
        while (j < 10) {
            System.out.print(j + ", ");
            j++;
        }

        int m = 0;
        do {
            System.out.println(m + " Do while execution: ");
            m++;
        } while (m > 10);

        // Foreach
        List<String> list = Arrays.asList("Test 1", "Test 2", "Test 3");
        int k = 0;
        for (String item : list) {
            System.out.println("Item " + k + ": " + item);
            k++;
        }

        System.out.println("Foreach from list");
        list.forEach(item -> {
            System.out.println("Item: " + item);
        });

        list.forEach(System.out::println);

        // LOST UPDATES FROM HERE
        String testString = "ABCDEFG";
        char[] charsArr = testString.toCharArray();
        for (int f = 0; f < charsArr.length; f++) { // <------ CONTINUE
            if (charsArr[f] == 'B' || charsArr[f] == 'D')
                continue; // ---? Next iteration
            System.out.println(charsArr[f]);
            if (charsArr[f] == 'E')
                break; // --->
        }
        // <-------------BREAK
        printArr(testString);
        String testString2 = "ABCDFGHL";
        printArr(testString2);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter lines (Char 'Q' to quitq): ");
        List<String> lines = new ArrayList<>();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if ("Q".equals(line))
                break;
            lines.add(line);
        }
        System.out.println(lines);
    }

    static private boolean printArr(String value) {
        char[] charsArr = value.toCharArray();
        for (int f = 0; f < charsArr.length; f++) {
            if (charsArr[f] == 'B' || charsArr[f] == 'D')
                continue;
            System.out.println(charsArr[f]);
            if (charsArr[f] == 'E')
                break;
            if (charsArr[f] == 'G')
                return true;
        }
        // <--
        System.out.println("Exit of function");
        return false;
    } // <--
}