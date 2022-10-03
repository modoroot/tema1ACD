package acd.tema1.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Dom {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {

		Document doc = docXMLaDOM("personas.xml");

		// buscarC(doc);

		leer(doc);

	}

	public static Document docXMLaDOM(String CaminoAArchivoXml)
			throws SAXException, IOException, ParserConfigurationException {
		// 1º Creamos una nueva instancia de una fabrica de constructores de documentos.
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 2º A partir de la instancia anterior, fabricamos un constructor de
		// documentos, que procesará el XML.
		DocumentBuilder db = dbf.newDocumentBuilder();
		// 3º Procesamos el documento (almacenado en un archivo) y lo convertimos en un
		// árbol DOM.
		Document doc = db.parse(CaminoAArchivoXml);
		return doc;
	}

	public static void domAdocXML(String CaminoAlArchivoXML, Document doc)
			throws TransformerFactoryConfigurationError, TransformerException {
		// 1o Creamos una instancia de la clase File para acceder al archivo donde
		// guardaremos el
		// XML.
		File f = new File(CaminoAlArchivoXML);
		// 2o Creamos una nueva instancia del transformador a través de la fábrica de
		// transformadores.
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		// 3o Establecemos algunas opciones de salida, como por ejemplo, la codificación
		// de salida.
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		// 4o Creamos el StreamResult, intermediaria entre el transformador y el archivo
		// de destino.
		StreamResult result = new StreamResult(f);
		// 5o Creamos el DOMSource, intermediaria entre el transformador y el árbol DOM.
		DOMSource source = new DOMSource(doc);
		// 6o Realizamos la transformación.
		transformer.transform(source, result);
	}

	public static void buscarC(Document doc) {
		Element raiz = doc.getDocumentElement();
		NodeList listaNombres = raiz.getElementsByTagName("nombre");
		for (int i = 0; i < listaNombres.getLength(); i++) {
			Element nombre = (Element) listaNombres.item(i);
			System.out.println(nombre.getTextContent());
		}
	}

	public static void leer(Document doc) {

		Element raiz = doc.getDocumentElement();

		System.out.print(raiz.getTagName());

		NodeList hijosRaiz = raiz.getChildNodes();

		for (int i = 0; i < hijosRaiz.getLength(); i++) {
			Node n = hijosRaiz.item(i);

			switch (n.getNodeType()) {
			case Node.ELEMENT_NODE:
				Element e = (Element) n;
				System.out.print(e.getTagName() + " id=" + e.getAttribute("id"));

				NodeList hijos2 = e.getChildNodes();

				for (int j = 0; j < hijos2.getLength(); j++) {
					Node n2 = hijos2.item(j);

					switch (n2.getNodeType()) {
					case Node.ELEMENT_NODE:
						Element e2 = (Element) n2;
						System.out.print(e2.getTagName() + ": " + e2.getTextContent());
						break;
					case Node.TEXT_NODE:
						Text t2 = (Text) n2;
						System.out.print(t2.getWholeText());
						break;
					}

				}

				break;

			case Node.TEXT_NODE:
				Text t = (Text) n;
				System.out.print(t.getWholeText());
				break;
			}

		}

	}

}
