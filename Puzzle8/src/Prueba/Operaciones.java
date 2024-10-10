package Prueba;

import java.util.Scanner;

import Estructura.Puzzle8;
import Pilas.ExcepcionDePilaLlena;
import Pilas.ExcepcionDePilaVacia;
import Pilas.PilaEstatica;

public class Operaciones {

	public Operaciones() {}
	
	public static Puzzle8 objeto(byte op) {
		Scanner sc = new Scanner(System.in);
		if(op==1) { Puzzle8 obj = new Puzzle8();return obj;}
		
		if(op==2) {
			byte a[] = new byte[9];
			for (int i = 0; i < a.length; i++) {
				System.out.println("ingresa el numero en la posicion "+ (i+1));
				a[i]= sc.nextByte();
			}
			Puzzle8 obj = new Puzzle8(a);return obj;}
		
		Puzzle8 obj = new Puzzle8("hola mundo");return obj;
		
	}
	
	public static byte juego(Puzzle8 b) throws ExcepcionDePilaLlena, ExcepcionDePilaVacia {
		PilaEstatica<Puzzle8> redo = new PilaEstatica<>(50);
		PilaEstatica<Puzzle8> undo = new PilaEstatica<>(51);
		
		Puzzle8 a = b;
		
		Scanner sc = new Scanner(System.in);
		byte op,m ; boolean v= false;
		a.posicion2();
		undo.push(a.copia());
		System.out.println("EL puzzle final debe de ser:");
		System.out.println("1 2 3 \n"+"8 0 4\n"+"7 6 5\n");
		System.out.println("EL array inicial es:");
		
		
		for(;;) { 
			System.out.println("Tienes "+(51-undo.size())+" intentos");
			imprimeArray(a.getPuzzle());
			
			System.out.println("SELECCIONE UN OPCION");
			System.out.println("1.- Redo (adelante)");
			System.out.println("2.- Undo (Atras)"); 
			System.out.println("3.- Movimiento ");
			System.out.println("4.- Ya No Quiero Jugar");
			op = sc.nextByte();
			
			switch(op) {
			case 1: // Al querer moverse a un estado adelante
				if(redo.isEmpty()) {System.out.println("No hay movimientos posteriores");break;}
				a = redo.pop().copia();
				undo.push(a.copia());
				break;
				
			case 2: // Al querer moverse al estado anterior
				if(undo.size()==1) {System.out.println("No hay movimientos anteriores");break;}
				redo.push(undo.pop().copia()); a= undo.top().copia();
				break;
				
			
			case 3: // Al realizar movimiento
				if(undo.isFull()) {System.out.println("Te quedaste sin intentos: retrosede o sal del juego");break;}
				m = filaColumna(a.getPuzzle());
				if(!a.fueraDeLimite(m)) {System.out.println("fuera de los limetes");break;}
				a.movimiento(m);
				undo.push(a.copia());
				if(a.puzzleFinal()) {imprimeArray(a.getPuzzle());System.out.println("Puzzle terminado");v=true;}
				redo.emptyAll();
				break;
				
			case 4: System.out.println("ok");break;
			default: System.out.println("Opción inválida. Por favor, seleccione una opción válida.");break;
			}
			
			
			if(op == 4 || v == true) {break;}
			
		}
		
		return op;	
		
	}
	
	public static byte menu() {
		
		Scanner sc = new Scanner(System.in);
		byte op ;
		for(;;) {
			System.out.println("SELECCIONE UN OPCION");
			System.out.println("1.- Puzzle Por default");
			System.out.println("2.- Definir Puzzle");
			System.out.println("3.- Puzzle Aleatorio");
			System.out.println("4.- No Quiero Jugar");
			op = sc.nextByte();
			
			
			System.out.println();
			if(op==1 || op==2 || op==3 || op ==4) {break;}
			else {System.out.println("opcion no valida selecciona una valida");}
		}return op;
	} 
	
	public static byte filaColumna(byte b[]) {
		byte a;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("ingresa el numero a intercambiar por el cero");
		a = sc.nextByte();
		
		for (byte i = 0; i < 9; i++) {
			if(b[i]==a) {return i;}
		}
		return a;
		
	}
	
	public static void imprimeArray(byte a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" |");
			if(i==2 || i == 5) {System.out.print("\n_________\n");}
		}
		System.out.print("\n");
	}
}
