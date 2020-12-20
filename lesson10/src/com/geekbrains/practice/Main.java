package com.geekbrains.practice;

public class Main {
  private static final int ARR_SIZE = 4;

  public static void main(String[] args) {
    String[][] strings = {
        {"1", "1", "1", "1"},
        {"1", "1", "1", "1"},
        {"1", "1", "1", "1"},
        {"1", "1", "1", "1"}
    };
    System.out.println(sumStrings(strings));
  }

  public static int sumStrings(String[][] strings) {
    try {
      checkStringsArray(strings);
      return sumElements(strings);
    } catch (MyArraySizeException | MyArrayDataException e) {
      e.printStackTrace();
    }
    return 0;
  }

  private static int sumElements(String[][] strings) {
    int elementsSum = 0;
    for (int arrIndexColumn = 0; arrIndexColumn < strings.length; arrIndexColumn++) {
      for (int arrIndexRow = 0; arrIndexRow < strings[arrIndexColumn].length; arrIndexRow++) {
        try {
          elementsSum += Integer.parseInt(strings[arrIndexColumn][arrIndexRow]);
        } catch (NumberFormatException e) {
          throw new MyArrayDataException("Cannot parse element: ", arrIndexColumn, arrIndexRow);
        }
      }
    }
    return elementsSum;
  }

  private static void checkStringsArray(String[][] strings) throws MyArraySizeException {
    int arrLengthRow = strings.length;
    if (arrLengthRow != ARR_SIZE) {
      throw new MyArraySizeException("");
    }
    for (String[] string : strings) {
      if (string.length != ARR_SIZE) {
        throw new MyArraySizeException("");
      }
    }
  }
}
