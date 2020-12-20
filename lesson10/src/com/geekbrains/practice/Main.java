package com.geekbrains.practice;

public class Main {
  private static final int ARR_SIZE = 4;

  public static void main(String[] args) {
    String[][] strings = {
        {"string", "string", "string", "string"},
        {"string", "string", "string", "string"},
        {"string", "string", "string", "string"},
        {"string", "string", "string", "string"}
    };
    sumStrings(strings);
  }

  public static void sumStrings(String[][] strings) {
    try {
      checkStringsArray(strings);
    } catch (MyArraySizeException e) {
      e.printStackTrace();
    }
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
