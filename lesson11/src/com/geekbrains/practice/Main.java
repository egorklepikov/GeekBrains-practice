package com.geekbrains.practice;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<String> words = fillArrayList();
    Set<String> uniqueWords = findUniqueWords(words);
    Map<String, Integer> wordsOccurrences = findOccurrences(words);
    System.out.println(words);
    System.out.println(uniqueWords);
    System.out.println(wordsOccurrences);

    PhoneHandbook phoneHandbook = new PhoneHandbook();
    phoneHandbook.add("Klepikov", "12345678");
    phoneHandbook.add("Gavrilov", "12345678");
    phoneHandbook.add("Klepikov", "87654321");
    phoneHandbook.add("Grigoriev", "12345678");
    phoneHandbook.add("Grigoriev", "12312");
    phoneHandbook.add("Grigoriev", "1576");
    System.out.println(phoneHandbook.get("Klepikov"));
    System.out.println(phoneHandbook.get("Grigoriev"));
    System.out.println(phoneHandbook.get("Gavrilov"));
  }

  private static Map<String, Integer> findOccurrences(List<String> words) {
    Map<String, Integer> occurrences = new HashMap<>();
    for (String word : words) {
      occurrences.put(word, Collections.frequency(words, word));
    }
    return occurrences;
  }

  private static Set<String> findUniqueWords(List<String> words) {
    return new HashSet<>(words);
  }

  private static List<String> fillArrayList() {
    List<String> words = new ArrayList<>();
    int wordsNumber = 20;
    for (int i = 0; i < wordsNumber; i++) {
      String word;
      if (i % 2 == 0) {
        word = "word" + i;
      } else {
        word = "word";
      }
      words.add(word);
    }
    return words;
  }
}
