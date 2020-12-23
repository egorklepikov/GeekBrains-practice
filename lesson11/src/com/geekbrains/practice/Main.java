package com.geekbrains.practice;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<String> words = fillArrayList();
    Set<String> uniqueWords = findUniqueWords(words);
    Map<String, Integer> wordsOccurrences = findOccurrences(words);
    printResult(words, uniqueWords, wordsOccurrences);
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

  private static void printResult(List<String> words, Set<String> uniqueWords, Map<String, Integer> wordsInformation) {
    System.out.println(words);
    System.out.println(uniqueWords);
    System.out.println(wordsInformation);
  }
}
