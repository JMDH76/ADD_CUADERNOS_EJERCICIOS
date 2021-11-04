package es.florida.seccion03;

public class Zapato {
	
	String id, tipo, marca, modelo, color, talla, precio;

	Zapato() {
		
	}

	Zapato( String id, String tipo, String marca, String modelo, String color, String talla, String precio) {

		this.id = id;
		this.tipo = tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.talla = talla;
		this.precio = precio;
	}
	
	//ToDO geter y seter id
	public String getId () {
		return id;
		}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTipo () {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}
	
	public void serModelo (String modelo) {
		this.modelo = modelo;
	}
	
	public String getColor () {
		return color;
	}
	
	public void setColor (String color) {
		this.color = color;
	}
	
	public String getTalla() {
		return talla;
	}
	
	public void setTalla (String talla){
		this.talla = talla;
	}
	
	public String getPrecio() {
		return precio;
	}

	public void  setPrecio(String precio) {
		this.precio = precio;
	}
	
	public String getToString() {
		return  "\n	ID:	" + id + "\n	Tipo:	" + tipo + "\n	Marca:	" + marca  + "\n	Modelo:	" + modelo + 
			"\n	Color:	" + color +"\n	Talla:	" + talla +"\n	Precio:	" + precio;
	}
}	



