package com.geekbrains.practice;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Integer[] array = new Integer[]{1, 2, 3};
    System.out.println(Arrays.toString(swapElements(array, 0, 1)));

    ArrayList<Object> convertedArray = castArrayToArrayList(new Object[]{1,2,3});
    convertedArray.add(4);
    System.out.println(convertedArray);
  }

  private static <T> T[] swapElements(T[] array, int first, int second) {
    T tmpElement = array[first];
    array[first] = array[second];
    array[second] = tmpElement;
    return array;
  }

  private static ArrayList<Object> castArrayToArrayList(Object[] array) {
    return new ArrayList<>(Arrays.asList(array));
  }
}
