package acd.tema1.jaxb.ejercicios;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author amna
 * @version 1.0
 */
@XmlRootElement(name="platos")
public class Platos {
	private ArrayList<Plato> platos = new ArrayList<Plato>();
	            
	public Platos() {}
	public Platos(ArrayList<Plato> platos) {
		this.platos = platos;
	}
	@XmlElement(name="plato")
	public ArrayList<Plato> getPlatos() {
		return platos;
	}
	public void setListaPlato(ArrayList<Plato> plato) {
		this.platos = plato;
	}
	@Override
	public String toString() {
		return ""+platos;
	}

	
	
}