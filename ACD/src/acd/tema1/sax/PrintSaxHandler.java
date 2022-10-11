package acd.tema1.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class PrintSaxHandler extends DefaultHandler{
//	private StringBuilder currentValue = new StringBuilder();
	List<Libro> libro;
	Libro librosActuales;

	public List<Libro> getLibros(){
		return libro;
	}
	@Override
	public void startDocument() {
		libro = new ArrayList<>();
	}

	@Override
	public void startElement(String uri, String localName,
			String qName, Attributes atts) {
		//reinicia el valor de la etiqueta
		//currentValue.setLength(0);

		if(qName.equals("libro")) {
			librosActuales = new Libro();
			String isbn = atts.getValue("isbn");
			String estado = atts.getValue("estado");
			librosActuales.setIsbn(isbn);
			librosActuales.setEstado(estado);

		}
		

	}
	@Override
	public void endElement(String uri,
			String localName,
			String qName) {
		if(localName.equals("titulo")) {
			librosActuales.setTitulo(librosActuales.toString());
		}
		if(localName.equals("autor")) {
			librosActuales.setAutor(librosActuales.toString());
		}
		//Añade el libro
		if(qName.equals("libro")) {
			libro.add(librosActuales);
		}

	}
//	public void characters(char ch[], int start, int length) {
//		currentValue.append(ch, start, length);
//
//	}
}
