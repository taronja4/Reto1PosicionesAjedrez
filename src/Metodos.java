import java.util.Scanner;

public class Metodos {
    
    public static void elMenu() {
        System.out.println();
        System.out.println("Las piezas del ajedrez son: ");
        System.out.println("P - \u265F Peón \u2659");
        System.out.println("A - \u265D Alfíl \u2657");
        System.out.println("T - \u265C Torre \u2656");
        System.out.println("C - \u265E Caballo \u2658");
        System.out.println("D - \u265B Dama/Reina \u2655");
        System.out.println("R - \u265A Rey \u2654");
        System.out.println("S - \uD83D\uDC4B Salir del programa \uD83D\uDC4B");
        System.out.println();
    }

    public static String posicion(){
        System.out.println("Indica la posicion de tu ficha: ");
        Scanner sc = new Scanner(System.in);
        String posiMayus = sc.nextLine();
        do {
            posiMayus=posiMayus.toUpperCase();
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
        Scanner sc = new Scanner(System.in);
        String piezaelegida;
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
                System.out.println("¿En que pieza quieres convertir el peón?");
                System.out.println("A - \u265D Alfíl \u2657");
                System.out.println("T - \u265C Torre \u2656");
                System.out.println("C - \u265E Caballo \u2658");
                System.out.println("D - \u265B Dama/Reina \u2655");
                piezaelegida=sc.next();
                do {
                    if (!piezaelegida.equalsIgnoreCase("A") && !piezaelegida.equalsIgnoreCase("D") && !piezaelegida.equalsIgnoreCase("c") && !piezaelegida.equalsIgnoreCase("T")){
                        System.out.println("No has escogido una pieza correcta");
                        System.out.println("¿En que pieza quieres convertir el peón?");
                        System.out.println("A - \u265D Alfíl \u2657");
                        System.out.println("T - \u265C Torre \u2656");
                        System.out.println("C - \u265E Caballo \u2658");
                        System.out.println("D - \u265B Dama/Reina \u2655");
                        piezaelegida=sc.next();
                    }
                    if (piezaelegida.equalsIgnoreCase("A")){
                        System.out.println("Tu peón se convierte en alfil");
                    } if (piezaelegida.equalsIgnoreCase("D")){
                        System.out.println("Tu peón se convierte en dama");
                    } if (piezaelegida.equalsIgnoreCase("C")){
                        System.out.println("Tu peón se convierte en caballo");
                    } if (piezaelegida.equalsIgnoreCase("T")){
                        System.out.println("Tu peón se convierte en Torre");
                    }
                } while (!piezaelegida.equalsIgnoreCase("A") && !piezaelegida.equalsIgnoreCase("D") && !piezaelegida.equalsIgnoreCase("c") && !piezaelegida.equalsIgnoreCase("T"));
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
                System.out.println("¿En que pieza quieres convertir el peón?");
                System.out.println("A - \u265D Alfíl \u2657");
                System.out.println("T - \u265C Torre \u2656");
                System.out.println("C - \u265E Caballo \u2658");
                System.out.println("D - \u265B Dama/Reina \u2655");
                piezaelegida=sc.next();
                do {
                    if (!piezaelegida.equalsIgnoreCase("A") && !piezaelegida.equalsIgnoreCase("D") && !piezaelegida.equalsIgnoreCase("c") && !piezaelegida.equalsIgnoreCase("T")){
                        System.out.println("No has escogido una pieza correcta");
                        System.out.println("¿En que pieza quieres convertir el peón?");
                        System.out.println("A - \u265D Alfíl \u2657");
                        System.out.println("T - \u265C Torre \u2656");
                        System.out.println("C - \u265E Caballo \u2658");
                        System.out.println("D - \u265B Dama/Reina \u2655");
                        piezaelegida=sc.next();
                    }
                    if (piezaelegida.equalsIgnoreCase("A")){
                        System.out.println("Tu peón se convierte en alfil");
                    } if (piezaelegida.equalsIgnoreCase("D")){
                        System.out.println("Tu peón se convierte en dama");
                    } if (piezaelegida.equalsIgnoreCase("C")){
                        System.out.println("Tu peón se convierte en caballo");
                    } if (piezaelegida.equalsIgnoreCase("T")){
                        System.out.println("Tu peón se convierte en Torre");
                    }
                } while (!piezaelegida.equalsIgnoreCase("A") && !piezaelegida.equalsIgnoreCase("D") && !piezaelegida.equalsIgnoreCase("c") && !piezaelegida.equalsIgnoreCase("T"));
            }else if (pasarNumAASCII <= 1){
                System.out.println("El peón no puede hacer el siguiente movimiento porque se sale del tablero.");
            }else {
                System.out.println("Puede moverse a " + "" + letra + numeroFinalNoEnASCII);
            }
        }
        System.out.println();
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
        String posicionTablero = "";
        String quitarComa = "";
        for (int i = 0; i < moverLetra.length; i++) {
            int letraFinal = indiceLetra + moverLetra[i];
            int numerofinal = indiceNumero + moverNumero[i];
            if (letraFinal >= 0 && letraFinal < 8 && numerofinal >= 0 && numerofinal < 8) {
                System.out.print(quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal]);
                posicionTablero += quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal];
                quitarComa = ", ";
            }
        }
        System.out.println();
        String convertirArray = posicionTablero;
        String[] arrayConLosMovimientos = convertirArray.split(", ");
        String[] arrayCoordenadas = arrayConLosMovimientos;
        char[][] tablero = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = ' ';
            }
        }

        System.out.println();

        String posicionInicialDeLaPieza = posicion;
        int filaNumero = 8 - Character.getNumericValue(posicionInicialDeLaPieza.charAt(1));
        int columnaLetra = posicionInicialDeLaPieza.charAt(0) - 'A';
        tablero[filaNumero][columnaLetra] = 'A';
        
        for (int i = 0; i < arrayCoordenadas.length; i++) {
            String coordenada = arrayCoordenadas[i];
            int fila = 8 - Character.getNumericValue(coordenada.charAt(1));
            int columna = coordenada.charAt(0) - 'A';
            tablero[fila][columna] = 'X';
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("[" + tablero[i][j] + "] ");
            }
            System.out.println();
        }
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
        String posicionTablero = "";
        String quitarComa = "";
        for (int i = 0; i < moverLetra.length; i++) {
            int letraFinal = indiceLetra + moverLetra[i];
            int numerofinal = indiceNumero + moverNumero[i];
            if (letraFinal >= 0 && letraFinal < 8 && numerofinal >= 0 && numerofinal < 8) {
                System.out.print(quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal]);
                posicionTablero += quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal];
                quitarComa = ", ";
            }
        }
        System.out.println();
        String convertirArray = posicionTablero;
        String[] arrayConLosMovimientos = convertirArray.split(", ");
        String[] arrayCoordenadas = arrayConLosMovimientos;
        char[][] tablero = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = ' ';
            }
        }

        System.out.println();

        String posicionInicialDeLaPieza = posicion;
        int filaNumero = 8 - Character.getNumericValue(posicionInicialDeLaPieza.charAt(1));
        int columnaLetra = posicionInicialDeLaPieza.charAt(0) - 'A';
        tablero[filaNumero][columnaLetra] = 'T';
        
        for (int i = 0; i < arrayCoordenadas.length; i++) {
            String coordenada = arrayCoordenadas[i];
            int fila = 8 - Character.getNumericValue(coordenada.charAt(1));
            int columna = coordenada.charAt(0) - 'A';
            tablero[fila][columna] = 'X';
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("[" + tablero[i][j] + "] ");
            }
            System.out.println();
        }
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
        String posicionTablero = "";
        String quitarComa = "";
        for (int i = 0; i < moverLetra.length; i++) {
            int letraFinal = indiceLetra + moverLetra[i];
            int numerofinal = indiceNumero + moverNumero[i];
            if (letraFinal >= 0 && letraFinal < 8 && numerofinal >= 0 && numerofinal < 8) {
                System.out.print(quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal]);
                posicionTablero += quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal];
                quitarComa = ", ";
            }
        }
        System.out.println();
        String convertirArray = posicionTablero;
        String[] arrayConLosMovimientos = convertirArray.split(", ");
        String[] arrayCoordenadas = arrayConLosMovimientos;
        char[][] tablero = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = ' ';
            }
        }

        System.out.println();

        String posicionInicialDeLaPieza = posicion;
        int filaNumero = 8 - Character.getNumericValue(posicionInicialDeLaPieza.charAt(1));
        int columnaLetra = posicionInicialDeLaPieza.charAt(0) - 'A';
        tablero[filaNumero][columnaLetra] = 'C';
        
        for (int i = 0; i < arrayCoordenadas.length; i++) {
            String coordenada = arrayCoordenadas[i];
            int fila = 8 - Character.getNumericValue(coordenada.charAt(1));
            int columna = coordenada.charAt(0) - 'A';
            tablero[fila][columna] = 'X';
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("[" + tablero[i][j] + "] ");
            }
            System.out.println();
        }
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
        String posicionTablero = "";
        String quitarComa = "";
        for (int i = 0; i < moverLetra.length; i++) {
            int letraFinal = indiceLetra + moverLetra[i];
            int numerofinal = indiceNumero + moverNumero[i];
            if (letraFinal >= 0 && letraFinal < 8 && numerofinal >= 0 && numerofinal < 8) {
                System.out.print(quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal]);
                posicionTablero += quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal];
                quitarComa = ", ";
            }
        }
        System.out.println();
        String convertirArray = posicionTablero;
        String[] arrayConLosMovimientos = convertirArray.split(", ");
        String[] arrayCoordenadas = arrayConLosMovimientos;
        char[][] tablero = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = ' ';
            }
        }

        System.out.println();

        String posicionInicialDeLaPieza = posicion;
        int filaNumero = 8 - Character.getNumericValue(posicionInicialDeLaPieza.charAt(1));
        int columnaLetra = posicionInicialDeLaPieza.charAt(0) - 'A';
        tablero[filaNumero][columnaLetra] = 'D';
        
        for (int i = 0; i < arrayCoordenadas.length; i++) {
            String coordenada = arrayCoordenadas[i];
            int fila = 8 - Character.getNumericValue(coordenada.charAt(1));
            int columna = coordenada.charAt(0) - 'A';
            tablero[fila][columna] = 'X';
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("[" + tablero[i][j] + "] ");
            }
            System.out.println();
        }
        return "";
    }

    public static String movimientoRey(String posicion) {
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
        String posicionTablero = "";
        String quitarComa = "";
        for (int i = 0; i < moverLetra.length; i++) {
            int letraFinal = indiceLetra + moverLetra[i];
            int numerofinal = indiceNumero + moverNumero[i];
            if (letraFinal >= 0 && letraFinal < 8 && numerofinal >= 0 && numerofinal < 8) {
                System.out.print(quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal]);
                posicionTablero += quitarComa + arrayLetra[letraFinal] + arrayNumero[numerofinal];
                quitarComa = ", ";
            }
        }
        System.out.println();
        String convertirArray = posicionTablero;
        String[] arrayConLosMovimientos = convertirArray.split(", ");
        String[] arrayCoordenadas = arrayConLosMovimientos;
        char[][] tablero = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = ' ';
            }
        }

        System.out.println();

        String posicionInicialDeLaPieza = posicion;
        int filaNumero = 8 - Character.getNumericValue(posicionInicialDeLaPieza.charAt(1));
        int columnaLetra = posicionInicialDeLaPieza.charAt(0) - 'A';
        tablero[filaNumero][columnaLetra] = 'R';
        
        for (int i = 0; i < arrayCoordenadas.length; i++) {
            String coordenada = arrayCoordenadas[i];
            int fila = 8 - Character.getNumericValue(coordenada.charAt(1));
            int columna = coordenada.charAt(0) - 'A';
            tablero[fila][columna] = 'X';
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("[" + tablero[i][j] + "] ");
            }
            System.out.println();
        }
        return "";
    }
}
