import java.util.Arrays;

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
    for (int lineIndex = 0; lineIndex < quadraticMatrix.length; lineIndex++) {
      for (int rowIndex = 0; rowIndex < quadraticMatrix[lineIndex].length; rowIndex++) {
        if (lineIndex == rowIndex) {
          quadraticMatrix[lineIndex][rowIndex] = 1;                                         //Diagonal from left to right
          quadraticMatrix[lineIndex][quadraticMatrix[lineIndex].length - 1 - rowIndex] = 1; //Diagonal from right to left
        }
      }
    }
  }
}

