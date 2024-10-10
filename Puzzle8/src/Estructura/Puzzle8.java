package Estructura;

import java.util.Random;

public class Puzzle8 {

	private byte puzzle[];
	private byte posicion;
	
	public Puzzle8() {
		this.puzzle = new byte[9];
		for (byte i = 0; i <this.puzzle.length-1; i++) {
			this.puzzle[i]=(byte)(i+1);
		}
		this.puzzle[8]=0;
		
	}
	
	public Puzzle8(byte a[]) {
		this.puzzle = new byte[9];
		for (int i = 0; i < a.length; i++) {
			this.puzzle[i]=a[i];
		}
		}
	
	public Puzzle8(String aleatorio) {
		this.puzzle =generarPuzzle();
	}
		
	
	
	
	
	
	public boolean puzzleFinal() {
		byte b[]= {1,2,3,8,0,4,7,6,5};
		for (int i = 0; i < b.length; i++) {
			if(this.puzzle[i]!=b[i]) {return false;}
		}
		return true;
	}
	
	public byte[] generarPuzzle() {
		Random rnd = new Random();
		byte a [] = {1,2,3,4,5,6,7,8,0};
		byte b ;
		byte c;
		for (int i = 0; i < a.length; i++) {
		
		b = (byte)rnd.nextInt(9);	
		c = a[i];
		a[i] = a[b];
		a[b] = c;
		
					}
		return a;
	}
	
	
	public void posicion2() {
		
		for (byte i = 0; i < puzzle.length; i++) {
			if(puzzle[i]==0) {this.posicion = i;}
		}
		
		
	}
	
	
	
	
	public byte[] getPuzzle() {
		return puzzle;
	}

	public void movimiento( byte m ) {
			this.puzzle[this.posicion]=this.puzzle[m];
			this.puzzle[m]=0;
			posicion = m;
			
		
	}
	
	public boolean fueraDeLimite(byte m) {
		
		if(m<9 && m>-1) {
			if(m==this.posicion-3 || m==this.posicion-1 || m==this.posicion+1 || m==this.posicion+3) {	
				return true;
			}}
		return false;
	}


	public byte getPosicion() {
		return posicion;
	}
	
	public Puzzle8 copia() {
	    Puzzle8 copia = new Puzzle8(); 
	    copia.puzzle = this.puzzle.clone(); 
	    copia.posicion = this.posicion; 
	    return copia;
	}
	
	}
	
	
	
	

