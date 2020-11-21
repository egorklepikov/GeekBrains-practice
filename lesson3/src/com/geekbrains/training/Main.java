package com.geekbrains.training;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
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
          System.out.println("Game name is wrong. Press enter to try again.");
          System.out.println("-------------------------------------------------");
      }
    }
  }

  private static void playGuessNumber() {

  }

  private static void playGuessWord() {

  }
}
