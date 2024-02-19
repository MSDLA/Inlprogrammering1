package common;

import java.util.Scanner;

public class Morse {
    public static void main(String[] args) {
        // Skapar en Scanner för att läsa inmatning från användaren
        Scanner scanner = new Scanner(System.in);

        // Skriver ut alternativen för användaren
        System.out.println("1. Morse till Text");
        System.out.println("2. Text till Morse");
        System.out.print("Välj ett alternativ: ");

        // Läser in användarens val
        int option = scanner.nextInt();
        scanner.nextLine(); // Konsumerar ny rad

        // Utför handling baserat på användarens val
        switch (option) {
            case 1:
                // Användaren valde att konvertera morsekod till text
                System.out.print("Ange morsekod: ");
                String morse = scanner.nextLine();
                try {
                    // Försöker konvertera morsekoden till text
                    String text = MorseCodeConverter.morseToText(morse);
                    System.out.println("Text: " + text);
                } catch (IllegalArgumentException e) {
                    // Skriver ut felmeddelande om konverteringen misslyckades
                    System.out.println("Fel: " + e.getMessage());
                }
                break;
            case 2:
                // Användaren valde att konvertera text till morsekod
                System.out.print("Ange text: ");
                String textInput = scanner.nextLine();
                try {
                    // Försöker konvertera texten till morsekod
                    String morseOutput = MorseCodeConverter.textToMorse(textInput);
                    System.out.println("Morsekod: " + morseOutput);
                } catch (IllegalArgumentException e) {
                    // Skriver ut felmeddelande om konverteringen misslyckades
                    System.out.println("Fel: " + e.getMessage());
                }
                break;
            default:
                // Användaren valde ett ogiltigt alternativ
                System.out.println("Ogiltigt alternativ. Vänligen välj 1 eller 2.");
        }
        // Stänger scannern
        scanner.close();
    }
}
