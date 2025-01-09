import java.util.Scanner;

public class Metodos {

    public static String posicion(){
        System.out.println("Indica la posicion de tu ficha: ");
        Scanner sc=new Scanner(System.in);
        String posi=sc.nextLine();
        String posiMayus = posi.toUpperCase();
        do {
            if (validarPosicion(posiMayus)){

                return posiMayus;

            }else {
                System.out.println("Pon una posición válida:");
                posiMayus=sc.nextLine();
            }
        } while (!validarPosicion(posiMayus));

        return posiMayus;
    }

    public static boolean validarPosicion(String posicion) {
        boolean posicionValida = true;

        if (posicion == null || posicion.length() != 2) {
            posicionValida = false;
        } else {
            char letra = posicion.charAt(0);
            if (letra != 'A' && letra != 'B' && letra != 'C' && letra != 'D' && letra != 'E' && letra != 'F' && letra != 'G' && letra != 'H') {
                posicionValida = false;
            }

            char numero = posicion.charAt(1);
            if (numero < '1' || numero > '8') {
                posicionValida = false;
            }
        }

        return posicionValida;
    }

    public static String colorPieza (){
        Scanner sc = new Scanner(System.in);
        boolean elBooleano = true;
        String letraDelColor;
        do {
            System.out.println("B-> Blanco");
            System.out.println("N-> Negro");
            System.out.println("Escoge un color (solo blanco y negro): ");
            String colorPieza = sc.nextLine();
            letraDelColor = colorPieza.toUpperCase();
            if (!letraDelColor.equals("B") && !letraDelColor.equals("N")){
                System.out.println("Escoge una letra correcta");
                System.out.println(" ");
                elBooleano = true;
            }else if (letraDelColor.equals("B")){
                System.out.println("Has escogido las blancas");
                System.out.println(" ");
                elBooleano = false;
            }else if (letraDelColor.equals("N")){
                System.out.println("Has escogido las negras");
                System.out.println(" ");
                elBooleano = false;
            }
        }while (elBooleano);
        return letraDelColor;
    }

    public static int movimientoPeon () {
        int posicion = 0;
        String color = colorPieza();
        String posicionPeon = posicion();
        if (color.equals("B")){
            char letra = posicionPeon.charAt(0);
            char num = posicionPeon.charAt(1);
            int pasarNumAASCII = Character.getNumericValue(num);
            int movimientoPeon = num + 1;
            int numeroFinalNoEnASCII = Character.getNumericValue(movimientoPeon);
            if (pasarNumAASCII == 2){
                System.out.println("Puede moverse a " + letra + (numeroFinalNoEnASCII) + " y " + letra + (numeroFinalNoEnASCII + 1));
            } else if (pasarNumAASCII == 1) {
                System.out.println("Posición incorrecta, el peón blanco nunca puede estar en la fila 1.");
            }else if (pasarNumAASCII == 7) {
                System.out.println("Avanza a " + "" + letra + numeroFinalNoEnASCII);
                System.out.println("El peón llega a la última casilla y se transforma en Dama.");
            }else if (pasarNumAASCII >= 8) {
                System.out.println("El peón no puede hacer el siguiente movimiento porque se sale del tablero.");
            }else {
                System.out.println("Puede moverse a " + "" + letra + numeroFinalNoEnASCII);
            }
        }
        if (color.equals("N")){
            char letra=posicionPeon.charAt(0);
            char num=posicionPeon.charAt(1);
            int pasarNumAASCII =Character.getNumericValue(num);
            int movimientoPeon = num - 1;
            int numeroFinalNoEnASCII = Character.getNumericValue(movimientoPeon);
            if (pasarNumAASCII == 7){
                System.out.println("Puede moverse a " + letra + (numeroFinalNoEnASCII) + " y " + letra+(numeroFinalNoEnASCII - 1));
            } else if (pasarNumAASCII == 8) {
                System.out.println("Posición incorrecta, el peón negro nunca puede estar en la fila 8.");
            }else if (pasarNumAASCII == 2){
                System.out.println("Avanza a " + "" + letra + numeroFinalNoEnASCII);
                System.out.println("El peón llega a la última casilla y se transforma en Dama.");
            }else if (pasarNumAASCII <= 1){
                System.out.println("El peón no puede hacer el siguiente movimiento porque se sale del tablero.");
            }else {
                System.out.println("Puede moverse a " + "" + letra + numeroFinalNoEnASCII);
            }
        }
        return posicion;
    }

    public static String movimientoAlfil(String posicion) {
        char[] arrayLetra = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        char[] arrayNumero = {'1', '2', '3', '4', '5', '6', '7', '8'};
        char letraPosicion = posicion.charAt(0);
        char numeroPosicion = posicion.charAt(1);
        int indiceLetra = -1;
        int indiceNumero = -1;
        int[] moverLetra = {-1, -1, 1, 1, -2, -2, 2, 2,-3, -3, 3, 3, -4, -4, 4, 4, -5, -5, 5, 5, -6, -6, 6, 6, -7, -7, 7, 7};
        int[] moverNumero = {-1, 1, 1, -1, -2, 2, 2, -2, -3, 3, 3, -3, -4, 4, 4, -4, -5, 5, 5, -5, -6, 6, 6, -6, -7, 7, 7, -7};

        for (int i = 0; i < arrayLetra.length; i++) {
            if (arrayLetra[i] == letraPosicion) {
                indiceLetra = i;
            }
        }
        for (int i = 0; i < arrayNumero.length; i++) {
            if (arrayNumero[i] == numeroPosicion) {
                indiceNumero = i;
            }
        }

        System.out.print("Desde " + posicion + " los posibles movimientos son: ");

        String quitarComa = "";
        for (int i = 0; i < moverLetra.length; i++) {
            int letraFinal = indiceLetra + moverLetra[i];
            int numerofinal = indiceNumero + moverNumero[i];

            if (letraFinal >= 0 && letraFinal < 8 && numerofinal >= 0 && numerofinal < 8) {
                System.out.print(quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal]);
                quitarComa = ", ";
            }
        }

        System.out.println();
        return "";
    }

    public static String movimientoTorre (String posicion) {
        char[] arrayLetra = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        char[] arrayNumero = {'1', '2', '3', '4', '5', '6', '7', '8'};
        char letraPosicion = posicion.charAt(0);
        char numeroPosicion = posicion.charAt(1);
        int indiceLetra = -1;
        int indiceNumero = -1;
        int[] moverLetra = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7};
        int[] moverNumero = {1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < arrayLetra.length; i++) {
            if (arrayLetra[i] == letraPosicion) {
                indiceLetra = i;
            }
        }
        for (int i = 0; i < arrayNumero.length; i++) {
            if (arrayNumero[i] == numeroPosicion) {
                indiceNumero = i;
            }
        }

        System.out.print("Desde " + posicion + " los posibles movimientos son: ");

        String quitarComa = "";
        for (int i = 0; i < moverLetra.length; i++) {
            int letraFinal = indiceLetra + moverLetra[i];
            int numerofinal = indiceNumero + moverNumero[i];

            if (letraFinal >= 0 && letraFinal < 8 && numerofinal >= 0 && numerofinal < 8) {
                System.out.print(quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal]);
                quitarComa = ", ";
            }
        }

        System.out.println();
        return "";
    }
    public static String movimientoCaballo(String posicion) {
        char[] arrayLetra = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        char[] arrayNumero = {'1', '2', '3', '4', '5', '6', '7', '8'};
        char letraPosicion = posicion.charAt(0);
        char numeroPosicion = posicion.charAt(1);
        int indiceLetra = -1;
        int indiceNumero = -1;
        int[] moverLetra = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] moverNumero = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int i = 0; i < arrayLetra.length; i++) {
            if (arrayLetra[i] == letraPosicion) {
                indiceLetra = i;
            }
        }
        for (int i = 0; i < arrayNumero.length; i++) {
            if (arrayNumero[i] == numeroPosicion) {
                indiceNumero = i;
            }
        }

        System.out.print("Desde " + posicion + " los posibles movimientos son: ");

        String quitarComa = "";
        for (int i = 0; i < moverLetra.length; i++) {
            int letraFinal = indiceLetra + moverLetra[i];
            int numerofinal = indiceNumero + moverNumero[i];

            if (letraFinal >= 0 && letraFinal < 8 && numerofinal >= 0 && numerofinal < 8) {
                System.out.print(quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal]);
                quitarComa = ", ";
            }
        }

        System.out.println();
        return "";
    }

    public static String movimientoReina (String posicion) {
        char[] arrayLetra = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        char[] arrayNumero = {'1', '2', '3', '4', '5', '6', '7', '8'};
        char letraPosicion = posicion.charAt(0);
        char numeroPosicion = posicion.charAt(1);
        int indiceLetra = -1;
        int indiceNumero = -1;
        int[] moverLetra = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -7, -6, -5, -4, -3, -2, -1, 1, 2, 3, 4, 5, 6, 7, -1, -1, 1, 1, -2, -2, 2, 2,-3, -3, 3, 3, -4, -4, 4, 4, -5, -5, 5, 5, -6, -6, 6, 6, -7, -7, 7, 7};
        int[] moverNumero = {1, 2, 3, 4, 5, 6, 7, -1, -2, -3, -4, -5, -6, -7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 1, 1, -1, -2, 2, 2, -2, -3, 3, 3, -3, -4, 4, 4, -4, -5, 5, 5, -5, -6, 6, 6, -6, -7, 7, 7, -7};

        for (int i = 0; i < arrayLetra.length; i++) {
            if (arrayLetra[i] == letraPosicion) {
                indiceLetra = i;
            }
        }
        for (int i = 0; i < arrayNumero.length; i++) {
            if (arrayNumero[i] == numeroPosicion) {
                indiceNumero = i;
            }
        }

        System.out.print("Desde " + posicion + " los posibles movimientos son: ");

        String quitarComa = "";
        for (int i = 0; i < moverLetra.length; i++) {
            int letraFinal = indiceLetra + moverLetra[i];
            int numerofinal = indiceNumero + moverNumero[i];

            if (letraFinal >= 0 && letraFinal < 8 && numerofinal >= 0 && numerofinal < 8) {
                System.out.print(quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal]);
                quitarComa = ", ";
            }
        }

        System.out.println();
        return "";
    }

    public static String movimientoRey (String posicion) {
        char[] arrayLetra = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        char[] arrayNumero = {'1', '2', '3', '4', '5', '6', '7', '8'};
        char letraPosicion = posicion.charAt(0);
        char numeroPosicion = posicion.charAt(1);
        int indiceLetra = -1;
        int indiceNumero = -1;
        int[] moverLetra = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] moverNumero = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < arrayLetra.length; i++) {
            if (arrayLetra[i] == letraPosicion) {
                indiceLetra = i;
            }
        }
        for (int i = 0; i < arrayNumero.length; i++) {
            if (arrayNumero[i] == numeroPosicion) {
                indiceNumero = i;
            }
        }

        System.out.print("Desde " + posicion + " los posibles movimientos son: ");

        String quitarComa = "";
        for (int i = 0; i < moverLetra.length; iMovimientos de las piezas++) {
            int letraFinal = indiceLetra + moverLetra[i];
            int numerofinal = indiceNumero + moverNumero[i];

            if (letraFinal >= 0 && letraFinal < 8 && numerofinal >= 0 && numerofinal < 8) {
                System.out.print(quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal]);
                quitarComa = ", ";
            }
        }

        System.out.println();
        return "";
    }
}
