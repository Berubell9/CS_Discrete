import java.util.Scanner;
public class MatrixPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dim = sc.nextInt(), pow = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] result = matrixPower(matrix, pow);
        System.out.println("Result: ");
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    public static int[][] matrixPower(int[][] matrix, int pow) {
        int[][] result = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < pow-1; i++) {
            result = matrixMultiply(result, matrix);
        }
        return result;
    }

    public static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                for (int k = 0; k < matrix1.length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }
}

