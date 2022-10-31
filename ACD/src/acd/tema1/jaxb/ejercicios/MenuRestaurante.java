package acd.tema1.jaxb.ejercicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Clase principal que incorpora un menú que realiza diferentes operaciones
 * sobre el XML
 * 
 * @author amna
 * @version 1.0
 */
public class MenuRestaurante {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException,
			TransformerFactoryConfigurationError, TransformerException, JAXBException {
		int op = 0;
		do {

			// objeto instanciado que guarda el xml
			File doc = new File("platos.xml");
			// menú
			System.out.println("Selecciona una operación:" + "\n" + "1. Leer documento" + "\n" + "2. Añadir plato"
					+ "\n" + "3. Eliminar plato" + "\n" + "4. Modificar plato " + "\n" + "5. Salir" + "\n");
			op = sc.nextInt();
			switch (op) {
			case 1:
				leerDoc(doc);
				break;
			case 2:
				aniadirPlato(doc);
				break;
			case 3:
				borrarPlato();
				break;
			case 4:
				modificarPlato();
				break;
			case 5:
				System.exit(0);
				break;
			}
		} while (op != 5);
	}

	/**
	 * Lee todo el documento a partir de los métodos toString generados en sus
	 * respectivas clases
	 * 
	 * @param doc
	 * @throws JAXBException
	 */
	private static void leerDoc(File doc) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Platos.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Platos platos = (Platos) unmarshaller.unmarshal(doc);
		// Con un simple Syso lee todo el XML debido al método toString
		System.out.println(platos);
	}

	/**
	 * Método que añade un plato según los parámetros pasados por consola
	 * 
	 * @param doc
	 * @param plato
	 * @throws JAXBException
	 * @throws IOException
	 */
	private static void aniadirPlato(File doc) throws JAXBException, IOException {
		System.out.println("Introduce los datos del nuevo plato (id, nombre, precio, descripcion, kcal:");
		Plato plato = new Plato(sc.nextInt(),sc.next(),sc.nextInt(),sc.next(),sc.nextInt());
		JAXBContext context = JAXBContext.newInstance(Platos.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Platos platos = (Platos) unmarshaller.unmarshal(doc);
		ArrayList<Plato> listaPlatos = platos.getPlatos();
		// añade al ArrayList el plato
		listaPlatos.add(plato);
		Marshaller marshaller = context.createMarshaller();
		// parámetros de formateo adicionales
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
		// actualiza el xml con la entrada añadida
		marshaller.marshal(platos, new FileWriter("platos.xml", StandardCharsets.UTF_8));
		// lo muestra por consola
		marshaller.marshal(platos, System.out);

	}

	/**
	 * Método que borra un plato según el id seleccionado
	 * 
	 * @param doc
	 * @param id
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 */
	private static void borrarPlato() throws SAXException, IOException, ParserConfigurationException,
			TransformerFactoryConfigurationError, TransformerException {
		String id = "";
		System.out.println("Introduce el id: ");
		id = sc.next();
		// carga el XML
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("platos.xml"));
		// busca y elimina el elemento seleccionado a partir del id pasado
		NodeList items = document.getElementsByTagName("plato");
		for (int i = 0; i < items.getLength(); i++) {
			Element element = (Element) items.item(i);
			// busca el elemento con dicho id
			if (element.getAttribute("id").equalsIgnoreCase(id)) {
				// borra el elemento
				element.getParentNode().removeChild(element);
			}
		}
		// Sobreescribe el xml con el resultado habiendo borrado la entrada con el
		// id anterior
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Result out = new StreamResult(new File("platos.xml"));
		Source input = new DOMSource(document);
		transformer.transform(input, out);
	}
	private static void modificarPlato() {
		
	}

}