package acd.tema1.jaxb.ejercicios;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author amna
 * @version 1.0
 */
@XmlRootElement(name="restaurante")
@XmlType(propOrder = {"nombre","direccion","platos"})
public class Restaurante {
	private String nombre;
	private String direccion;
	private ArrayList<Platos> listaPlatos = new ArrayList<Platos>();

	public Restaurante() {}
	/**
	 * 
	 * @param nombre
	 * @param direccion
	 * @param listaPlatos
	 */
	public Restaurante(String nombre, String direccion, ArrayList<Platos> listaPlatos) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.listaPlatos = listaPlatos;
	}

	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement(name="direccion")
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@XmlElement(name="platos")
	public ArrayList<Platos> getListaPlatos(){
		return listaPlatos;
	}

	public void setListaPlatos(ArrayList<Platos> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}

}
