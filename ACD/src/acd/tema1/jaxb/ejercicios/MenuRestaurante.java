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
 * @author amna // alexdev
 * @version 1.0
 */
public class MenuRestaurante {
	// Flujo de entrada de datos por consola
	private static Scanner sc = new Scanner(System.in);
	// objeto de File instanciado que guarda el xml
	private static File doc = new File("platos.xml");

	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException,
			TransformerFactoryConfigurationError, TransformerException, JAXBException {
		int op = 0;
		do {

			// menú
			System.out.println("Selecciona una operación:" + "\n" + "1. Leer documento" + "\n" + "2. Añadir plato"
					+ "\n" + "3. Eliminar plato" + "\n" + "4. Modificar plato " + "\n" + "5. Salir" + "\n");
			op = sc.nextInt();
			switch (op) {
			case 1:
				leerXml();
				break;
			case 2:
				System.out.println("Introduce el ID:");
				int idPlato = sc.nextInt();
				String saltolinea0 = sc.nextLine();
				System.out.println("Introduce el nombre:");
				String nombrePlato = sc.nextLine();
				System.out.println("Introduce el precio:");
				int precioPlato = sc.nextInt();
				String saltolinea1 = sc.nextLine();
				System.out.println("Introduce la descripción del plato:");
				String descripcionPlato = sc.nextLine();
				System.out.println("Introduces las kcal:");
				int kcalPlato = sc.nextInt();


				Plato plato = new Plato(idPlato, nombrePlato, precioPlato, descripcionPlato, kcalPlato);

				try {
					aniadirPlato(doc, plato);
				} catch (IOException e) {
					System.out.println("El plato no se ha podido crear correctamente...");
					e.printStackTrace();
				}
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
	 * Lee todo el XML a partir de los métodos toString generados en sus respectivas
	 * clases
	 * 
	 * @param doc documento xml
	 * @throws JAXBException
	 */
	private static void leerXml() throws JAXBException {
		// Inicializamos la API de JAXB
		JAXBContext context = JAXBContext.newInstance(Platos.class);
		// Deserializamos el XML para que Java pueda leerlo
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Platos platos = (Platos) unmarshaller.unmarshal(doc);
		ArrayList<Plato> listaPlatos = platos.getPlatos();
		for (Plato p : listaPlatos) {
			System.out.println("ID: " + p.getId() + "\n" + "Nombre del plato: " + p.getNombre() + "\n" + "Precio(€): "
					+ p.getPrecio() + " euros" + "\n" + "Descripción: " + p.getDescripcion() + "\n" + "Kilocalorías: "
					+ p.getKilocalorias() + " kcal" +"\n");
		}

	}

	/**
	 * Método que añade un plato según los parámetros pasados por consola
	 * 
	 * @param doc documento xml
	 * @throws JAXBException
	 * @throws IOException
	 */
	private static void aniadirPlato(File doc, Plato plato) throws JAXBException, IOException {
		try {
			JAXBContext context = JAXBContext.newInstance(Platos.class);

			Unmarshaller unmarshaller = context.createUnmarshaller();
			Platos platos = (Platos) unmarshaller.unmarshal(doc);
			ArrayList<Plato> listaPlatos = platos.getPlatos();

			listaPlatos.add(plato);

			Marshaller marshaller = context.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);

			marshaller.marshal(platos, new FileWriter("platos.xml",StandardCharsets.UTF_8));
			marshaller.marshal(platos, System.out);
		} catch (Exception e) {
			System.out.println("El plato no se ha podido añadir...");
			e.printStackTrace();
		}

	}

	/**
	 * Método que borra un plato según el id seleccionado
	 * 
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
		// Introducimos por consola un id. Es String porque usamos el método de String
		// equals(), pero esto no influye en nada a la hora de visualizarlo en el XML,
		// es decir,
		// id va a seguir siendo tipo int
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
		Result out = new StreamResult(doc);
		Source input = new DOMSource(document);
		transformer.transform(input, out);
	}

	private static void modificarPlato() {

	}

}