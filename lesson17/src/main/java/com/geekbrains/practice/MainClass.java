package com.geekbrains.practice;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class MainClass {
  public static final int CARS_COUNT = 4;

  public static void main(String[] args) {
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
    Race race = new Race(new Road(60), new Tunnel(), new Road(40));
    CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);

    Car[] cars = new Car[CARS_COUNT];
    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car(race, 20 + (int) (Math.random() * 10), countDownLatch);
    }
    ArrayList<Thread> carsList = new ArrayList<>();
    for (int i = 0; i < cars.length; i++) {
      Thread carThread = new Thread(cars[i]);
      carsList.add(carThread);
      carThread.start();
    }
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
    for (Thread car : carsList) {
      try {
        car.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
  }
}