/**
 * SHaDeX0
 * 09 - 10 - 2021 (Saturday)
 * Matrix Multiplication Program
 */

//import java.util.Random;
import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Random random = new Random();

        System.out.println("Enter the size(rows columns) of Matrix 1: ");
        int row1 = scanner.nextInt();
        int col1 = scanner.nextInt();                                       //Input the rows and columns of matrix 1

        System.out.println("Enter the size(rows columns) of Matrix 2: ");
        int row2 = scanner.nextInt();
        int col2 = scanner.nextInt();                                       //Input the rows and columns of matrix 2

        int[][] matrix1 = new int[row1][col1];
        int[][] matrix2 = new int[row2][col2];                              //Declaring the two matrices
        if (row2 == col1) {                                                 //Checking if they can be multiplied

//            for (int i = 0; i < row1; i++) {                              //Code for storing random values in the matrices (Testing purposes)
//                for (int j = 0; j < col1; j++) {
//                    matrix1[i][j] = random.nextInt(10) + 1;
//                }
//            }
//            for (int i = 0; i < row2; i++) {
//                for (int j = 0; j < col2; j++) {
//                    matrix2[i][j] = random.nextInt(10) + 1;
//                }
//            }
            System.out.println("Enter elements of Matrix 1:");              //Input the elements of matrix 1
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    matrix1[i][j] = scanner.nextInt();
                }
            }
            System.out.println("Enter elements of Matrix 2:");              //Input the elements of matrix 2
            for (int i = 0; i < row2; i++) {
                for (int j = 0; j < col2; j++) {
                    matrix2[i][j] = scanner.nextInt();
                }
            }

            int[][] productMatrix = new int[row1][col2];                    //Declaring the product matrix

            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    productMatrix[i][j] = 0;                                //Initializing the product matrix to zero
                    for (int k = 0; k < row2; k++) {
                        productMatrix[i][j] += matrix1[i][k] * matrix2[k][j];//Calculating the product and storing it in the product matrix
                    }
                }
            }
            System.out.println("Matrix 1:");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    System.out.print(matrix1[i][j] + "\t");
                }
                System.out.println();
            }

            System.out.println("Matrix 2:");
            for (int i = 0; i < row2; i++) {
                for (int j = 0; j < col2; j++) {
                    System.out.print(matrix2[i][j] + "\t");
                }
                System.out.println();
            }

            System.out.println("Their product:");                           //Output the product matrix
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    System.out.print(productMatrix[i][j] + "\t");
                }
                System.out.println();
            }
        } else {                                                            //If the matrices cannot be multiplied then printing the error messages
            System.out.println("Error!");
            System.out.println("The number of columns of matrix 1 must be equal to number of rows of matrix 2!");
        }
    }
}
