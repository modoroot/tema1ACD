package acd.tema1.bytes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bytes {
	public static void main(String[] args) {
		escribirTiposPrimitivos();
		leerTiposPrimitivos();
	}

	public static void leer() {
		File f=new File("/home/usuario/Descargas/Apuntes ADA 1.pdf");

		try {
			FileInputStream fis=new FileInputStream(f);

			int letra = fis.read();
			System.out.print((char)letra);

			while(letra!=-1) {
				letra = fis.read();
				System.out.print((char)letra);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void escribirTiposPrimitivos() {
		File f = new File("datos.dat");

		try {
			FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);

			dos.writeInt(3);
			dos.writeChar('b');
			dos.writeDouble(12);

			dos.writeInt(3);
			dos.writeChar('b');
			dos.writeDouble(12);

			dos.writeInt(3);
			dos.writeChar('b');
			dos.writeDouble(12);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void leerTiposPrimitivos() {
		File f=new File("datos.dat");

		try {
			FileInputStream fis=new FileInputStream(f);
			DataInputStream dis=new DataInputStream(fis);

			for(;;) {
				System.out.println(dis.readInt());
				System.out.println(dis.readChar());
				System.out.println(dis.readDouble());
			}



		} catch(EOFException e) {
			System.out.println("Se ha llegado al final del fichero");
		}	
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
