package task3;

import java.util.List;

import static task3.WordFrequencyCounter.countWordFrequency;

public class WordFrequencyCounterTests {
    public static void main(String[] args) {
        List<String> frequencyResult = countWordFrequency("C:\\Users\\serhi\\Documents\\java\\homeWorks\\hw-module-10\\src\\main\\java\\files\\words.txt");
        for (String item : frequencyResult) {
            System.out.println(item);
        }
    }
}