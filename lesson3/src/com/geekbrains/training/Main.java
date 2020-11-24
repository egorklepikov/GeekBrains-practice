package com.geekbrains.training;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    boolean isGameSelected = false;
    while (!isGameSelected) {
      System.out.print("Enter game name: ");
      switch (scanner.nextLine().toLowerCase()) {
        case "guess number":
          isGameSelected = true;
          playGuessNumber();
          break;
        case "guess word":
          isGameSelected = true;
          playGuessWord();
          break;
        default:
          System.out.println("The game name is wrong. Try again.");
          System.out.println("-------------------------------------------------");
      }
    }
  }

  private static void playGuessNumber() {
    printGuessNumbersRules();
    boolean isGameWon = guessNumberGameProcess();
    guessNumberGameResult(isGameWon);
  }

  private static void printGuessNumbersRules() {
    System.out.println("----------------------------------------------------------------------");
    System.out.println("" +
        "The goal is to guess the number. " +
        "Each time you specified wrong number the console will guide you to the right direction. \n" +
        "You have only 3 attempts. Good luck!"
    );
    System.out.println("-----------------------------------------------------------------------");
  }

  private static boolean guessNumberGameProcess() {
    int expectedNumber = new Random().nextInt(10);
    boolean isGameWon = false;

    int attemptsNumber = 3;
    while (attemptsNumber != 0) {
      attemptsNumber--;
      System.out.print("Enter number: ");
      int inputNumber = scanner.nextInt();
      if (inputNumber == expectedNumber) {
        isGameWon = true;
        break;
      } else if (inputNumber > expectedNumber && attemptsNumber != 0) {
        System.out.println("Try again. Expected number is less than you specified.");
      } else if (inputNumber < expectedNumber && attemptsNumber != 0) {
        System.out.println("Try again. Expected number is more than you specified.");
      }
    }

    System.out.println("-----------------------------------------------------------------------");

    return isGameWon;
  }

  private static void guessNumberGameResult(boolean isGameWon) {
    if (isGameWon) {
      System.out.println("Congratulations! You guessed the number.");
    } else {
      System.out.print("You lose. Would you like to try again? (1 - yes / 0 - no): ");
      if (scanner.nextInt() == 1) {
        clearConsole();
        playGuessNumber();
      } else {
        System.out.println("Have a nice day!");
      }
    }
  }

  private static void clearConsole() {
    String systemName = System.getProperty("os.name");
    try {
      if (systemName.contains("Windows")) {
        Runtime.getRuntime().exec("cls");
      } else {
        Runtime.getRuntime().exec("clear");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void playGuessWord() {
    String[] words = {
        "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic",
        "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
        "pineapple", "pumpkin", "potato"
    };

    printGuessWordsRules(words);
    guessWordsGameProcess(words);
  }

  private static void guessWordsGameProcess(String[] words) {
    String selectedWord = selectWord(words);
    String inputWord;
    do {
      System.out.print("Enter word: ");
      inputWord = scanner.nextLine();
      if (inputWord.equals(selectedWord)) {
        printGuessWordResult();
      } else {
        String hint = getHint(inputWord, selectedWord);
        showHint(hint);
      }
    } while (!inputWord.equals(selectedWord));
  }

  private static String selectWord(String[] words) {
    return words[new Random().nextInt(words.length)];
  }

  private static String getHint(String inputWord, String selectedWord) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int selectedCharIndex = 0; selectedCharIndex < selectedWord.length(); selectedCharIndex++) {
      if (selectedCharIndex < inputWord.length()) {
        char selectedWordChar = selectedWord.charAt(selectedCharIndex);
        if (selectedWordChar == inputWord.charAt(selectedCharIndex)) {
          stringBuilder.append(selectedWordChar);
        } else {
          stringBuilder.append('#');
        }
      }
    }
    addMask(stringBuilder);
    return stringBuilder.toString().toLowerCase();
  }

  private static void addMask(StringBuilder stringBuilder) {
    int stringLength = stringBuilder.length();
    while (stringLength <= 15) {
      stringBuilder.append('#');
      stringLength++;
    }
  }

  private static void printGuessWordsRules(String[] words) {
    System.out.println("-----------------------------------------------------------------------");
    System.out.println("The goal is to guess one word from the list: " + Arrays.toString(words));
    System.out.println("-----------------------------------------------------------------------");
  }

  private static void printGuessWordResult() {
    System.out.println("-----------------------------------------------------------------------");
    System.out.println("Congratulations! You did it.");
    System.out.println("-----------------------------------------------------------------------");
  }

  private static void showHint(String hint) {
    System.out.println("Try again. Hint: " + hint);
  }
}
