import java.util.Scanner;

//Inicio de programa
public class Sistema_de_Evaluacion {

    //Aqui ingresamos la informacion de cuantos estudiantes.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Universidad Mariano Gálvez - Sede Portales ");
        System.out.println(" Autor: Harvey Ramirez ");
        System.out.println(" Calcula promedio, calificación y estado (aprobado/reprobado). ");
        System.out.println(" Sistema de evalucaion academica ");
        System.out.print("¿Cuántos estudiantes vas a evaluar?: ");
        int numEstudiantes = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer

        String[] nombres = new String[numEstudiantes];
        double[][] notasEstudiantes = new double[numEstudiantes][];

        // Ingresar datos para cada estudiante
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.printf("\n=== Estudiante #%d ===\n", i + 1);
            System.out.print("Nombre: ");
            nombres[i] = scanner.nextLine();

            System.out.print("¿Cuántas notas tiene el estudiante?: ");
            int numNotas = scanner.nextInt();
            notasEstudiantes[i] = new double[numNotas];

            System.out.println("Ingresa las notas (una por una):");
            for (int j = 0; j < numNotas; j++) {
                System.out.printf("Nota #%d: ", j + 1);
                notasEstudiantes[i][j] = scanner.nextDouble();
            }
            scanner.nextLine(); // Limpiar el buffer después de leer los números
        }

        // Mostrar resultados
        System.out.println("\n=== RESULTADOS FINALES ===");
        for (int i = 0; i < numEstudiantes; i++) {
            mostrarResultado(nombres[i], notasEstudiantes[i]);
        }

        scanner.close();
    }

    // calcularPromedio, obtenerLiteral, mostrarResultado
    public static double calcularPromedio(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    public static char obtenerLiteral(double promedio) {
        if (promedio >= 90) return 'A';
        else if (promedio >= 80) return 'B';
        else if (promedio >= 70) return 'C';
        else if (promedio >= 60) return 'D';
        else return 'F';
    }

    public static boolean estaAprobado(char literal) {
        return literal == 'A' || literal == 'B' || literal == 'C';
    }

    public static void mostrarResultado(String nombre, double[] notas) {
        double promedio = calcularPromedio(notas);
        char literal = obtenerLiteral(promedio);
        String resultado = estaAprobado(literal) ? "Aprobado" : "Reprobado";

        System.out.println("\n**Estudiante:** " + nombre);
        System.out.print("**Notas:** [");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]);
            if (i < notas.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.printf("**Promedio:** %.2f\n", promedio);
        System.out.println("**Literal:** " + literal);
        System.out.println("**Resultado:** " + resultado);
    }
}