package org.slackyogi.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputManager {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntInput() throws IllegalArgumentException {
        int input;

        if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            try {
                scanner.nextLine();
            } catch (NoSuchElementException ex) {
                // TODO As I modified input stream in testing class this was required. Do it better.
            }
            return input;
        }
        else {
            try {
                scanner.nextLine();
            } catch (NoSuchElementException ex) {
                // TODO As I modified input stream in testing class this was required. Do it better.
            }
            throw new IllegalArgumentException();
        }
    }
}
