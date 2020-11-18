import java.util.Arrays;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    int[] ints = {0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0};
    convertIntsArray(ints);
    System.out.println(Arrays.toString(ints));

    int[] emptyIntsArray = new int[8];
    fillEmptyArray(emptyIntsArray);
    System.out.println(Arrays.toString(emptyIntsArray));

    int[] randomIntsArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    replaceArrayElements(randomIntsArray);
    System.out.println(Arrays.toString(randomIntsArray));

    int[][] quadraticMatrix = {
      {0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 0, 0, 0, 0, 0, 0}
    };
    replaceDiagonalElements(quadraticMatrix);
    System.out.println(Arrays.deepToString(quadraticMatrix));

    int[] randomInts = new int[1000];
    fillArray(randomInts, 1000);
    System.out.println("randomInts MIN: " + findMin(randomInts));
    System.out.println("randomInts MAX: " + findMax(randomInts));
  }

  private static void convertIntsArray(int[] ints) {
    for (int arrIndex = 0; arrIndex < ints.length; arrIndex++) {
      switch (ints[arrIndex]) {
        case 1:
          ints[arrIndex] = 0;
          break;
        case 0:
          ints[arrIndex] = 1;
          break;
        default:
          System.out.println("Incorrect array value");
      }
    }
  }

  private static void fillEmptyArray(int[] emptyIntsArray) {
    for (int arrIndex = 0; arrIndex < emptyIntsArray.length; arrIndex++) {
      emptyIntsArray[arrIndex] = arrIndex * 3;
    }
  }

  private static void replaceArrayElements(int[] randomIntsArray) {
    for (int arrIndex = 0; arrIndex < randomIntsArray.length; arrIndex++) {
      if (randomIntsArray[arrIndex] < 6) {
        randomIntsArray[arrIndex] *= 2;
      }
    }
  }

  private static void replaceDiagonalElements(int[][] quadraticMatrix) {
    for (int rowIndex = 0; rowIndex < quadraticMatrix.length; rowIndex++) {
      for (int columnIndex = 0; columnIndex < quadraticMatrix[rowIndex].length; columnIndex++) {
        if (rowIndex == columnIndex) {
          quadraticMatrix[rowIndex][columnIndex] = 1;                                        //Diagonal from left to right
          quadraticMatrix[rowIndex][quadraticMatrix[rowIndex].length - 1 - columnIndex] = 1; //Diagonal from right to left
        }
      }
    }
  }

  private static void fillArray(int[] randomInts, int range) {
    Random randomizer = new Random();
    for (int arrIndex = 0; arrIndex < randomInts.length; arrIndex++) {
      randomInts[arrIndex] = randomizer.nextInt(range);
    }
  }

  private static int findMax(int[] randomInts) {
    int max = randomInts[0];
    for (int arrIndex = 0; arrIndex < randomInts.length; arrIndex++) {
      if (max < randomInts[arrIndex]) {
        max = randomInts[arrIndex];
      }
    }

    return max;
  }

  private static int findMin(int[] randomInts) {
    int min = randomInts[0];
    for (int arrIndex = 0; arrIndex < randomInts.length; arrIndex++) {
      if (min > randomInts[arrIndex]) {
        min = randomInts[arrIndex];
      }
    }

    return min;
  }
}

