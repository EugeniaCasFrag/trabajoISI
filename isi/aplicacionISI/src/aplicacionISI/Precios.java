package aplicacionISI;


public class Precios{
	String precio;
	String url;
	String nombre;
	
	
	public void setURL(String n) {
		this.url = n;
	}
	
	public void setPrecio(String p) {
		this.precio = p;
	}
	
	public void setNombre(String p) {
		this.nombre = p;
	}
	
	public String getURL() {
		return(this.url);
	}
	
	public String getPrecio() {
		return(this.precio);
	}
	
	
	
	public String getNombre() {
		return(this.nombre);
	}
	
}