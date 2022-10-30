package acd.tema1.jaxb.ejercicios;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author amna
 * @version 1.0
 */
@XmlRootElement(name="restaurante")
@XmlType(propOrder = {"nombre","platos"})
public class Restaurante {
	private String nombre;
	private ArrayList<Platos> platos = new ArrayList<Platos>();

	public Restaurante() {}
	/**
	 * 
	 * @param nombre
	 * @param listaPlatos
	 */
	public Restaurante(String nombre, ArrayList<Platos> platos) {
		this.nombre = nombre;
		this.platos = platos;
	}
	@XmlAttribute(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement(name="platos")
	public ArrayList<Platos> getPlatos() {
		return platos;
	}
	public void setPlatos(ArrayList<Platos> platos) {
		this.platos = platos;
	}
	@Override
	public String toString() {
		return "Restaurante [nombre=" + nombre + ", platos=" + platos + "]";
	}
	

}