package com.geekbrains.training;

import java.util.Scanner;

public class TicTacToe {
  private static final Scanner scanner = new Scanner(System.in);

  private static final int GAME_FIELD_SIZE = 9;
  private static final int REQUIRED_MATCHES = 4;

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
          printGameField();
          isGameFinished = true;
          break;
      }
    }
  }

  /**
   * @return (1 : победил игрок), (-1: победил AI), (0: игра продолжается)
   */
  private static int nextTurn() {
    int[] playerTurn = playerTurn();
    int[] turnPlace = playerTurn;
    int checkWinnersResult = checkWinners(turnPlace[0], turnPlace[1]);
    if (checkWinnersResult == 0) {
      turnPlace = aiTurn(playerTurn);
      printGameField();
      return checkWinners(turnPlace[0], turnPlace[1]);
    } else {
      return checkWinnersResult;
    }
  }

  private static int[] playerTurn() {
    int row;
    int column;
    do {
      System.out.print("Enter column number: ");
      column = scanner.nextInt() - 1;
      System.out.print("Enter row number: ");
      row = scanner.nextInt() - 1;
    } while (!isCellValid(row, column));
    gameField[row][column] = CROSS;
    return new int[]{row, column};
  }

  private static int[] aiTurn(int[] playerTurn) {
    int[] aiTurnPlace;
    int[] whereToDefence = new int[2];
    if (isDefenceRequired(whereToDefence, playerTurn)) {
      aiTurnPlace = defence(ZERO, whereToDefence);
    } else {
      aiTurnPlace = attack();
    }
    return aiTurnPlace;
  }

  private static int[] attack() {
    return new int[]{0, 0};
  }

  private static int[] defence(char element, int[] whereToDefence) {
    gameField[whereToDefence[0]][whereToDefence[1]] = element;
    return whereToDefence;
  }

  private static boolean isDefenceRequired(int[] whereToDefence, int[] playerTurn) {
    boolean isDefenceRequired = false;
    if (checkElementScore(CROSS, playerTurn[0], playerTurn[1]) >= REQUIRED_MATCHES - 2) {
      isDefenceRequired = whereToDefence(whereToDefence, CROSS, playerTurn[0], playerTurn[1]);
    }
    return isDefenceRequired;
  }

  private static boolean whereToDefence(int[] whereToDefence, char element, int row, int column) {
    boolean isPlaceFound = checkRow(whereToDefence, element, row, column);
    if (!isPlaceFound) {
      isPlaceFound = checkColumn(whereToDefence, element, row, column);
      if (!isPlaceFound) {
        isPlaceFound = checkMainDiagonal(whereToDefence, element, row, column);
        if (!isPlaceFound) {
          isPlaceFound = checkAdditionalDiagonal(whereToDefence, element, row, column);
        }
      }
    }
    return isPlaceFound;
  }

  private static boolean checkAdditionalDiagonal(int[] whereToDefence, char element, int row, int column) {
    int crossesCount;
    crossesCount = countAdditionalDiagonalUp(element, row, column) + countAdditionalDiagonalDown(element, row + 1, column - 1);
    if (crossesCount >= REQUIRED_MATCHES - 2) {
      int[] upBorder = getUpAdditionalDiagonalBorder(element, row, column);
      int[] downBorder = getDownAdditionalDiagonalBorder(element, row, column);
      if (isCellValid(upBorder[0] - 1, upBorder[1] + 1)) {
        whereToDefence[0] = upBorder[0] - 1;
        whereToDefence[1] = upBorder[1] + 1;
        return true;
      } else if (isCellValid(downBorder[0] + 1, downBorder[1] - 1)) {
        whereToDefence[0] = downBorder[0] + 1;
        whereToDefence[1] = downBorder[1] - 1;
        return true;
      }
    }
    return false;
  }

  private static boolean checkMainDiagonal(int[] whereToDefence, char element, int row, int column) {
    int crossesCount;
    crossesCount = countMainDiagonalUp(element, row, column) + countMainDiagonalDown(element, row + 1, column + 1);
    if (crossesCount >= REQUIRED_MATCHES - 2) {
      int[] upBorder = getUpMainDiagonalBorder(element, row, column);
      int[] downBorder = getDownMainDiagonalBorder(element, row, column);
      if (isCellValid(upBorder[0] - 1, upBorder[1] - 1)) {
        whereToDefence[0] = upBorder[0] - 1;
        whereToDefence[1] = upBorder[1] - 1;
        return true;
      } else if (isCellValid(downBorder[0] + 1, downBorder[1] + 1)) {
        whereToDefence[0] = downBorder[0] + 1;
        whereToDefence[1] = downBorder[1] + 1;
        return true;
      }
    }
    return false;
  }

  private static boolean checkRow(int[] whereToDefence, char element, int row, int column) {
    int crossesCount;
    crossesCount = countRight(element, row, column + 1) + countLeft(element, row, column);
    if (crossesCount >= REQUIRED_MATCHES - 2) {
      int leftBorder = getLeftBorder(element, row, column);
      int rightBorder = getRightBorder(element, row, column);
      if (isCellValid(row, leftBorder + 1)) {
        whereToDefence[0] = row;
        whereToDefence[1] = leftBorder + 1;
        return true;
      } else if (isCellValid(row, rightBorder + 1)) {
        whereToDefence[0] = row;
        whereToDefence[1] = rightBorder;
        return true;
      }
    }
    return false;
  }

  private static boolean checkColumn(int[] whereToDefence, char element, int row, int column) {
    int crossesCount;
    crossesCount = countUp(element, row, column) + countDown(element, row + 1, column);
    if (crossesCount >= REQUIRED_MATCHES - 2) {
      int upBorder = getUpBorder(element, row, column);
      int downBorder = getDownBorder(element, row, column);
      if (isCellValid(row, upBorder - 1)) {
        whereToDefence[0] = upBorder;
        whereToDefence[1] = column;
        return true;
      } else if (isCellValid(row, downBorder + 1)) {
        whereToDefence[0] = downBorder + 1;
        whereToDefence[1] = column;
        return true;
      }
    }
    return false;
  }

  private static int checkWinners(int row, int column) {
    if (checkCrosses(row, column)) {
      return 1;
    } else if (checkZeros(row, column)) {
      return -1;
    } else {
      return 0;
    }
  }

  private static boolean checkCrosses(int row, int column) {
    return checkElement(CROSS, row, column);
  }

  private static boolean checkZeros(int row, int column) {
    return checkElement(ZERO, row, column);
  }

  private static boolean checkElement(char element, int row, int column) {
    int crossesCount;
    crossesCount = countRight(element, row, column + 1) + countLeft(element, row, column);
    if (crossesCount >= REQUIRED_MATCHES) {
      return true;
    }
    crossesCount = countUp(element, row, column) + countDown(element, row + 1, column);
    if (crossesCount >= REQUIRED_MATCHES) {
      return true;
    }
    crossesCount = countMainDiagonalUp(element, row, column) + countMainDiagonalDown(element, row + 1, column + 1);
    if (crossesCount >= REQUIRED_MATCHES) {
      return true;
    }

    crossesCount = countAdditionalDiagonalUp(element, row, column) + countAdditionalDiagonalDown(element, row + 1, column - 1);
    return crossesCount >= REQUIRED_MATCHES;
  }

  private static int checkElementScore(char element, int row, int column) {
    int crossesCount;
    crossesCount = countRight(element, row, column + 1) + countLeft(element, row, column);
    if (crossesCount >= REQUIRED_MATCHES - 2) {
      return crossesCount;
    }
    crossesCount = countUp(element, row, column) + countDown(element, row + 1, column);
    if (crossesCount >= REQUIRED_MATCHES - 2) {
      return crossesCount;
    }
    crossesCount = countMainDiagonalUp(element, row, column) + countMainDiagonalDown(element, row + 1, column + 1);
    if (crossesCount >= REQUIRED_MATCHES - 2) {
      return crossesCount;
    }
    crossesCount = countAdditionalDiagonalUp(element, row, column) + countAdditionalDiagonalDown(element, row + 1, column - 1);
    return crossesCount;
  }

  private static int countRight(char element, int row, int column) {
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

  private static int getRightBorder(char element, int row, int column) {
    char currentElement = element;
    while (currentElement == CROSS) {
      column++;
      if (column < gameField.length) {
        currentElement = gameField[row][column];
      } else {
        break;
      }
    }
    return column;
  }

  private static int countLeft(char element, int row, int column) {
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

  private static int getLeftBorder(char element, int row, int column) {
    char currentElement = element;
    while (currentElement == CROSS) {
      if (column >= 0) {
        currentElement = gameField[row][column];
        column--;
      } else {
        break;
      }
    }
    return column;
  }

  private static int countUp(char element, int row, int column) {
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

  private static int getUpBorder(char element, int row, int column) {
    char currentElement = element;
    while (currentElement == CROSS) {
      row--;
      if (row > 0) {
        currentElement = gameField[row][column];
      } else {
        break;
      }
    }
    return row;
  }

  private static int countDown(char element, int row, int column) {
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

  private static int getDownBorder(char element, int row, int column) {
    char currentElement = element;
    do {
      row++;
      if (row < gameField.length) {
        currentElement = gameField[row][column];
      } else {
        break;
      }
    } while (currentElement == CROSS);
    return --row;
  }

  private static int countMainDiagonalDown(char element, int row, int column) {
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

  private static int[] getDownMainDiagonalBorder(char element, int row, int column) {
    do {
      if (row < gameField.length && column < gameField.length) {
        row++;
        column++;
        if (row != gameField.length && column != gameField.length) {
          element = gameField[row][column];
        }
      } else {
        element = EMPTY;
      }
    } while (element == CROSS);
    return new int[]{--row, --column};
  }

  private static int countMainDiagonalUp(char element, int row, int column) {
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

  private static int[] getUpMainDiagonalBorder(char element, int row, int column) {
    do {
      row--;
      column--;
      if (row >= 0 && column >= 0) {
        if (gameField[row][column] == CROSS) {
          element = gameField[row][column];
        } else {
          break;
        }
      } else {
        break;
      }
    } while (element == CROSS);
    return new int[]{++row, ++column};
  }

  private static int countAdditionalDiagonalUp(char element, int row, int column) {
    int count = 0;
    for (; row >= 0; row--) {
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

  private static int[] getUpAdditionalDiagonalBorder(char element, int row, int column) {
    do {
      row--;
      column++;
      if (row >= 0 && column < gameField.length) {
        if (gameField[row][column] == CROSS) {
          element = gameField[row][column];
        } else {
          break;
        }
      } else {
        break;
      }
    } while (element == CROSS);
    return new int[]{++row, --column};
  }

  private static int[] getDownAdditionalDiagonalBorder(char element, int row, int column) {
    do {
      if (row < gameField.length && column < gameField.length) {
        row++;
        column--;
        if (row != gameField.length && column != gameField.length) {
          element = gameField[row][column];
        }
      } else {
        element = EMPTY;
      }
    } while (element == CROSS);
    return new int[]{--row, ++column};
  }

  private static int countAdditionalDiagonalDown(char element, int row, int column) {
    int count = 0;
    if (row >= gameField.length || column >= gameField.length) {
      return 0;
    }
    for (; row < gameField.length; row++) {
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

  private static boolean isCellValid(int row, int column) {
    if (row < 0 || column < 0 || row >= GAME_FIELD_SIZE || column >= GAME_FIELD_SIZE) {
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
