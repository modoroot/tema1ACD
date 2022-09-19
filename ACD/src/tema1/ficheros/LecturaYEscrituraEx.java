package tema1.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LecturaYEscrituraEx {

	public static void main(String[] args) {
		leerConBuffer(new File("/home/amna/Escritorio/prueba.txt"));

	}
	static void escribir() {
		try {
			FileWriter fw = new FileWriter("/home/amna/Escritorio/prueba.txt", true);
			fw.write("\nhola pitu2");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void escribirLineas() {
		try {
			FileWriter fw = new FileWriter("/home/amna/Escritorio/prueba.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("hola mundo 1");
			pw.println("hola mundo 2");
			pw.println("hola mundo 3");
			fw.write("\nhola pitu2");
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void leer(File f) {
		try {
			FileReader fr = new FileReader(f);
			int caracter = fr.read();
			while(caracter!=-1) {
				System.out.print((char)caracter);
				caracter = fr.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void leerConBuffer(File f) {
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
}
