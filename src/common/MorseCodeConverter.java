package common;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeConverter {
    // Skapar en statisk karta för att mappa mellan bokstäver och morsekod
    private static final Map<String, String> bidirectionalMap = new HashMap<>();

    static {
        // Initialiserar kartan med mappningar mellan bokstäver och morsekod
        bidirectionalMap.put("A", ".-");
        bidirectionalMap.put("B", "-...");
        bidirectionalMap.put("C", "-.-.");
        bidirectionalMap.put("D", "-..");
        bidirectionalMap.put("E", ".");
        bidirectionalMap.put("F", "..-.");
        bidirectionalMap.put("G", "--.");
        bidirectionalMap.put("H", "....");
        bidirectionalMap.put("I", "..");
        bidirectionalMap.put("J", ".---");
        bidirectionalMap.put("K", "-.-");
        bidirectionalMap.put("L", ".-..");
        bidirectionalMap.put("M", "--");
        bidirectionalMap.put("N", "-.");
        bidirectionalMap.put("O", "---");
        bidirectionalMap.put("P", ".--.");
        bidirectionalMap.put("Q", "--.-");
        bidirectionalMap.put("R", ".-.");
        bidirectionalMap.put("S", "...");
        bidirectionalMap.put("T", "-");
        bidirectionalMap.put("U", "..-");
        bidirectionalMap.put("V", "...-");
        bidirectionalMap.put("W", ".--");
        bidirectionalMap.put("X", "-..-");
        bidirectionalMap.put("Y", "-.--");
        bidirectionalMap.put("Z", "--..");
        bidirectionalMap.put("0", "-----");
        bidirectionalMap.put("1", ".----");
        bidirectionalMap.put("2", "..---");
        bidirectionalMap.put("3", "...--");
        bidirectionalMap.put("4", "....-");
        bidirectionalMap.put("5", ".....");
        bidirectionalMap.put("6", "-....");
        bidirectionalMap.put("7", "--...");
        bidirectionalMap.put("8", "---..");
        bidirectionalMap.put("9", "----.");
    }

    // Metod för att konvertera text till morsekod
    public static String textToMorse(String text) {
        // Skapar en StringBuilder för att bygga upp morsekoden
        StringBuilder morseCode = new StringBuilder();
        // Itererar över varje tecken i texten
        for (char c : text.toUpperCase().toCharArray()) {
            // Kontrollerar om tecknet finns i kartan
            if (bidirectionalMap.containsKey(String.valueOf(c))) {
                // Lägger till motsvarande morsekod till morseCode
                morseCode.append(bidirectionalMap.get(String.valueOf(c))).append(" ");
            } else if (Character.isWhitespace(c)) {
                // Lägger till ett "/" för att representera ett mellanslag
                morseCode.append("/ ");
            } else {
                // Kastar ett undantag om tecknet inte finns i kartan
                throw new IllegalArgumentException("Ogiltigt tecken: " + c);
            }
        }
        // Returnerar den färdiga morsekoden som en sträng
        return morseCode.toString().trim();
    }

    // Metod för att konvertera morsekod till text
    public static String morseToText(String morse) {
        // Skapar en StringBuilder för att bygga upp texten
        StringBuilder text = new StringBuilder();
        // Delar upp morsekoden i separata ord
        String[] words = morse.split("\\s+/\\s+");
        for (String word : words) {
            // Delar upp varje ord i separata bokstäver
            String[] letters = word.split("\\s+");
            for (String letter : letters) {
                // Kontrollerar om morsebokstaven finns i kartan
                if (bidirectionalMap.containsValue(letter)) {
                    // Hittar nyckeln som är associerad med morsebokstaven
                    for (String key : bidirectionalMap.keySet()) {
                        if (bidirectionalMap.get(key).equals(letter)) {
                            // Lägger till motsvarande bokstav till text
                            text.append(key);
                            break;
                        }
                    }
                } else {
                    // Kastar ett undantag om morsebokstaven inte finns i kartan
                    throw new IllegalArgumentException("Ogiltig morsekod: " + letter);
                }
            }
            // Lägger till ett mellanslag mellan orden
            text.append(" ");
        }
        // Returnerar den färdiga texten som en sträng
        return text.toString().trim();
    }
}
