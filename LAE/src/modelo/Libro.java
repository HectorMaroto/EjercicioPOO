package modelo;

public class Libro {

	private int id_libro;
	private int id_editorial;
	private int id_autor;
	private String titulo_libro;
	private String isbn_libro;
	private int paginas_libro;
	
	
	public Libro() {
		super();
	}


	public Libro(int id_libro, int id_editorial, int id_autor, String titulo_libro, String isbn_libro,
			int paginas_libro) {
		super();
		this.id_libro = id_libro;
		this.id_editorial = id_editorial;
		this.id_autor = id_autor;
		this.titulo_libro = titulo_libro;
		this.isbn_libro = isbn_libro;
		this.paginas_libro = paginas_libro;
	}


	public int getId_libro() {
		return id_libro;
	}


	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}


	public int getId_editorial() {
		return id_editorial;
	}


	public void setId_editorial(int id_editorial) {
		this.id_editorial = id_editorial;
	}


	public int getId_autor() {
		return id_autor;
	}


	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}


	public String getTitulo_libro() {
		return titulo_libro;
	}


	public void setTitulo_libro(String titulo_libro) {
		this.titulo_libro = titulo_libro;
	}


	public String getIsbn_libro() {
		return isbn_libro;
	}


	public void setIsbn_libro(String isbn_libro) {
		this.isbn_libro = isbn_libro;
	}


	public int getPaginas_libro() {
		return paginas_libro;
	}


	public void setPaginas_libro(int paginas_libro) {
		this.paginas_libro = paginas_libro;
	}
	
	public void infoLibro() {
		System.out.println("------------ Información del Libro ----------------");
		System.out.println(" Id libro: "+this.id_libro);
		System.out.println(" Id editorial: "+this.id_editorial);
		System.out.println(" Id autor: "+this.id_autor);
		System.out.println(" Titulo: "+this.titulo_libro);
		System.out.println(" ISBN: "+this.isbn_libro);
		System.out.println(" Páginas: "+this.paginas_libro);
	}
	
	
	
}
