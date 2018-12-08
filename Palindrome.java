/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(3 / 10);

        Scanner scanner = new Scanner(System.in);
        // int number = scanner.nextInt();
        int[] numbers = { 1, 3, 20, 22, 102, 101, 1221, 13321, 13331, 0, 11 };

        for (int number : numbers) {
            System.out.println("Does number : " + number + " is a palindrome? " + isPalindrome(number));
        }
    }

    private static boolean isPalindrome(int number) {
        if (number == reverse(number)) {
            return true;
        }
        return false;
    }

    private static int reverse(int number) {
        int reverse = 0;

        while (number != 0) {
            reverse = reverse * 10 + number % 10;
            number = number / 10;
        }

        return reverse;
    }

}
