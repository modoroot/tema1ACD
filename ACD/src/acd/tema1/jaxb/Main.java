package acd.tema1.jaxb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main {

	public static void main(String[] args) throws JAXBException, IOException {
		File doc = new File("personas.xml");
		leerJAXB(doc);
		//Persona persona=new Persona(4,"Paco",56);
		//anadirPersona(doc,persona);
	}

	public static void leerJAXB(File doc) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(Personas.class);

		Unmarshaller unmarshaller = context.createUnmarshaller();

		Personas personas = (Personas) unmarshaller.unmarshal(doc);

		ArrayList<Persona> listaPersonas = personas.getPersonas();

		for (Persona p : listaPersonas) {
			System.out.println(
					"La persona " + p.getId() + " se llama " + p.getNombre() + " y tiene " + p.getEdad() + " años");
		}

	}

	public static void anadirPersona(File doc, Persona persona) throws JAXBException, IOException {

		JAXBContext context = JAXBContext.newInstance(Personas.class);

		Unmarshaller unmarshaller = context.createUnmarshaller();
		Personas personas = (Personas) unmarshaller.unmarshal(doc);
		ArrayList<Persona> listaPersonas = personas.getPersonas();
		
		listaPersonas.add(persona);

		Marshaller marshaller = context.createMarshaller();
		
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
		
		
		
		marshaller.marshal(personas, new FileWriter("personas.xml",StandardCharsets.UTF_8));

	}

}
