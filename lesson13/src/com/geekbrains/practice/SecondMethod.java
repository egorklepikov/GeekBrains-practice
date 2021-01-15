package com.geekbrains.practice;

import java.util.ArrayList;

public class SecondMethod {
  public static void main(String[] args) {
    startCalculation(12);
  }

  private static void startCalculation(int threadsNumber) {
    final int size = 10_000_000;
    int dividedSize = size / threadsNumber;
    Float[] array = fillArray(size);
    long currentTime = System.currentTimeMillis();
    ArrayList<DividedArrayCalculator> threadsPool = preparePool(array, threadsNumber, dividedSize);
    startPool(threadsPool);
    joinPool(threadsPool);
    System.out.println(System.currentTimeMillis() - currentTime);
  }

  private static void joinPool(ArrayList<DividedArrayCalculator> threadsPool) {
    for (DividedArrayCalculator thread : threadsPool) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private static void startPool(ArrayList<DividedArrayCalculator> threadsPool) {
    for (DividedArrayCalculator thread : threadsPool) {
      thread.start();
    }
  }

  private static ArrayList<DividedArrayCalculator> preparePool(Float[] array, int threadsNumber, int dividedSize) {
    ArrayList<DividedArrayCalculator> threadsPool = new ArrayList<>();
    for (int threadNumber = 0; threadNumber < threadsNumber; threadNumber++) {
      threadsPool.add(new DividedArrayCalculator(array, threadNumber, dividedSize));
    }
    return threadsPool;
  }

  private static Float[] fillArray(int size) {
    Float[] array = new Float[size];
    for (int i = 0; i < size; i++) {
      array[i] = 1.0f;
    }
    return array;
  }

  private static class DividedArrayCalculator extends Thread {
    private final Float[] array;
    private final int threadNumber;
    private final int dividedSize;

    public DividedArrayCalculator(Float[] array, int threadNumber, int dividedSize) {
      this.array = array;
      this.threadNumber = threadNumber;
      this.dividedSize = dividedSize;
    }

    @Override
    public void run() {
      Float[] dividedArray = new Float[dividedSize];
      System.arraycopy(array, threadNumber * dividedSize, dividedArray, 0, dividedSize);
      int threadIndex;
      if (threadNumber == 0) {
        threadIndex = 1;
      } else {
        threadIndex = dividedSize * threadNumber;
      }
      for (int i = 0; i < dividedArray.length; i++) {
        dividedArray[i] = (float) (dividedArray[i]
            * Math.sin(0.2f + i * threadIndex / 5.0
            * Math.cos(0.2f + i * threadIndex / 5.0)
            * Math.cos(0.4f + i * threadIndex / 2.0)
        ));
      }
      System.arraycopy(dividedArray, 0, array, threadNumber * dividedSize, dividedArray.length);
    }
  }
}
