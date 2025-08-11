import java.util.ArrayList;
import java.util.Scanner;

public class Cajero_automatico {
    static double saldo = 1000.00; // Saldo inicial
    static ArrayList<String> historial = new ArrayList<>(); // Para tener un Historial

    public static void main(String[] args) {
        iniciarSesion();
    }

    static void mostrarMenu() {
        System.out.println("\n** Bienvenido al Cajero Automático **");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Salir");
        System.out.print("Opción: ");
    }

    static void consultarSaldo() {
        System.out.printf("Su saldo actual es: Q%.2f\n", saldo);
        historial.add("Consulta de saldo: Q" + String.format("%.2f", saldo));
    }

    static void depositarDinero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese monto a depositar: Q");
        double monto = scanner.nextDouble();

        if (monto > 0) {
            saldo += monto;
            System.out.printf("Depósito exitoso. Nuevo saldo: Q%.2f\n", saldo);
            historial.add("Depósito de Q" + String.format("%.2f", monto));
        } else {
            System.out.println(" Monto inválido.");
        }
    }

    static void retirarDinero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese monto a retirar: Q");
        double monto = scanner.nextDouble();

        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.printf("Retiro exitoso. Nuevo saldo: Q%.2f\n", saldo);
            historial.add("Retiro de Q" + String.format("%.2f", monto));
        } else {
            System.out.println(" Fondos insuficientes o monto inválido.");
        }
    }

    static void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    depositarDinero();
                    break;
                case 3:
                    retirarDinero();
                    break;
                case 4:
                    System.out.println("\n** Historial de transacciones **");
                    for (String transaccion : historial) {
                        System.out.println(transaccion);
                    }
                    System.out.println("¡Hasta luego! 👋");
                    break;
                default:
                    System.out.println(" Opción inválida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
