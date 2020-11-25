package com.geekbrains.training;

import java.util.Scanner;

public class TicTacToe {
  private static final Scanner scanner = new Scanner(System.in);

  private static final int GAME_FIELD_SIZE = 7;
  private static final int REQUIRED_MATCHES = 5;

  private static final char CROSS = 'X';
  private static final char ZERO = 'O';
  private static final char EMPTY = '.';

  private static char[][] gameField;

  public static void main(String[] args) {
    startGameProcess();
  }

  public static void startGameProcess() {
    initGameField();
    startGame();
  }

  private static void startGame() {
    boolean isGameFinished = false;
    while (!isGameFinished) {
      int gameResult = nextTurn();
      switch (gameResult) {
        case 1:
        case -1:
          printGameResult(gameResult);
          isGameFinished = true;
          break;
      }
    }
  }

  /**
   * @return (1 : победил игрок), (-1: победил AI), (0: игра продолжается)
   */
  private static int nextTurn() {
    playerTurn();
    printGameField();
    aiTurn();
    return checkWinners();
  }

  private static void playerTurn() {
    int row;
    int column;
    do {
      System.out.print("Enter column number: ");
      column = scanner.nextInt() - 1;
      System.out.print("Enter row number: ");
      row = scanner.nextInt() - 1;
    } while (!isCellValid(row, column));
    gameField[row][column] = CROSS;
  }

  private static void aiTurn() {

  }

  private static int checkWinners() {
    if (checkCrosses()) {
      return 1;
    } else if (checkZeros()) {
      return -1;
    } else {
      return 0;
    }
  }

  private static boolean checkCrosses() {
    return checkElements(CROSS);
  }

  private static boolean checkZeros() {
    return checkElements(ZERO);
  }

  private static boolean checkElements(char element) {
    boolean isWinner = false;
    for (int rowIndex = 0; rowIndex < GAME_FIELD_SIZE; rowIndex++) {
      for (int columnIndex = 0; columnIndex < GAME_FIELD_SIZE; columnIndex++) {
        isWinner = checkElement(element, rowIndex, columnIndex);
        if (isWinner) {
          break;
        }
      }
      if (isWinner) {
        break;
      }
    }
    return isWinner;
  }

  private static boolean checkElement(char element, int row, int column) {
    int crossesCount;
    crossesCount = moveRight(element, row, column + 1) + moveLeft(element, row, column);
    if (crossesCount >= REQUIRED_MATCHES) {
      return true;
    }
    crossesCount = moveUp(element, row, column) + moveDown(element, row + 1, column);
    if (crossesCount >= REQUIRED_MATCHES) {
      return true;
    }
    crossesCount = moveMainDiagonalUp(element, row, column) + moveMainDiagonalDown(element, row + 1, column + 1);
    if (crossesCount >= REQUIRED_MATCHES) {
      return true;
    }
//    crossesCount = moveAdditionalDiagonalUp(element, row, column) + moveAdditionalDiagonalDown(element, row + 1, column + 1);
    return crossesCount >= REQUIRED_MATCHES;
  }

  private static int moveRight(char element, int row, int column) {
    int count = 0;
    for (; column < gameField.length; column++) {
      if (element == gameField[row][column]) {
        count++;
      } else {
        break;
      }
    }
    return count;
  }

  private static int moveLeft(char element, int row, int column) {
    int count = 0;
    for (; column >= 0; column--) {
      if (element == gameField[row][column]) {
        count++;
      } else {
        break;
      }
    }
    return count;
  }

  private static int moveUp(char element, int row, int column) {
    int count = 0;
    for (; row >= 0; row--) {
      if (element == gameField[row][column]) {
        count++;
      } else {
        break;
      }
    }
    return count;
  }

  private static int moveDown(char element, int row, int column) {
    int count = 0;
    for (; row < gameField.length; row++) {
      if (element == gameField[row][column]) {
        count++;
      } else {
        break;
      }
    }
    return count;
  }

  private static int moveMainDiagonalDown(char element, int row, int column) {
    int count = 0;
    for (; row < gameField.length; row++) {
      for (; column < gameField.length; column++) {
        if (element == gameField[row][column]) {
          count++;
        } else {
          break;
        }
      }
    }
    return count;
  }

  private static int moveMainDiagonalUp(char element, int row, int column) {
    int count = 0;
    for (; row >= 0; row--) {
      for (; column >= 0; column--) {
        if (element == gameField[row][column]) {
          count++;
        } else {
          break;
        }
      }
    }
    return count;
  }

  /**
   * -- -- -- -- -- -- --
   *   1  2  3  4  5  6  7
   * 1 .  .  .  .  .  .  X
   * 2 .  .  .  .  .  X  .
   * 3 .  .  .  .  X  .  .
   * 4 .  .  X  X  .  .  .
   * 5 .  .  .  .  .  .  .
   * 6 .  .  .  .  .  .  .
   * 7 .  .  .  .  .  .  .
   * -- -- -- -- -- -- --
   */

//  private static int moveAdditionalDiagonalUp(char element, int row, int column) {
//    int count = 0;
//    for (; row >= gameField.length; row++) {
//      for (; column > gameField.length; column++) {
//        if (element == gameField[row][column]) {
//          count++;
//        } else {
//          break;
//        }
//      }
//    }
//    return count;
//  }

//  private static int moveAdditionalDiagonalDown(char element, int row, int column) {
//    int count = 0;
//    for (; row < gameField.length; row++) {
//      for (; column >= 0; column--) {
//        if (element == gameField[row][column]) {
//          count++;
//        } else {
//          break;
//        }
//      }
//    }
//    return count;
//  }

  private static boolean isCellValid(int row, int column) {
    if (row < 0 || column < 0 || row > GAME_FIELD_SIZE || column > GAME_FIELD_SIZE) {
      return false;
    }
    return gameField[row][column] == EMPTY;
  }

  private static void initGameField() {
    gameField = new char[GAME_FIELD_SIZE][GAME_FIELD_SIZE];
    for (int rowIndex = 0; rowIndex < GAME_FIELD_SIZE; rowIndex++) {
      for (int columnIndex = 0; columnIndex < GAME_FIELD_SIZE; columnIndex++) {
        gameField[rowIndex][columnIndex] = EMPTY;
      }
    }
  }

  private static void printGameField() {
    printBorder();
    printColumnNumbers();
    printGameFieldContent();
    printBorder();
  }

  private static void printGameFieldContent() {
    System.out.println();
    for (int rowIndex = 0; rowIndex < GAME_FIELD_SIZE; rowIndex++) {
      System.out.print(rowIndex + 1 + " ");
      for (int columnIndex = 0; columnIndex < GAME_FIELD_SIZE; columnIndex++) {
        System.out.printf("%c  ", gameField[rowIndex][columnIndex]);
      }
      System.out.println();
    }
  }

  private static void printColumnNumbers() {
    System.out.print("  ");
    for (int columnIndex = 0; columnIndex < GAME_FIELD_SIZE; columnIndex++) {
      System.out.print(columnIndex + 1 + "  ");
    }
  }

  private static void printBorder() {
    for (int columnIndex = 0; columnIndex < GAME_FIELD_SIZE; columnIndex++) {
      System.out.print("-- ");
    }
    System.out.println();
  }

  private static void printGameResult(int gameResult) {
    if (gameResult == 1) {
      System.out.println("Congratulations. You did it!");
    } else if (gameResult == -1) {
      System.out.println("AI has taken over the world...");
    }
  }
}
