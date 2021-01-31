package com.geekbrains.practice;

import java.util.ArrayList;

public class Box <T extends Fruit> {
  private final ArrayList<T> fruits;

  public Box() {
    fruits = new ArrayList<>();
  }

  public double getWeight() {
    return fruits.size() * fruits.get(0).fruitWeight();
  }

  public void addFruit(T fruit) {
    fruits.add(fruit);
  }

  public boolean compare(Box<?> box) {
    return Math.abs(this.getWeight() - box.getWeight() ) < 0.00001f;
  }

  public ArrayList<T> getFruits() {
    return fruits;
  }

  public void mergeBoxes(Box<? extends T> srcBox, Box<? super T> destBox) {
    destBox.getFruits().addAll(srcBox.getFruits());
    srcBox.getFruits().clear();
  }
}
