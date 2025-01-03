
import java.util.Random;


/**
 * El primer ciclo paralelo C, cuenta con 28 estudiantes, de los cuáles al finalizar el periodo,
 * la Dirección de la carrera de Computación a solicitado las siguientes estadísticas de la materia
 * INTRODUCCIÓN A LA PROGRAMACIÓN en función a los promedios por estudiante, dichos promedios se deben calcular (ponderar, ya que el docente ingresa todo sobre 10pts.) de 3 calificaciones (ACD que representa el 35% de la nota, APE del 35% y la nota del AA con un peso del 30%). En resumen, los requerimientos son los siguientes:
 *
 * Registre los nombres de cada estudiante de dicho paralelo.
 * Genere aleatoriamente las notas ACD, APE, AA, para cada uno de los 28 estudiantes de 0-10 pts.
 * Calcule el promedio de cada uno de los estudiantes del paralelo dada la siguiente ponderación: ACD->35%, APE->35%, y el AA->30%.
 * Obtenga el promedio del curso, del paralelo C.
 * Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por encima del promedio del curso.
 * Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por debajo del promedio del curso.
 * Muestre el estudiante con su calificación, si es el del mayor promedio (el más alto de la clase).
 * Muestre el estudiante con su calificación, si es el del menor promedio (el más bajo de la clase).
 *
 * @author sebas
 */
public class problema3_Ponderacion {
    public static void main(String[] args) {
        final int STUDENTS = 28; // Número de estudiantes
        final int COLUMNS = 4;  // Columnas: 0->ACD, 1->APE, 2->AA, 3->Promedio

        String[] names = new String[STUDENTS];
        double[][] grades = new double[STUDENTS][COLUMNS];

        // Generar nombres y notas aleatorias
        Random random = new Random();
        for (int i = 0; i < STUDENTS; i++) {
            names[i] = "Estudiante_" + (i + 1); // Nombres ficticios
            grades[i][0] = random.nextDouble() * 10; // Nota ACD
            grades[i][1] = random.nextDouble() * 10; // Nota APE
            grades[i][2] = random.nextDouble() * 10; // Nota AA
            grades[i][3] = calculateWeightedAverage(grades[i]); // Promedio ponderado
        }

        // Obtener el promedio del curso
        double courseAverage = calculateCourseAverage(grades);

        // Obtener estudiantes con promedio por encima y debajo del promedio del curso
        System.out.println("Estudiantes con promedio por encima del promedio del curso (" + courseAverage + "):");
        for (int i = 0; i < STUDENTS; i++) {
            if (grades[i][3] > courseAverage) {
                System.out.println(names[i] + " -> Promedio: " + grades[i][3]);
            }
        }

        System.out.println("\nEstudiantes con promedio por debajo del promedio del curso (" + courseAverage + "):");
        for (int i = 0; i < STUDENTS; i++) {
            if (grades[i][3] < courseAverage) {
                System.out.println(names[i] + " -> Promedio: " + grades[i][3]);
            }
        }

        // Estudiante con el mayor promedio
        int highestIndex = findHighestIndex(grades);
        System.out.println("\nEstudiante con el mayor promedio:");
        System.out.println(names[highestIndex] + " -> Promedio: " + grades[highestIndex][3]);

        // Estudiante con el menor promedio
        int lowestIndex = findLowestIndex(grades);
        System.out.println("\nEstudiante con el menor promedio:");
        System.out.println(names[lowestIndex] + " -> Promedio: " + grades[lowestIndex][3]);
    }

    // Método para calcular el promedio ponderado de un estudiante
    public static double calculateWeightedAverage(double[] grades) {
        return (grades[0] * 0.35) + (grades[1] * 0.35) + (grades[2] * 0.30);
    }

    // Método para calcular el promedio del curso
    public static double calculateCourseAverage(double[][] grades) {
        double total = 0;
        for (double[] student : grades) {
            total += student[3]; // Sumar los promedios
        }
        return total / grades.length; // Dividir por el número de estudiantes
    }

    // Método para encontrar el índice del estudiante con el mayor promedio
    public static int findHighestIndex(double[][] grades) {
        int index = 0;
        double highest = grades[0][3];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i][3] > highest) {
                highest = grades[i][3];
                index = i;
            }
        }
        return index;
    }

    // Método para encontrar el índice del estudiante con el menor promedio
    public static int findLowestIndex(double[][] grades) {
        int index = 0;
        double lowest = grades[0][3];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i][3] < lowest) {
                lowest = grades[i][3];
                index = i;
            }
        }
        return index;
    }
}



