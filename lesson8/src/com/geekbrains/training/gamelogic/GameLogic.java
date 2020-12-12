package com.geekbrains.training.gamelogic;

import java.util.Random;

public class GameLogic {
  private final Random random = new Random();

  private int fieldSize = 3;
  private int requiredMatches = 3;

  private final char CROSS = 'X';
  private final char ZERO = 'O';
  private final char EMPTY = '.';

  private char[][] gameField;

  public int nextTurn(int x, int y) {
    int[] lastPlayerTurnPlace = playerTurn(x, y);
    int[] turnPlace = lastPlayerTurnPlace;
    int checkWinnersResult = checkWinners(turnPlace[0], turnPlace[1]);
    if (checkWinnersResult == 0) {
      turnPlace = aiTurn(lastPlayerTurnPlace);
      printGameField();
      return checkWinners(turnPlace[0], turnPlace[1]);
    } else {
      return checkWinnersResult;
    }
  }

  private int[] playerTurn(int x, int y) {
    gameField[x][y] = CROSS;
    return new int[]{x, y};
  }

  private int[] aiTurn(int[] playerTurn) {
    int[] aiTurnPlace;
    int[] whereToDefence = new int[2];
    if (isDefenceRequired(whereToDefence, playerTurn)) {
      aiTurnPlace = defence(ZERO, whereToDefence);
    } else {
      aiTurnPlace = attack();
    }
    return aiTurnPlace;
  }

  private int[] attack() {
    int row;
    int column;
    do {
      row = random.nextInt(fieldSize);
      column = random.nextInt(fieldSize);
    } while (!isCellValid(row, column));
    gameField[row][column] = ZERO;
    return new int[]{row, column};
  }

  @SuppressWarnings("SameParameterValue")
  private int[] defence(char element, int[] whereToDefence) {
    gameField[whereToDefence[0]][whereToDefence[1]] = element;
    return whereToDefence;
  }

  private boolean isDefenceRequired(int[] whereToDefence, int[] playerTurn) {
    boolean isDefenceRequired = false;
    if (checkElementScore(CROSS, playerTurn[0], playerTurn[1]) >= requiredMatches - 2) {
      isDefenceRequired = whereToDefence(whereToDefence, CROSS, playerTurn[0], playerTurn[1]);
    }
    return isDefenceRequired;
  }

  @SuppressWarnings("SameParameterValue")
  private boolean whereToDefence(int[] whereToDefence, char element, int row, int column) {
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

  private boolean checkAdditionalDiagonal(int[] whereToDefence, char element, int row, int column) {
    int crossesCount;
    crossesCount = countAdditionalDiagonalUp(element, row, column) + countAdditionalDiagonalDown(element, row + 1, column - 1);
    if (crossesCount >= requiredMatches - 2) {
      int[] upBorder = getUpAdditionalDiagonalBorder(row, column);
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

  private boolean checkMainDiagonal(int[] whereToDefence, char element, int row, int column) {
    int crossesCount;
    crossesCount = countMainDiagonalUp(element, row, column) + countMainDiagonalDown(element, row + 1, column + 1);
    if (crossesCount >= requiredMatches - 2) {
      int[] upBorder = getUpMainDiagonalBorder(row, column);
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

  private boolean checkRow(int[] whereToDefence, char element, int row, int column) {
    int crossesCount;
    crossesCount = countRight(element, row, column + 1) + countLeft(element, row, column);
    if (crossesCount >= requiredMatches - 2) {
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

  private boolean checkColumn(int[] whereToDefence, char element, int row, int column) {
    int crossesCount;
    crossesCount = countUp(element, row, column) + countDown(element, row + 1, column);
    if (crossesCount >= requiredMatches - 2) {
      int upBorder = getUpBorder(element, row, column);
      int downBorder = getDownBorder(row, column);
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

  private int checkWinners(int row, int column) {
    if (checkCrosses(row, column)) {
      return 1;
    } else if (checkZeros(row, column)) {
      return -1;
    } else {
      return 0;
    }
  }

  private boolean checkCrosses(int row, int column) {
    return checkElement(CROSS, row, column);
  }

  private boolean checkZeros(int row, int column) {
    return checkElement(ZERO, row, column);
  }

  private boolean checkElement(char element, int row, int column) {
    int crossesCount;
    crossesCount = countRight(element, row, column + 1) + countLeft(element, row, column);
    if (crossesCount >= requiredMatches) {
      return true;
    }
    crossesCount = countUp(element, row, column) + countDown(element, row + 1, column);
    if (crossesCount >= requiredMatches) {
      return true;
    }
    crossesCount = countMainDiagonalUp(element, row, column) + countMainDiagonalDown(element, row + 1, column + 1);
    if (crossesCount >= requiredMatches) {
      return true;
    }

    crossesCount = countAdditionalDiagonalUp(element, row, column) + countAdditionalDiagonalDown(element, row + 1, column - 1);
    return crossesCount >= requiredMatches;
  }

  @SuppressWarnings("SameParameterValue")
  private int checkElementScore(char element, int row, int column) {
    int crossesCount;
    crossesCount = countRight(element, row, column + 1) + countLeft(element, row, column);
    if (crossesCount >= requiredMatches - 2) {
      return crossesCount;
    }
    crossesCount = countUp(element, row, column) + countDown(element, row + 1, column);
    if (crossesCount >= requiredMatches - 2) {
      return crossesCount;
    }
    crossesCount = countMainDiagonalUp(element, row, column) + countMainDiagonalDown(element, row + 1, column + 1);
    if (crossesCount >= requiredMatches - 2) {
      return crossesCount;
    }
    crossesCount = countAdditionalDiagonalUp(element, row, column) + countAdditionalDiagonalDown(element, row + 1, column - 1);
    return crossesCount;
  }

  private int countRight(char element, int row, int column) {
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

  private int getRightBorder(char element, int row, int column) {
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

  private int countLeft(char element, int row, int column) {
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

  private int getLeftBorder(char element, int row, int column) {
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

  private int countUp(char element, int row, int column) {
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

  private int getUpBorder(char element, int row, int column) {
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

  private int countDown(char element, int row, int column) {
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

  private int getDownBorder(int row, int column) {
    char element;
    do {
      row++;
      if (row < gameField.length) {
        element = gameField[row][column];
      } else {
        break;
      }
    } while (element == CROSS);
    return --row;
  }

  private int countMainDiagonalDown(char element, int row, int column) {
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

  private int[] getDownMainDiagonalBorder(char element, int row, int column) {
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

  private int countMainDiagonalUp(char element, int row, int column) {
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

  private int[] getUpMainDiagonalBorder(int row, int column) {
    char element;
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

  private int countAdditionalDiagonalUp(char element, int row, int column) {
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

  private int[] getUpAdditionalDiagonalBorder(int row, int column) {
    char element;
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

  private int[] getDownAdditionalDiagonalBorder(char element, int row, int column) {
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

  private int countAdditionalDiagonalDown(char element, int row, int column) {
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

  private boolean isCellValid(int row, int column) {
    if (row < 0 || column < 0 || row >= fieldSize || column >= fieldSize) {
      return false;
    }
    return gameField[row][column] == EMPTY;
  }

  public void initGameField(int gameFieldSize) {
    fieldSize = gameFieldSize;
    gameField = new char[fieldSize][fieldSize];
    for (int rowIndex = 0; rowIndex < fieldSize; rowIndex++) {
      for (int columnIndex = 0; columnIndex < fieldSize; columnIndex++) {
        gameField[rowIndex][columnIndex] = EMPTY;
      }
    }
  }

  private void printGameField() {
    printBorder();
    printColumnNumbers();
    printGameFieldContent();
    printBorder();
  }

  private void printGameFieldContent() {
    System.out.println();
    for (int rowIndex = 0; rowIndex < fieldSize; rowIndex++) {
      System.out.print(rowIndex + 1 + " ");
      for (int columnIndex = 0; columnIndex < fieldSize; columnIndex++) {
        System.out.printf("%c  ", gameField[rowIndex][columnIndex]);
      }
      System.out.println();
    }
  }

  private void printColumnNumbers() {
    System.out.print("  ");
    for (int columnIndex = 0; columnIndex < fieldSize; columnIndex++) {
      System.out.print(columnIndex + 1 + "  ");
    }
  }

  private void printBorder() {
    for (int columnIndex = 0; columnIndex < fieldSize; columnIndex++) {
      System.out.print("-- ");
    }
    System.out.println();
  }
}
