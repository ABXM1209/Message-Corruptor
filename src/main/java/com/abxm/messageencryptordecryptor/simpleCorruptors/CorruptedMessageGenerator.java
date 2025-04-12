package com.abxm.messageencryptordecryptor.simpleCorruptors;

import java.util.Scanner;
import java.util.Random;

public class CorruptedMessageGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter your message: ");
        String input = scanner.nextLine();

        System.out.print("Enter corruption percentage (0–100): ");
        int corruptionPercent = scanner.nextInt();

        StringBuilder corrupted = new StringBuilder(input);

        for (int i = 0; i < corrupted.length(); i++) {
            if (random.nextInt(100) < corruptionPercent && corrupted.charAt(i) != ' ') {
                corrupted.setCharAt(i, '#');
            }
        }

        System.out.println("Corrupted message: " + corrupted);
    }
}
