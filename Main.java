package edu.lab02;

import java.util.Scanner;

/**
 * Program oblicza pole powierzchni kątownika
 * @author Patryk
 * @version 1.0
 * @see CProfile
 * @see java.lang.Math
 */

public class Main {
    public static void main(String[] args) {
        CProfile K50 = new CProfile("K50x50x5", 50.0, 50.0, 5.0, 7.0, 3.5);
        CProfile K120 = new CProfile("K120x120x12", 120.0, 120.0, 12.0, 13.0, 6.5);
        CProfile K90x60 = new CProfile("K90x60x8", 90.0, 60.0, 8.0, 9.0, 4.0);

        displayResult(K50);
        displayResult(K120);
        displayResult(K90x60);

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Podaj nazwę obiektu: ");
            String name = scanner.nextLine();
            System.out.print("Podaj A: ");
            double A = Double.parseDouble(scanner.nextLine());
            System.out.print("Podaj B: ");
            double B = Double.parseDouble(scanner.nextLine());
            System.out.print("Podaj G: ");
            double G = Double.parseDouble(scanner.nextLine());
            System.out.print("Podaj R: ");
            double R = Double.parseDouble(scanner.nextLine());
            System.out.print("Podaj R1: ");
            double R1 = Double.parseDouble(scanner.nextLine());

            CProfile profile = new CProfile(name, A, B, G, R, R1);

            displayResult(profile);

            System.out.print("Czy chcesz kontynuować obliczenia? (Tak/Nie): ");
            String choice = scanner.nextLine();

            if (!choice.equalsIgnoreCase("Tak")) {
                break;
            }
        } while (true);
    }

    private static void displayResult(CProfile profile) {
        System.out.println("Wartość normy: " + CProfile.getStandard());

        System.out.println("Wynik (Double): " + profile.getResult());
        System.out.println("Wynik z dokładnością do 1 miejsca po przecinku: ");
        System.out.println(profile.getResult(1));

        System.out.println("Wynik z dokładnością do 2 miejsca po przecinku: ");
        System.out.println(profile.getResult(2));

        System.out.println("Wynik z dokładnością do 3 miejsca po przecinku: ");
        System.out.println(profile.getResult(3));

        System.out.println();
    }
}