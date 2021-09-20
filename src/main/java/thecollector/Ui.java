package thecollector;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ui {
    public static String formatGarageListString(Garage garage) {
        return String.format("Cars in %s", garage.getName());
    }

    public static String promptPlayerName() {
        System.out.println("Welcome to The Collector. What is your name?");
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextLine();
        } catch (NoSuchElementException e) {
            return promptPlayerName();
        }
    }
}
