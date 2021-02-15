package com.geekbrains.practice;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class HomeworkImplementationTestCase {
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

  @Test
  public void testConvertArrayMethodExecution() {
    assertArrayEquals(new int[]{1, 7},homeworkImplementation.convertArray(new int[] {1,2,4,4,2,3,4,1,7}));
  }
}
