package com.geekbrains.practice;

public class FirstMethod {
  public static void main(String[] args) {
    calculateFormula();
  }

  private static void calculateFormula() {
    final int size = 10_000_000;
    float[] array = fillArray(size);
    long currentTime = System.currentTimeMillis();
    for (int i = 0; i < size; i++) {
      array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }
    System.out.println(System.currentTimeMillis() - currentTime);
  }

  private static float[] fillArray(int size) {
    float[] array = new float[size];
    for (int i = 0; i < size; i++) {
      array[i] = 1;
    }
    return array;
  }
}
