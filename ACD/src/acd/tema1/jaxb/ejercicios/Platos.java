package acd.tema1.jaxb.ejercicios;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que define las propiedades y constructores de 
 * Platos
 * @author Antonio Miguel Núñez // Alejandro Ruiz Bonillo
 * @version 1.0
 */
@XmlRootElement(name="platos")
public class Platos {
	private ArrayList<Plato> platos = new ArrayList<Plato>();
	            
	public Platos() {}
	/**
	 * Constructor principal
	 * @param platos guarda en un ArrayList todos los platos del XML
	 */
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
	
}