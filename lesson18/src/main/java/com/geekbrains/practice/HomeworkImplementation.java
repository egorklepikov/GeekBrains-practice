package com.geekbrains.practice;

public class HomeworkImplementation {
  public int[] convertArray(int[] array) {
    if (array.length == 0) {
      throw new IllegalArgumentException("Empty array");
    }
    boolean isArrayCorrect = false;
    int lastIndex = 0;
    for (int arrIndex = 0; arrIndex < array.length; arrIndex++) {
      if (array[arrIndex] == 4 && arrIndex != array.length - 1) {
        isArrayCorrect = true;
        lastIndex = arrIndex;
      }
    }
    if (!isArrayCorrect) {
      throw new RuntimeException("Incorrect array");
    } else {
      lastIndex++;
    }
    int[] resultArray = new int[array.length - lastIndex];
    int resultArrayIndex = 0;
    for (int arrIndex = lastIndex; arrIndex < array.length; arrIndex++) {
      resultArray[resultArrayIndex] = array[arrIndex];
      resultArrayIndex++;
    }
    return resultArray;
  }
}
