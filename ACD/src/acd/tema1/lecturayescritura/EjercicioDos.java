package acd.tema1.lecturayescritura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase donde se utilizan clases relativas a los flujos en ficheros
 * 
 * @author amna
 * @version 1.0
 */
public class EjercicioDos {
	final static String path = "C:\\Users\\Usuario\\Desktop\\hola_mundo.txt";

	public static void main(String[] args) {
		EjercicioDos ejercicioDos = new EjercicioDos();
		// ejercicioDos.escribirHolaMundo();
		// ejercicioDos.escribirHolaMundoYaCreado();
		// ejercicioDos.leerFicheroVariasLineas(new File(path));
		// ejercicioDos.contarPalabrasFichero(new File(path));
		ejercicioDos.crearNuevoFicheroCopiado(new File(path));
	}
	/**
	 * Método que escribe 'Hola Mundo' en un fichero
	 */
	public void escribirHolaMundo() {
		try {
			FileWriter fw = new FileWriter(path);
			fw.write("Hola mundo");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Método que escribe otro texto en el mismo fichero sin
	 * sobreescribir
	 */
	public void escribirHolaMundoYaCreado() {
		try {
			FileWriter fw = new FileWriter(path, true);
			fw.write("\nHola mundo 2");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Método que lee un fichero dado por parámetro de entrada
	 * @param f
	 */
	public void leerFichero(File f) {
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Método que lee un fichero línea por línea dado por entrada
	 * @param f
	 */
	public void leerFicheroVariasLineas(File f) {
		try {
			int n = 1;
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				System.out.println(n + " " + linea);
				n++;
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Método que cuenta las palabras de un fichero dado por entrada
	 * @param f
	 */
	public void contarPalabrasFichero(File f) {
		int cont = 0;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			while (linea != null) {
				System.out.println(linea);
				String[] palabras = linea.split(" ");
				cont += palabras.length;
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\nPalabras contadas: " + cont);
	}
	/**
	 * Método que crea un nuevo fichero, el cual copia el contenido
	 * del fichero tratado en los métodos anteriores, y transforma
	 * todas las minúsculas en mayúsculas
	 * @param f
	 */
	public void crearNuevoFicheroCopiado(File f) {
		final String rutaFicheroNuevo = "C:\\Users\\Usuario\\Desktop\\copia.txt";
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(rutaFicheroNuevo);
			String linea = br.readLine();
			while (linea != null) {
				String elimEspaciosMayusculas = linea.replace(" ", "").toUpperCase();
				fw.write(elimEspaciosMayusculas+"\n");
				//System.out.println(elimEspacios);
				linea = br.readLine();
				
			}
			fw.close();
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}