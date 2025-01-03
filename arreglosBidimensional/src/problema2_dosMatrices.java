
import java.util.Random;
import java.util.Scanner;

/**
 * Dadas dos matrices (cuadradas y/o rectangulares) de valores enteros
 * aleatorios, desarrollar su procesamiento para calcular y presentar:
 *
 * La suma de las dos matrices (considerar las restricciones matemáticas para
 * ello). La multiplicación de las dos matrices (considerar las reglas
 * matemáticas para ello).
 *
 * @author sebas
 */
public class problema2_dosMatrices {

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        Random ran = new Random();
        int rowsA = 3, colsA = 3; // Matriz A (3x3)
        int rowsB = 3, colsB = 3; // Matriz B (3x3)

        // Generar matrices con valores aleatorios
        int[][] matrixA = generateRandomMatrix(rowsA, colsA);
        int[][] matrixB = generateRandomMatrix(rowsB, colsB);

        // Mostrar las matrices originales
        System.out.println("Matriz A:");
        printMatrix(matrixA);
        System.out.println("\nMatriz B:");
        printMatrix(matrixB);

        // Suma de matrices (si tienen las mismas dimensiones)
        if (rowsA == rowsB && colsA == colsB) {
            int[][] sumMatrix = addMatrices(matrixA, matrixB);
            System.out.println("\nSuma de A + B:");
            printMatrix(sumMatrix);
        } else {
            System.out.println("\nNo se puede realizar la suma: las dimensiones de las matrices no coinciden.");
        }

        // Multiplicación de matrices (si las dimensiones son compatibles)
        if (colsA == rowsB) {
            int[][] productMatrix = multiplyMatrices(matrixA, matrixB);
            System.out.println("\nMultiplicación de A x B:");
            printMatrix(productMatrix);
        } else {
            System.out.println("\nNo se puede realizar la multiplicación: las dimensiones de las matrices no son compatibles.");
        }
    }

    // Método para generar una matriz aleatoria
    public static int[][] generateRandomMatrix(int rows, int cols) {
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10); // Valores aleatorios entre 0 y 9
            }
        }
        return matrix;
    }

    // Método para imprimir una matriz
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    // Método para sumar dos matrices
    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }

    // Método para multiplicar dos matrices
    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;
        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }
}
/***
 * run:
Matriz A:
3	6	3	
7	3	6	
5	8	9	

Matriz B:
6	2	6	
9	3	5	
3	4	0	

Suma de A + B:
9	8	9	
16	6	11	
8	12	9	

Multiplicación de A x B:
81	36	48	
87	47	57	
129	70	70	
BUILD SUCCESSFUL (total time: 0 seconds)
 */