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

    Box<Apple> appleBox1 = new Box<>();
    appleBox1.addFruit(new Apple());
    appleBox1.addFruit(new Apple());
    System.out.println(appleBox1.getWeight());

    Box<Apple> appleBox2 = new Box<>();
    appleBox2.addFruit(new Apple());
    appleBox2.addFruit(new Apple());
    System.out.println(appleBox2.getWeight());

    Box<Orange> orangeBox1 = new Box<>();
    orangeBox1.addFruit(new Orange());
    orangeBox1.addFruit(new Orange());
    orangeBox1.addFruit(new Orange());
    orangeBox1.addFruit(new Orange());
    orangeBox1.addFruit(new Orange());
    orangeBox1.addFruit(new Orange());
    orangeBox1.addFruit(new Orange());
    orangeBox1.addFruit(new Orange());
    orangeBox1.addFruit(new Orange());
    orangeBox1.addFruit(new Orange());
    System.out.println(orangeBox1.getWeight());

    System.out.println(appleBox2.compare(orangeBox1));
    System.out.println(orangeBox1.compare(appleBox2));

    appleBox2.mergeBoxes(appleBox2, appleBox1);
    appleBox1.mergeBoxes(appleBox1, appleBox2);
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
