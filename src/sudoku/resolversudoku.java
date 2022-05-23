package sudoku;

public class resolversudoku {
	
	private static final int size = 9; 

	public static void main(String[] args) {

		int[][] tablero = {
				{7, 0, 2, 0, 5, 0, 6, 0, 0},
				{0, 0, 0, 0, 0, 3, 0, 0, 0},
				{1, 0, 0, 0, 0, 9, 5, 0, 0},
				{8, 0, 0, 0, 0, 0, 0, 9, 0},
				{0, 4, 3, 0, 0, 0, 7, 5, 0},
				{0, 9, 0, 0, 0, 0, 0, 0, 8},
				{0, 0, 9, 7, 0, 0, 0, 0, 5},
				{0, 0, 0, 2, 0, 0, 0, 0, 0},
				{0, 0, 7, 0, 4, 0, 2, 0, 3},
		};	
		
		mostrarTablero(tablero);
	
		if (resolverTablero(tablero)) {
			System.out.println("Resuelto con exito");
		}
		else {
			System.out.println("Sin resolucion");
		}
		mostrarTablero(tablero);
	}
	
	private static void mostrarTablero(int[][] tablero) {
		for (int fila = 0; fila < size; fila++) {
			if (fila % 3 == 0 && fila != 0) {
				System.out.println("-----------");
			}
			for (int columna = 0; columna < size; columna++) {
				if (columna % 3 == 0 && columna != 0) {
					System.out.print("|");
				}
				System.out.print(tablero[fila][columna]);
			}
			System.out.println();
		}
		
	}
	
	private static boolean numeroFila(int[][] tablero, int numero, int fila) {
		for (int i = 0; i < size; i++) {
			if (tablero[fila][i] == numero) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean numeroColumna(int[][] tablero, int numero, int columna) {
		for (int i = 0; i < size; i++) {
			if (tablero[i][columna] == numero) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean numeroPosicion(int[][] tablero, int numero, int fila, int columna) {
		int lugarFila = fila - fila % 3;
		int lugarColumna = columna - columna % 3;
		
		for (int i = lugarFila; i< lugarFila + 3; i++){
			for (int j = lugarColumna; j< lugarColumna + 3; j++) {
				if (tablero[i][j] == numero) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean posicionValida(int[][] tablero, int numero, int fila, int columna) {
		return !numeroFila(tablero, numero, fila) && !numeroColumna(tablero, numero, columna) && !numeroPosicion(tablero, numero, fila, columna);
	}
	
	private static boolean resolverTablero(int[][] tablero) {
		for (int fila = 0; fila < size; fila++) {
			for (int columna = 0; columna < size; columna++) {
				if (tablero[fila][columna] == 0) {
					for (int probarNumero = 1; probarNumero <= size; probarNumero++) {
						if (posicionValida(tablero, probarNumero, fila, columna)) {
							tablero[fila][columna] = probarNumero;
							if (resolverTablero(tablero)) {
								return true;
							}
							else {
								tablero[fila][columna] = 0;
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
