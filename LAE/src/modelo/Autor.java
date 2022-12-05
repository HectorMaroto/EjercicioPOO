package modelo;

public class Autor {
	
	private int id_autor;
	private String nombre_autor;
	private String apellidos_autor;
	private String nacionalidad;
	private String fecha_autor;
	
	public Autor() {
		super();
	}
	public Autor(int id_autor,String nombre_autor,String apellidos_autor,String nacionalidad,String fecha_autor) {
		super();
		this.id_autor = id_autor;
		this.nombre_autor = nombre_autor;
		this.apellidos_autor = apellidos_autor;
		this.nacionalidad = nacionalidad;
		this.fecha_autor = fecha_autor;
	}
	public int getId_autor() {
		return id_autor;
	}
	public String getNombre_autor() {
		return nombre_autor;
	}
	public String getApellidos_autor() {
		return apellidos_autor;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public String getFecha_autor() {
		return fecha_autor;
	}
	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}
	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}
	public void setApellidos_autor(String apellidos_autor) {
		this.apellidos_autor = apellidos_autor;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public void setFecha_autor(String fecha_autor) {
		this.fecha_autor = fecha_autor;
	}
	
	
	public void infoAutor() {
		System.out.println("---------------Informacion del autor--------------");
		System.out.println("Id: "+this.id_autor);
		System.out.println("Nombre: "+this.nombre_autor);
		System.out.println("Apellidos: "+this.apellidos_autor);
		System.out.println("Nacionalidad: "+this.nacionalidad);
		System.out.println("Fecha: "+this.fecha_autor);
	}

}
