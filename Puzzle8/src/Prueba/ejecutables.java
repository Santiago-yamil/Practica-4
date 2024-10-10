package Prueba;

import java.util.Scanner;

import Estructura.Puzzle8;
import Pilas.ExcepcionDePilaLlena;
import Pilas.ExcepcionDePilaVacia;
import Pilas.PilaEstatica;

public class ejecutables {
	

		public static void main(String[] args) throws ExcepcionDePilaLlena, ExcepcionDePilaVacia {
			Operaciones obj = new Operaciones();
			byte op =obj.menu();
			if(op!=4) {
				
				op = obj.juego(obj.objeto(op));
				if(op==3) {System.out.println("FELICIDADES");}
				
			}
			System.out.println("Fin");
		}
		
	/*	
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
			PilaEstatica<Puzzle8> pila2 = new PilaEstatica<>(50);
			PilaEstatica<Puzzle8> pila1 = new PilaEstatica<>(51);
			
			Puzzle8 a = b;
			
			Scanner sc = new Scanner(System.in);
			byte op,m ; boolean v= false;
			a.posicion2();
			pila1.push(a.copia());
			System.out.println("EL array inicial es:");
			
			
			for(;;) { 
				System.out.println("Tienes "+(51-pila1.size())+" intentos");
				imprimeArray(a.getPuzzle());
				
				System.out.println("SELECCIONE UN OPCION");
				System.out.println("1.- Redo (adelante)");
				System.out.println("2.- Undo (Atras)"); 
				System.out.println("3.- Movimiento ");
				System.out.println("4.- Ya No Quiero Jugar");
				op = sc.nextByte();
				
				switch(op) {
				case 1:
					if(pila2.isEmpty()) {System.out.println("No hay movimientos posteriores");break;}
					a = pila2.pop().copia();
					pila1.push(a.copia());
					break;
					
				case 2:
					if(pila1.size()==1) {System.out.println("No hay movimientos anteriores");break;}
					pila2.push(pila1.pop().copia()); a= pila1.top().copia();
					break;
					
				
				case 3:
					if(pila1.isFull()) {System.out.println("Te quedaste sin intentos");break;}
					m = filaColumna(a.getPuzzle());
					if(!a.fueraDeLimite(m)) {System.out.println("fuera de los limetes");break;}
					a.movimiento(m);
					pila1.push(a.copia());
					if(a.puzzleFinal()) {System.out.println("Puzzle terminado");v=true;}
					pila2.emptyAll();
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
			System.out.println("ingresa el numero a mover");
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
		}*/
		
	

}
