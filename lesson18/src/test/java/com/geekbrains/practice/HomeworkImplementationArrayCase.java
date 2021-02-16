package com.geekbrains.practice;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class HomeworkImplementationArrayCase {
  private final int[] actualArray;
  private final boolean isArrayCorrect;
  private static HomeworkImplementation homeworkImplementation;

  @BeforeClass
  public static void beforeClass() throws Exception {
    homeworkImplementation = new HomeworkImplementation();
  }

  public HomeworkImplementationArrayCase(int[] actualArray, boolean isArrayCorrect) {
    this.actualArray = actualArray;
    this.isArrayCorrect = isArrayCorrect;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
      {new int[]{1, 7}, false},
      {new int[]{1, 4}, true},
      {new int[]{1, 1}, false},
      {new int[]{4, 4}, false},
      {new int[]{1, 4, 4, 1}, true},
    });
  }

  @Test
  public void testArray() {
    assertEquals(isArrayCorrect, homeworkImplementation.isArrayCorrect(actualArray));
  }
}
