package acd.tema1.bytes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class EjercicioTres {

	public static void main(String[] args) {
		EjercicioTres ejercicioTres = new EjercicioTres();
		ejercicioTres.copiarImagen();
		//ejercicioTres.apDos();
	}
	public void copiarImagen() {
		File origen = new File("/home/amna/Escritorio/ejemplo.png");
		File destino = new File("/home/amna/Escritorio/ejemplo_copia.png");

		try {
			InputStream in = new FileInputStream(origen);
			OutputStream out = new FileOutputStream(destino);

			byte[] buf = new byte[1024];
			int len;

			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			in.close();
			out.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	public void apDos() {
		System.out.println("Introduce números enteros hasta que te hartes");
		File f = new File("/home/amna/Escritorio/num.txt");
		int num = 0;
		int pareja = 0;
		Scanner sc = new Scanner(System.in);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			DataOutputStream dos = new DataOutputStream(fos);
			FileInputStream fis=new FileInputStream(f);
			DataInputStream dis=new DataInputStream(fis);
			while(num!=-1) {
				num = sc.nextInt();
				dos.writeInt(num);
				pareja++;
				if(pareja >= 2) {
					dos.writeChar(' ');
				}
			}
			for(;;) {
				System.out.print(dis.readInt());
			}

		} catch(EOFException e) {
			System.out.println("\n"+"Se ha llegado al final del fichero");
		}	
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	public void apTres() {

	}
}

