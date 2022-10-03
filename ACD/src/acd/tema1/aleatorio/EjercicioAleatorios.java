package acd.tema1.aleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EjercicioAleatorios {

	public static void main(String[] args) {
		EjercicioAleatorios ejercicioAleatorios = new EjercicioAleatorios();
		ejercicioAleatorios.apUno();
	}
	public void apUno() {
		try {
			File file = new File("/home/amna/Escritorio/fichero.txt");
			StringBuffer sb = new StringBuffer();
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			while(raf.getFilePointer()<raf.length()) {
				sb.append(raf.readLine()+"\n");
			}
			String txt = sb.toString();
			System.out.println(txt.replace(" ", "").toUpperCase());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
