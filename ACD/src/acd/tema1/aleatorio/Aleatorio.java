package acd.tema1.aleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Aleatorio {

	public static void main(String[] args) {
		//			escribirCincoNumeros();
		leerYCambiarPorUno();
		leer();
	}
	public static void escribirCincoNumeros() {
		try {
			RandomAccessFile raf = new RandomAccessFile("datos.dat", "rw");
			raf.writeInt(1);
			raf.writeInt(2);
			raf.writeInt(3);
			raf.writeInt(4);
			raf.writeInt(5);
			System.out.println(raf.readInt());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void leerYCambiarPorUno() {
		try {
			RandomAccessFile raf = new RandomAccessFile("datos.dat","rw");
			int n = 0;
			while(true) {
				n=raf.readInt();
				System.out.println(n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void leer() {

	}
}
