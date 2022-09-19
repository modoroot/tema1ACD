package acd.tema1.clasefile;

import java.io.File;
import java.io.FileFilter;

/**
 * Ejercicios utilizando la clase File y FileFilter
 * @author amna
 * @version 1.0
 */

public class EjercicioUno {
	public static void main(String[] args) {
		EjercicioUno ejercicioUno = new EjercicioUno();
		// ejercicioUno.crearArbolDirectoriosFicheros();
		ejercicioUno.listarArbolDirectorios(new File("/home/amna/Escritorio/d/"),"\t");
		//		 ejercicioUno.listarArchivos(new File("C:\\Users\\Usuario\\Desktop\\d\\d1"),
		//		 ".xml");
		//ejercicioUno.eliminarFicherosTxt(new File("C:\\Users\\Usuario\\Desktop\\d\\d1"));

	}
	/**
	 * Método que crea un árbol de directorios y ficheros
	 */
	public void crearArbolDirectoriosFicheros(){
		try {
			String path = "/home/amna/Escritorio/";
			File f = new File(path.concat("d/"));
			File f2 = new File(f, "d1/");
			File f3 = new File(f, "d2/");
			File f4 = new File(f, "d3/");
			File f5 = new File(f, "d1/f11.txt");
			File f6 = new File(f, "d1/f12.txt");
			File f7 = new File(f, "d2/d21/");
			File f8 = new File(f, "d2/f21.txt");
			File f9 = new File(f, "d2/d22/");
			File f10 = new File(f, "d2/d22/f222.txt");
			File f11 = new File(f, "d3/d31");
			f.mkdir();
			f2.mkdir();
			f3.mkdir();
			f4.mkdir();
			f5.createNewFile();
			f6.createNewFile();
			f7.mkdir();
			f8.createNewFile();
			f9.mkdir();
			f10.createNewFile();
			f11.mkdir();
		} catch (Exception e) {
			e.printStackTrace();		
		}

	}
	/**
	 * Método para recorrer de forma recursiva un árbol de directorios
	 * 
	 * @param dir parámetro que guarda la ruta del directorio raíz
	 */
	public void listarArbolDirectorios(File dir, String tab) {
		File listFiles[] = dir.listFiles();
		for (int i = 0; i < listFiles.length; i++) {
			System.out.println(tab+listFiles[i]);
			if (listFiles[i].isDirectory()) {
				listarArbolDirectorios(listFiles[i], tab+tab);
			}

		}
	}

	/**
	 * Método que lista los ficheros que acaben por una extensión que se da por
	 * entrada
	 * 
	 * @param dir directorio donde están los ficheros
	 * @param ext parámetro de entrada que determina la extensión de los archivos
	 *            que se mostrarán
	 */
	public void listarArchivos(File dir, String ext) {
		FileFilter logFilefilter = new FileFilter() {
			public boolean accept(File dir) {
				if (dir.getName().endsWith(".xml")) {
					return true;
				}
				return false;
			}
		};
		File[] files = dir.listFiles(logFilefilter);

		for (File f : files) {
			System.out.println(f.getName());
		}
	}

	/**
	 * Método que eliminará todos los archivos con extensión .txt dentro de un solo
	 * directorio
	 * 
	 * @param dir parámetro de entrada que define el directorio
	 */
	public void eliminarFicherosTxt(File dir) {
		FileFilter logFilefilter = new FileFilter() {
			public boolean accept(File dir) {
				if (dir.getName().endsWith(".txt")) {
					return true;
				}
				return false;
			}
		};
		//Borra los ficheros que acaban en .txt
		File[] files = dir.listFiles(logFilefilter);
		for (File f : files) {
			f.delete();
		}
		//Esto mostrará los ficheros restantes
		String[] list = dir.list();
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}


}

