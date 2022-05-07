package ru.nsu.dyuganov.automatatheory3;

import com.google.common.collect.Multimap;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static HashSet<Character> N;
    private static HashSet<Character> T;
    private static Multimap<String, Character> P;
    private static Character S;

    public static void main (String[] args) {
        System.out.println("Enter Context Free Grammar:");

        Parser parser = new Parser();
        N = parser.parseN();
        T = parser.parseT(N);
        P = parser.parseP(N, T);
        S = parser.parseS(N);

        Tree storage = new Tree(N,T,P,S);

        System.out.println("\nEnter a string to recognize from the characters of the set ∑");
        String innerStr;
        while (true) {
            boolean flag = false;
            innerStr = scanner.nextLine();
            for (char c:innerStr.toCharArray()) {
                if (!T.contains(c)) {
                    System.out.println("∑ does not contain the specified character");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        boolean result = storage.syntaxAnalyzer(innerStr);
        System.out.println("\n____________________________________________");
        System.out.println(result ? "Success" : "Failure");

    }
}

