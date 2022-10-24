package acd.tema1.jaxb.ejercicios;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author amna
 * @version 1.0
 */
@XmlRootElement(name="plato")
@XmlType(propOrder = {"id","nombre","precio","descripcion","calorias"})
public class Plato {
	private int id;
	private String nombre;
	private float precio;
	private String descripcion;
	private int calorias;

	public Plato() {}
	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param precio
	 * @param descripcion
	 * @param calorias
	 */
	public Plato(int id, String nombre, float precio, String descripcion, int calorias) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.calorias = calorias;
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
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	@XmlElement(name="descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@XmlElement(name="calorias")
	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	@Override
	public String toString() {
		return "Plato [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", calorias=" + calorias + "]";
	}
	
}
