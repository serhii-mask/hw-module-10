package task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequencyCounter {
    public static List<String> countWordFrequency(String filename) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.trim().split("\\s+");
                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, Integer>> sortedFrequency = new ArrayList<>(wordFrequency.entrySet());
        sortedFrequency.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedFrequency) {
            result.add(entry.getKey() + " " + entry.getValue());
        }

        return result;
    }
}
