package acd.tema1.jaxb.ejercicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class MenuRestaurante {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			int op = 0;
			
			File doc = new File("restaurante.xml");
			System.out.println("Selecciona una operación:" + "\n" + "1. Leer documento" + "\n" + "2. Añadir plato"
					+ "\n" + "3. Eliminar plato" + "\n" + "4. Modificar plato " + "\n" + "Otra tecla para salir"
					+ "\n");
			op = sc.nextInt();
			switch (op) {
			case 1:
				leerDoc(doc);
				break;
			case 2:
				aniadirPlato(doc);
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.exit(0);
				break;
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	private static void leerDoc(File doc) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Restaurante.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Restaurante restaurante = (Restaurante) unmarshaller.unmarshal(doc);
		System.out.println(restaurante);
	}
	

	private static void aniadirPlato(File doc) {
//		try {
//			System.out.println("Introduce los datos del plato (id, nombre, precio, descripcion, kcal:"+"\n");
//			//Plato plato = new Plato(sc.nextInt(),sc.nextLine(),sc.nextInt(),sc.nextLine(),sc.nextInt());
//			Platos platos = new Platos();
//			platos.setListaPlato(new ArrayList<Plato>());
//		} catch (JAXBException | IOException e) {
//			e.printStackTrace();
//		}
		
	}
//	public static void anadirPersona(File doc, Persona persona) throws JAXBException, IOException {
//
//		JAXBContext context = JAXBContext.newInstance(Personas.class);
//
//		Unmarshaller unmarshaller = context.createUnmarshaller();
//		Personas personas = (Personas) unmarshaller.unmarshal(doc);
//		ArrayList<Persona> listaPersonas = personas.getPersonas();
//		
//		listaPersonas.add(persona);
//
//		Marshaller marshaller = context.createMarshaller();
//		
//		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
//		
//		
//		
//		marshaller.marshal(personas, new FileWriter("personas.xml",StandardCharsets.UTF_8));
//
//	}

}