package acd.tema1.lecturayescritura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase donde se utilizan clases relativas a los flujos
 * @author amna
 * @version 1.0
 */
public class EjercicioDos {

	public static void main(String[] args) {
		EjercicioDos ejercicioDos = new EjercicioDos();
		//ejercicioDos.escribirHolaMundo();
		//ejercicioDos.escribirHolaMundoYaCreado();
		//ejercicioDos.leerFicheroVariasLineas(new File("/home/amna/Escritorio/hola_mundo.txt"));
	}

	public void escribirHolaMundo() {
		try {
			FileWriter fw = new FileWriter("/home/amna/Escritorio/hola_mundo.txt");
			fw.write("Hola mundo");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void escribirHolaMundoYaCreado() {
		try {
			FileWriter fw = new FileWriter("/home/amna/Escritorio/hola_mundo.txt", true);
			fw.write("\nHola mundo 2");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void leerFichero(File f) {
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea!=null) {
				System.out.println(linea);
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void leerFicheroVariasLineas(File f) {
		try {
			int n = 1;
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while(linea!=null) {
				System.out.println(n+" "+linea);
				n++;
				linea = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void contarPalabrasFichero(File f) {

	}
}
