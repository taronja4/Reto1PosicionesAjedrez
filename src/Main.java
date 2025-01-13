import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("|--------------------------------------|");
        System.out.println("|  BIENVENIDO/A AL MARAVILLOSO RETO 1  |");
        System.out.println("|   DEL EQUIPO SÓLIDO FORMADO POR      |");
        System.out.println("|       RAÚL, ADRIAN G, DAVID,         |");
        System.out.println("|        TONI Y JUAN CARLOS            |");
        System.out.println("|--------------------------------------|");

        Scanner sc = new Scanner(System.in);

        System.out.println("Las piezas del ajedrez son: ");
        System.out.println("P - \u265F Peón \u2659");
        System.out.println("A - \u265D Alfíl \u2657");
        System.out.println("T - \u265C Torre \u2656");
        System.out.println("C - \u265E Caballo \u2658");
        System.out.println("D - \u265B Dama/Reina \u2655");
        System.out.println("R - \u265A Rey \u2654");
        System.out.println("S - \uD83D\uDC4B Salir del programa \uD83D\uDC4B");
        System.out.println();
        boolean salirBucle = false;

        while (!salirBucle) {
            System.out.println();
            System.out.println("Escoge una pieza (solo una letra): ");
            String elegirPieza = sc.nextLine();

            switch (elegirPieza.toUpperCase()) {
                case "S":
                    System.out.println("Saliendo del programa en 3, 2, 1...");
                    System.out.println("Hasta la próxima! \uD83D\uDC4B");
                    salirBucle = true;
                    break;
                case "P":
                    Metodos.movimientoPeon();
                    break;
                case "A":
                    Metodos.movimientoAlfil(Metodos.posicion());
                    break;
                case "T":
                    Metodos.movimientoTorre(Metodos.posicion());
                    break;
                case "C":
                    Metodos.movimientoCaballo(Metodos.posicion());
                    break;
                case "D":
                    Metodos.movimientoReina(Metodos.posicion());
                    break;
                case "R":
                    Metodos.movimientoRey(Metodos.posicion());
                    break;
                default:
                    System.out.println("No has escogido una de las letras correctas.");
                    System.out.println();
            }
        }
    }
}
