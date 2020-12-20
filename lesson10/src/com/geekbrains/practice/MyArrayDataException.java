package com.geekbrains.practice;

public class MyArrayDataException extends NumberFormatException {
  public MyArrayDataException(String s, int arrIndexColumn, int arrIndexRow) {
    super(s + "[" + arrIndexColumn + ":" + arrIndexRow + "]");
  }
}
