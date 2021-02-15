package com.geekbrains.practice;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class HomeworkImplementationExecutionTest {
  private final int[] expectedArray;
  private final int[] actualArray;
  private static HomeworkImplementation homeworkImplementation;

  @BeforeClass
  public static void preparation() {
    homeworkImplementation = new HomeworkImplementation();
  }

  public HomeworkImplementationExecutionTest(int[] expectedArray, int[] actualArray) {
    this.expectedArray = expectedArray;
    this.actualArray = actualArray;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {new int[]{1, 7}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}},
      {new int[]{3, 2, 3, 2, 1, 7}, new int[]{1, 2, 4, 3, 2, 3, 2, 1, 7}},
      {new int[]{2, 2, 2, 2, 3, 2, 1, 7}, new int[]{4, 2, 2, 2, 2, 3, 2, 1, 7}},
    });
  }

  @Test
  public void testConvertArrayExecution() {
    assertArrayEquals(expectedArray, homeworkImplementation.convertArray(actualArray));
  }
}
