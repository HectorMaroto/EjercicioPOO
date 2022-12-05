package modelo;

public class Editorial {
	
	
	private int id_editorial;
	private String nombre;
	private String nacionalidad;
	
	
	public Editorial() {
		super();
	}


	public Editorial(int id_editorial, String nombre, String nacionalidad) {
		super();
		this.id_editorial = id_editorial;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}


	public int getId_editorial() {
		return id_editorial;
	}


	public void setId_editorial(int id_editorial) {
		this.id_editorial = id_editorial;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public void infoEditorial() {
		System.out.println("--------- Información Editorial ------------");
		System.out.println(" Id: "+this.id_editorial);
		System.out.println(" Nombre: "+this.nombre);
		System.out.println(" Nacionalidad: "+this.nacionalidad);
	}
	
	
}
