package aplicacionISI;

import java.util.ArrayList;

public class Juego{
	String nombre;
	String plataforma;
	String edicion;
	ArrayList<Precios> money = new ArrayList();
	
	public void setNombre(String n) {
		this.nombre = n;
	}
	
	public void setPlataforma(String p) {
		this.plataforma = p;
	}
	
	public void setEdicion(String p) {
		this.edicion = p;
	}
	
	public void setMoney(ArrayList<Precios>p) {
		this.money = p;
	}
	
	public String getNombre() {
		return(this.nombre);
	}
	
	public String getPlataforma() {
		return(this.plataforma);
	}
	
	public String getEdicion() {
		return(this.edicion);
	}
	
	public ArrayList<Precios> getMoney() {
		return(this.money);
	}

	
}