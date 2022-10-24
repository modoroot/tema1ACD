package acd.tema1.jaxb.ejercicios;

import java.util.ArrayList;

/**
 * 
 * @author amna
 * @version 1.0
 */
public class Platos {
	private ArrayList<Plato> listaPlato = new ArrayList<Plato>();
	            
	public Platos() {}
	public Platos(ArrayList<Plato> listaPlato) {
		this.listaPlato = listaPlato;
	}
	
	public ArrayList<Plato> getListaPlato() {
		return listaPlato;
	}
	public void setListaPlato(ArrayList<Plato> listaPlato) {
		this.listaPlato = listaPlato;
	}
	
}
