package acd.tema1.jaxb;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="personas")
public class Personas {
	
	ArrayList<Persona> personas=new ArrayList<Persona>();

	public Personas(ArrayList<Persona> personas) {
		super();
		this.personas = personas;
	}
	
	public Personas() {
		super();
	}

	@XmlElement(name="persona")
	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}
	
	
	

}
