package acd.tema1.jaxb.ejercicios;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Clase que define las propiedades y constructores de 
 * Plato
 * @author Antonio Miguel Núñez Ariza // Alejandro Ruiz Bonillo
 * @version 1.0
 */
@XmlRootElement(name="plato")
@XmlType(propOrder = {"id","nombre","precio","descripcion","kilocalorias"})
public class Plato {
	private int id;
	private String nombre;
	private int precio;
	private String descripcion;
	private int kilocalorias;

	public Plato() {}
	/**
	 * Constructor principal
	 * @param id int
	 * @param nombre String
	 * @param precio int
	 * @param descripcion String
	 * @param kilocalorias int
	 */
	public Plato(int id, String nombre, int precio, String descripcion, int kilocalorias) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.kilocalorias = kilocalorias;
	}
	@XmlAttribute(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement(name="nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement(name="precio")
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@XmlElement(name="descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@XmlElement(name="kilocalorias")
	public int getKilocalorias() {
		return kilocalorias;
	}

	public void setKilocalorias(int kilocalorias) {
		this.kilocalorias = kilocalorias;
	}
	
}
