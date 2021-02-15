package com.geekbrains.practice;

import org.junit.BeforeClass;
import org.junit.Test;

public class HomeworkImplementationTestInputs {
  private static HomeworkImplementation homeworkImplementation;

  @BeforeClass
  public static void preparation() {
    homeworkImplementation = new HomeworkImplementation();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInputArgumentLength() {
    homeworkImplementation.convertArray(new int[0]);
  }

  @Test(expected = RuntimeException.class)
  public void testInputArgumentElements() {
    homeworkImplementation.convertArray(new int[]{1, 2, 3, 3});
  }
}
