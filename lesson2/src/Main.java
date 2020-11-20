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

    int[] intsArray = {2, 2, 2, 1, 2, 3, 10, 1};
    boolean arrayBalanceResult = isArrayBalanced(intsArray);
    System.out.println("Array is " + (arrayBalanceResult ? "balanced!" : "is not balanced!"));

    int[] inputArray = {1, 2, 3};
    shiftArray(inputArray, 2);
    System.out.println(Arrays.toString(inputArray));
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
    for (int randomInt : randomInts) {
      if (max < randomInt) {
        max = randomInt;
      }
    }

    return max;
  }

  private static int findMin(int[] randomInts) {
    int min = randomInts[0];
    for (int randomInt : randomInts) {
      if (min > randomInt) {
        min = randomInt;
      }
    }

    return min;
  }

  public static boolean isArrayBalanced(int[] ints) {
    if (ints.length == 0) {
      System.out.println("Input array is empty");
      return false;
    }

    boolean isArrayBalanced = false;

    for (int arrIndex = 0; arrIndex < ints.length; arrIndex++) {
      if (checkElement(ints, arrIndex)) {
        isArrayBalanced = true;
        break;
      }
    }

    return isArrayBalanced;
  }

  private static boolean checkElement(int[] ints, int arrIndex) {
    return calculateLeftArrayPart(ints, arrIndex) == calculateRightArrayPart(ints, arrIndex + 1);
  }

  private static int calculateLeftArrayPart(int[] ints, int arrIndex) {
    int sumResult = ints[arrIndex];
    for (int index = 0; index < arrIndex; index++) {
      sumResult += ints[index];
    }

    return sumResult;
  }

  private static int calculateRightArrayPart(int[] ints, int arrIndex) {
    if (arrIndex >= ints.length) {
      return 0;
    }

    int sumResult = 0;
    for (int index = arrIndex; index < ints.length; index++) {
      sumResult += ints[index];
    }

    return sumResult;
  }

  public static void shiftArray(int[] ints, int n) {
    if (n == 0 || ints.length == 0) {
      return;
    }

    int finalN  = Math.abs(n);
    for (int shiftNumber = 0; shiftNumber < finalN; shiftNumber++) {
      int buffer = 0;
      for (int arrIndex = 0; arrIndex < ints.length; arrIndex++) {
        if (n >= 0) {
          buffer = moveRight(ints, arrIndex, buffer);
        } else {
          buffer = moveLeft(ints, arrIndex, buffer);
        }
      }
    }
  }

  private static int moveRight(int[] ints, int arrIndex, int buffer) {
    if (arrIndex == 0) {
      buffer = ints[arrIndex];
      ints[arrIndex] = ints[ints.length - 1];
    } else {
      int tempBuffer = ints[arrIndex];
      ints[arrIndex] = buffer;
      buffer = tempBuffer;
    }
    return buffer;
  }

  private static int moveLeft(int[] ints, int arrIndex, int buffer) {
    if (arrIndex == 0) {
      buffer = ints[ints.length - 1];
      ints[ints.length - 1] = ints[arrIndex];
    } else {
      int tempBuffer = ints[ints.length - 1 - arrIndex];
      ints[ints.length - 1 - arrIndex] = buffer;
      buffer = tempBuffer;
    }
    return buffer;
  }
}

