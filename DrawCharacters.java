/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

public class DrawCharacters {
    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);

            }
            for (int k = 6; k > i; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 6; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                System.out.print(j);

            }
            for (int k = 6; k >= i; k--) {
                System.out.print("&");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("@");
        for (int i = 5; i >= 1; i--) {
            System.out.print("@");
            for (int j = 5; j >= i; j--) {
                System.out.print(" ");

            }
            System.out.println("@");
        }
        for (int k = 4; k > 0; k--) {
            System.out.print("@ ");
        }
    }

}
