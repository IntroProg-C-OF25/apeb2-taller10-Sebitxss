
import java.util.Random;
import java.util.Scanner;

/**
 * Dada una matriz cuadrada (m X m) de valores enteros aleatorios, desarrollar
 * su procesamiento para presentar los elementos:
 *
 * De la diagonal principal. De la diagonal segundaria. Ubicados bajo la
 * diagonal principal. Ubicados sobre la diagonal principal. Ubicados bajo la
 * diagonal secundaria. Ubicados sobre la diagonal secundaria.
 *
 * @author sebas
 */
public class problema1_MatrizCuadrada {

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        Random ram = new Random();
        int i, j;
        int m;
        //Aqui vamos a solicitar el tamaño de la matriz
        
        System.out.println("Ingrese el tamaño de la matriz: ");
        m = sca.nextInt();
        int[][] matriz = new int[m][m];
        //generamos la matriz
        System.out.println("\nMatriz generada:");
        for (i = 0; m < 4; m++) {
            for (j = 0; m < 4; m++) {
                //valores de 0 - 99
                matriz[i][j] = ram.nextInt(100);
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        //diagonal principal
        System.out.println("\nElementos de la diagonal principal:");
        for (i = 0; i < m; i++) {
            System.out.print(matriz[i][i] + " ");
        }
        //diagonal secundaria
        System.out.println("\nElementos de la diagonal secundaria:");
        for(i = 0; i < m; i++){
            System.out.print(matriz[i][m - 1 - i] + " ");;
        }
        //bajo la diagonal principal
        System.out.println("\nElementos bajo la diagonal principal:");
        for(i = 1; i< m; i++){
            for(j = 0; j < m; j++){
                System.out.print(matriz[i][j] + " ");
            }
        }
        //sobre la diagonal principal
        System.out.println("\n\nElementos sobre la diagonal principal:");
        for (i = 0; i < m; i++) {
            for (j = i + 1; j < m; j++) {
                System.out.print(matriz[i][j] + " ");
            }
        }
        //bajo la diagonal secundaria
        System.out.println("\nElementos bajo la diagonal secundaria:");
        for(i = 1; i < m; i++) {
            for(j = 0; j < m - 1; j++){
                System.out.print(matriz[i][j] + " ");
            }
        }
        //sobre la diagonal secundaria
        System.out.println("\nElementos sobre la diagonal secundaria:");
        for(i = 0; i < m; i++){
            for (j = m - 1; j < m; j++){
                System.out.print(matriz[i][j] + " ");
            }
        }
        
    }
}
