package acd.tema1.sax;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import org.xml.sax.SAXException;

public class MainSax {
	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try (InputStream is = xmlInputStream()){
			SAXParser saxParser = factory.newSAXParser();
			//Parsea el XML a objeto
			PrintSaxHandler handler = new PrintSaxHandler();
			saxParser.parse(is, handler);
			//imprime los elementos del xml como objetos
			List<Libro> libro = handler.getLibros();
			libro.forEach(System.out::println);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método estático que devuelve el fichero xml
	 * como un stream
	 * @return ^
	 */
	private static InputStream xmlInputStream() {
		return MainSax.class.getClassLoader().getResourceAsStream("libreria.xml");
	}

}

