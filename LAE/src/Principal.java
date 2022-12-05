import java.util.Scanner;

import modelo.Autor;
import modelo.Editorial;
import modelo.Libro;

public class Principal {
	
	public static Scanner lector = new Scanner(System.in);
	
	
	public static void limpiar_pantalla() {
		for (int i=0;i<200;i++) {
			System.out.println("");
		}
	}

	public static int menuprincipal() {
		int op=0;
		limpiar_pantalla();
		System.out.println("--------- Menu Principal Lae -----------");
		System.out.println("-  1.- Libro.                          -");
		System.out.println("-  2.- Autor.                          -");
		System.out.println("-  3.- Editorial.                      -");
		System.out.println("-  4.- Salir.                          -");
		System.out.println("----------------------------------------");
		System.out.println("Dame una opción: ");
		op = lector.nextInt();
		//Como leo algo distinto a string limpio buffer
		lector.nextLine();
		return op;
	}
	
	public static void error(int numero_error) {
		
		switch(numero_error) {
			case 1:{
				System.out.println("Opción no valida.");
				System.out.println("Por favor, escoge una opcion de las validas");
				System.out.println("Pulsa una tecla para continuar .....");
				lector.nextLine(); //No limpio buffer leo tecla.
				break;
			}
			case 2:{
				System.out.println("Usuario, para trabajar con los autores, antes tienes");
				System.out.println("que insertar autores pasando por la opcion 1 del Menu de Autor");
				System.out.println("Pulsa una tecla para continuar ....");
				lector.nextLine(); // No limpio buffer.
			}
			case 3:{
				System.out.println("Usuario, no hay más espacio en el array para almacenar autores");
				System.out.println("Por favor, elimina uno o varios autores para poder insertarlos");
				System.out.println("Pulsa una tecla para continuar ....");
				lector.nextLine(); // No limpio buffer.
			}
			case 4:{
				System.out.println("Usuario, el id que has proporcionado no se encuentra insertado");
				System.out.println("en la tabla de autores, porfavor ingresa un id correcto!!!");
				System.out.println("Pulsa una tecla para continuar ....");
				lector.nextLine(); // No limpio buffer.
			}
		}
	}
	
	public static int mostrarmenuAutor() {
		int op;
		
		limpiar_pantalla();
		System.out.println("--------- Menu de Autor ---------");
		System.out.println("- 1. Insertar Autor.            -");//X
		System.out.println("- 2. Consultar Autores.         -");//X
		System.out.println("- 3. Modificar Autor.           -");//X
		System.out.println("- 4. Eliminar Autor.            -");
		System.out.println("- 5. Salir.                     -");
		System.out.println("---------------------------------");
		System.out.println("Dame una opcion: ");
		op = lector.nextInt();
		// Como leo distinto de String limpio buffer.
		lector.nextLine();
		return op;
	}
	
	public static int insertar_autor(Autor[] p,int i) {
		
		int id_autor;
		String nombre_autor;
		String apellidos_autor;
		String nacionalidad_autor;
		String fecha_autor;
		
		limpiar_pantalla();
		System.out.println("Para dar de alta a un nuevo autor, por favor, rellena los siguientes campos");
		System.out.println("Id Autor: ");
		id_autor=lector.nextInt();
		//Limpiamos buffer
		lector.nextLine();
		// Justo en este sitio ya tenemos la id del autor que quiere insertar
		// deberia de recorrer el array de los autores buscando si el id_autor
		// que acaba de meter el usuario esta almacenado.
		// Que esta almacenado muestro un error de que la id ya esta almacenada en el array
		// Que no esta almacenado, continuo en el proceso de alta.
		// boolean encontrado=buscarid(p,i,id_autor);
		System.out.println("Nombre Autor: ");
		nombre_autor = lector.nextLine();
		System.out.println("Apellidos Autor: ");
		apellidos_autor= lector.nextLine();
		System.out.println("Nacionalidad Autor: ");
		nacionalidad_autor=lector.nextLine();
		System.out.println("Fecha Nacimiento Autor: ");
		fecha_autor= lector.nextLine();
		p[i]= new Autor(id_autor,nombre_autor,apellidos_autor,nacionalidad_autor,fecha_autor);
		System.out.println("Autor insertador con exito!!!!!!");
		System.out.println("Pulsa una tecla para continuar ....");
		lector.nextLine();
		i++;
		return i;
	}
	
	public static void listarAutores(Autor[] m,int n) {
		for (int i=0;i<n;i++) {
			if (m[i].getId_autor()!=-1) {
				m[i].infoAutor();
				System.out.println("--------------------------------------------");
			}
			System.out.println("Pulsa tecla para continuar ...");
			lector.nextLine();
		}
	}
	
	public static int buscarAutorporId(Autor[] a,int c,int id) {
		int indice=-1;
		boolean encontrado=false;
		int i=0;
		while (!encontrado && i<c) {
			if (a[i].getId_autor()==id) {
				encontrado=true;
				indice=i;
			}
			i++;
		}
		
		return indice;
	}
	
	public static void modificarAutor(Autor[] c, int p) {
		int id;
		System.out.println("Usuario, dime la id del autor a modificar: ");
		id = lector.nextInt();
		lector.nextLine(); // Limpio buffer.
		int indice=buscarAutorporId(c,p,id);
		if (indice==-1) {
			// No se ha encontrado el indice en el array de autores.
			error(4);
		}
		else {
			// Procemodemos a modificarlo porque se ha localizado el id.
			// Dejamos que el usuario cambie cualquier valor menos el id,
			// porque puede darme un id duplicado que ya exista.
			String nombre_autor,apellidos_autor,nacionalidad_autor,fecha_autor;
			System.out.println("Nombre Autor: ");
			nombre_autor = lector.nextLine();
			System.out.println("Apellidos Autor: ");
			apellidos_autor= lector.nextLine();
			System.out.println("Nacionalidad Autor: ");
			nacionalidad_autor=lector.nextLine();
			System.out.println("Fecha Nacimiento Autor: ");
			fecha_autor= lector.nextLine();
			//Usamos los metodos set para establecer las nuevas propiedades del objeto en la clase
			c[indice].setNombre_autor(nombre_autor);
			c[indice].setApellidos_autor(apellidos_autor);
			c[indice].setNacionalidad(nacionalidad_autor);
			c[indice].setFecha_autor(fecha_autor);
			System.out.println("Autor modificado con exito!!!!");
			System.out.println("Pulse una tecla para continuar ...");
			lector.nextLine(); // No limpio buffer.
		}
	}
	
	public static void eliminarAutor(Autor[] a, int b) {
		int indice=0;
		limpiar_pantalla();
		System.out.println("Usuario, dime el id del autor a eliminar: ");
		int ide=lector.nextInt();
		lector.nextLine(); //Limpio buffer
		indice=buscarAutorporId(a,b,ide);
		if (indice==-1) {
			//Error.
			error(4);
		}else {
			System.out.println("¿Seguro que quieres eliminarlo?(si/no)");
			String respuesta = lector.nextLine();
			if (respuesta.equals("si") || respuesta.equals("SI") || respuesta.equals("Si")) {
				// El usuario indica que si quiere borrarlo.
				a[indice].setId_autor(-1);
				System.out.println("Autor con id "+ide+" eliminado con exito!!!");
				System.out.println("Pulse una tecla para continuar ....");
				lector.nextLine(); // No limpio buffer.
			}else{
				// Si llego aqui es que no se que ha metido el usuario pero un si no
				;
				
			}
		}
	}
	
	public static int mostrarMenuLibros() {
		int op;
		
		limpiar_pantalla();
		System.out.println("--------- Menu de Libros ---------");
		System.out.println("- 1. Insertar Libro.             -");//X
		System.out.println("- 2. Consultar Libros.           -");//X
		System.out.println("- 3. Modificar Libro.            -");//X
		System.out.println("- 4. Eliminar Libro.             -");
		System.out.println("- 5. Salir                       -");
		System.out.println("----------------------------------");
		System.out.println("Dame una opcion: ");
		op = lector.nextInt();
		// Como leo distinto de String limpio buffer.
		lector.nextLine();
		return op;
	}
	
	public static int insertarLibro(Libro[]a,int n) {
		System.out.println("Usuario dime el id del libro: ");
		int id_libro=lector.nextInt();
		System.out.println("Usuario dime el id de la editorial del libro: ");
		int id_editorial=lector.nextInt();
		System.out.println("Usuario dime el id del autor del libro: ");
		int id_autor=lector.nextInt();
		lector.nextLine(); //Limpiamos buffer
		System.out.println("Usuario dime el titulo del libro: ");
		String titulo_libro=lector.nextLine();
		System.out.println("Usuario dime el isbn del libro:");
		String isbn_libro=lector.nextLine();
		System.out.println("Usuario dime cuantas paginas tiene el libro:");
		int paginas_libro=lector.nextInt();
		a[n]=new Libro(id_libro,id_editorial,id_autor,titulo_libro,isbn_libro,paginas_libro);
		System.out.println("Libro registrado con éxito!!");
		lector.nextLine();
		System.out.println("Pulsa intro para continuar...");
		lector.nextLine();
		n++;
		return n;
	}
	
	public static void listarLibros(Libro []a,int n) {  //Aqui n indica el tamaño del array que tiene libros registrados, no actua de indice
		System.out.println("Libros registrados:");
		for (int i=0;i<n;i++) {
			if (a[i].getId_libro()!=-1) { //Si el id del libro es igual a -1 el programa no detectara tal libro como existente
				a[i].infoLibro();
				System.out.println("--------------------------------------------");
			}
		}
		System.out.println("Pulsa intro para continuar ...");
		lector.nextLine();
	}
	
	public static void errorLibros(int numero_error) {
		
		switch(numero_error) {
			case 1:{
				System.out.println("Opción no valida.");
				System.out.println("Por favor, escoge una opcion de las validas");
				System.out.println("Pulsa una tecla para continuar .....");
				lector.nextLine(); //No limpio buffer leo tecla.
				break;
			}
			case 2:{
				System.out.println("Usuario, para trabajar con los libros, antes tienes");
				System.out.println("que insertar libros pasando por la opcion 1 del Menu de Libros");
				System.out.println("Pulsa una tecla para continuar ....");
				lector.nextLine(); // No limpio buffer.
				break;
			}
			case 3:{
				System.out.println("Usuario, no hay más espacio en el array para almacenar libros");
				System.out.println("Por favor, elimina uno o varios libros para poder insertarlos");
				System.out.println("Pulsa una tecla para continuar ....");
				lector.nextLine(); // No limpio buffer.
				break;
			}
			case 4:{
				System.out.println("Usuario, el id que has proporcionado no se encuentra insertado");
				System.out.println("en la tabla de libros, porfavor ingresa un id correcto!!!");
				System.out.println("Pulsa una tecla para continuar ....");
				lector.nextLine(); // No limpio buffer.
				break;
			}
		}
	}

	public static int buscarLibroPorId(Libro[]a,int n,int id) { //n actua de tamaño del array libros
		int indice=-1;
		int i=0;
		boolean encontrado=false;
		while(!encontrado && i<n) {
			if(a[i].getId_libro()==id) {
				encontrado=true;
				indice=i;
			}
			i++;
		}
		return indice;
	}
	
	public static void modificarLibro(Libro []a,int n) {
		int id;
		System.out.println("Usuario dime el id del libro a modificar:");
		id=lector.nextInt();
		lector.nextLine();
		int indice=buscarLibroPorId(a,n,id);
		if (indice==-1) {
			// No se ha encontrado el indice en el array de libros.
			error(4);
		}else {
			System.out.println("El libro a modificar es:");
			a[indice].infoLibro();
			System.out.println("Dime el nuevo id de la editorial");
			int id_editorial=lector.nextInt();
			System.out.println("Dime el nuevo id del autor:");
			int id_autor=lector.nextInt();
			lector.nextLine();
			System.out.println("Dime el nuevo titulo del libro:");
			String titulo_libro=lector.nextLine();
			System.out.println("Dime el nuevo isbn:");
			String isbn_libro=lector.nextLine();
			System.out.println("Dime el numero de paginas del libro");
			int paginas_libro=lector.nextInt();
			a[indice].setId_editorial(id_editorial);
			a[indice].setId_autor(id_autor);
			a[indice].setTitulo_libro(titulo_libro);
			a[indice].setIsbn_libro(isbn_libro);
			a[indice].setPaginas_libro(paginas_libro);
			System.out.println("Libro modificado con exito!");
			System.out.println("Pulsa intro para continuar");
			lector.nextLine();
			lector.nextLine();
		}
	}
	
	public static void eliminarLibro(Libro[]a,int b) {
		System.out.println("Usuario dime el id del libro que quieres eliminar:");
		int id=lector.nextInt();
		int indice=buscarLibroPorId(a,b,id);
		if(indice==-1) {
			errorLibros(4);
			lector.nextLine();
			
		}else {
			System.out.println("Introduzca si o Si o SI para eliminar, o no o No o NO para no eliminar");
			lector.nextLine();
			String respuesta=lector.nextLine();
			if(respuesta.equals("si") || respuesta.equals("Si") || respuesta.equals("SI")) {
				a[indice].setId_libro(-1); //Indicamos que el id del libro el -1 cuando eliminemos el libro, ya que a la hora de listarLibros no listara losde indice -1(no existen).
				
				System.out.println("Libro con id "+id+", ha sido eliminado correctamente.");
				System.out.println("Pulsa intro para continuar...");
				lector.nextLine();
				
			}
		}
		
	}
	
	public static int mostrarMenuEditorial() {
		int op;
		
		limpiar_pantalla();
		System.out.println("--------- Menu de Editoriales --------");
		System.out.println("- 1. Insertar editorial.             -");
		System.out.println("- 2. Consultar editoriales.          -");
		System.out.println("- 3. Modificar editorial.            -");
		System.out.println("- 4. Eliminar editorial.             -");
		System.out.println("- 5. Salir                           -");
		System.out.println("--------------------------------------");
		System.out.println("Dame una opcion: ");
		op = lector.nextInt();
		// Como leo distinto de String limpio buffer.
		lector.nextLine();
		return op;
	}
	
		public static void errorEditorial(int numero_error) {
		
			switch(numero_error) {
					case 1:{
						System.out.println("Opción no valida.");
						System.out.println("Por favor, escoge una opcion de las validas");
						System.out.println("Pulsa una tecla para continuar .....");
						lector.nextLine(); //No limpio buffer leo tecla.
						break;
					}
					case 2:{
						System.out.println("Usuario, para trabajar con las editoriales, antes tienes");
						System.out.println("que insertar editoriales pasando por la opcion 1 del Menu de Editoriales");
						System.out.println("Pulsa una tecla para continuar ....");
						lector.nextLine(); // No limpio buffer.
						break;
					}
					case 3:{
						System.out.println("Usuario, no hay más espacio en el array para almacenar editoriales");
						System.out.println("Por favor, elimina una o varias editoriales para poder insertarlas");
						System.out.println("Pulsa una tecla para continuar ....");
						lector.nextLine(); // No limpio buffer.
						break;
					}
					case 4:{
						System.out.println("Usuario, el id que has proporcionado no se encuentra insertado");
						System.out.println("en la tabla de editoriales, porfavor ingresa un id correcto!!!");
						System.out.println("Pulsa una tecla para continuar ....");
						lector.nextLine(); // No limpio buffer.
						break;
					}
			}
		}
			public static int insertarEditorial(Editorial[]a,int n) {
				System.out.println("Hola usuario, dime el id de la editorial a insertar:");
				int id=lector.nextInt();
				lector.nextLine();//Limpiamos buffer, pasamos de leer int a string
				System.out.println("Dime su nombre:");
				String nombre=lector.nextLine();
				System.out.println("Dime su nacionalidad:");
				String nacionalidad=lector.nextLine();
				a[n]=new Editorial(id,nombre,nacionalidad);
				n++;
				System.out.println("Editorial insertada con exito");
				System.out.println("Pulsa intro para continuar...");
				lector.nextLine();
				return n;
			}
			
			public static void listarEditoriales(Editorial[]a,int b) {
				System.out.println("Lista de editoriales:");
				for(int i=0;i<b;i++) {
					if(a[i].getId_editorial()!=-1) {
						a[i].infoEditorial();
						System.out.println("--------------------");
					}
				}
				System.out.println("Pulsa intro para continuar...");
				lector.nextLine();
			}
			
			public static int buscarEditorialPorId(Editorial[]a,int n,int ide) {
				int indice=-1;
				int i=0;
				boolean encontrado=false;
				while(!encontrado && i<n) {
					if(a[i].getId_editorial()==ide) {
						encontrado=true;
						indice=i;
					}
					i++;
				}
				return indice;
			}
			
			public static void modificarEditorial(Editorial[]a,int n) { //n es el numero de elementos insertados
				int id;
				System.out.println("Usuario dime el id de la editorial a modificar:");
				id=lector.nextInt();
				lector.nextLine();
				int indice=buscarEditorialPorId(a,n,id);
				if (indice==-1) {
					// No se ha encontrado el indice en el array de libros.
					error(4);
				}else {
					System.out.println("La editorial a modificar es:");
					a[indice].infoEditorial();
					System.out.println("Dime el nuevo nombre de la editorial:");
					String nombre=lector.nextLine();
					System.out.println("Dime la nacionalidad de la editorial:");
					String nacionalidad=lector.nextLine();
					a[indice].setNombre(nombre);
					a[indice].setNacionalidad(nacionalidad);
					System.out.println("Editorial modificada con exito!!");
					System.out.println("Pulsa intro para continuar...");
					lector.nextLine();
				}
			}
			public static void eliminarEditorial(Editorial[]a,int n) {
				int id;
				int indice;
				System.out.println("Usuario dime el id de la editorial a eliminar:");
				id=lector.nextInt();
				indice=buscarEditorialPorId(a,n,id);
				if(indice==-1) {
					//No se ha encontrado el id pedido por el usuario 
					errorEditorial(4);
					lector.nextLine();
				}else {
					lector.nextLine();//Limpio buffer
					System.out.println("Editorial a eliminar:");
					a[indice].infoEditorial();
					a[indice].setId_editorial(-1);
					System.out.println("Editorial con id:"+id+" eliminado con exito!!");
					System.out.println("Pulsa intro para continuar...");
					lector.nextLine();
				}
			}
			
	    public static void main(String[] args) {
		// TODO Auto-generated method stub

		int tamano=50;
		Autor[] autores = new Autor[tamano];
		Libro[] libros = new Libro[tamano];
		Editorial[] editoriales = new Editorial[tamano];
		
		int indice_autores=0;
		int indice_libros=0;
		int indice_editoriales=0;
		int opcion=0;
		int opcion1=0;
		
		do {
			opcion=menuprincipal();
			switch(opcion) {
				case 1:{
					opcion1=0;
					do {
						opcion1=mostrarMenuLibros();
						switch(opcion1) {
						case 1:{
							if(indice_libros<tamano) {
								indice_libros=insertarLibro(libros,indice_libros);
							}else {
								errorLibros(3); //No hay espacio para almacenar mas libros
							}
							break;
						}
						case 2:{
							if (indice_libros==0) {
								// No tenemos libros insertados, damos error.
								errorLibros(2);
							}
							else {
								// Si estamos en este punto significa que si hay 
								// libros insertados y podemos consultarlos.
								listarLibros(libros,indice_libros);
							}
							
							break;
						}
						case 3:{
							if (indice_libros==0) {
								// No tenemos libros insertados, damos error.
								errorLibros(2);
							}else {
								modificarLibro(libros,indice_libros);
							}
							break;
						}
						case 4:{
							if(indice_libros==0) {
								errorLibros(2);
							}else {
								eliminarLibro(libros,indice_libros);
							}
							break;
						}
						case 5:{
							//No se hace nada, esta opcion nos saca de este menu
							break;
						}
						
					default:{
						error(1);
						break;
						}
					}

					}while(opcion1!=5);
				}
				
				case 2:{
					// Se corresponde con el autor.
					opcion1=0;
					do{
						opcion1=mostrarmenuAutor();
						switch (opcion1) {
							case 1:{
								// Insertar
								if (indice_autores<tamano) {
									//Puedo insertar
									indice_autores=insertar_autor(autores,indice_autores);
								}else
								{
									// No hay mas espacio para insertar, doy error.
									error(3);
								}
								break;
							}
							case 2:{
								// Consultar
								if (indice_autores==0) {
									// No tenemos autores insertados, damos error.
									error(2);
								}
								else {
									// Si estamos en este punto significa que si hay 
									// autores insertados y podemos consultarlos.
									listarAutores(autores,indice_autores);
								}
								break;
							}
							case 3:{
								// Modificar
								if (indice_autores==0) {
									// No tenemos autores insertados, damos error.
									error(2);
								}
								else {
									// Si estamos en este punto significa que si hay 
									// autores insertados y podemos modificar.
									modificarAutor(autores,indice_autores);
								}
								break;
							}
							case 4:{
								// Eliminar
								if (indice_autores==0) {
									// No tenemos autores insertados, damos error.
									error(2);
								}
								else {
									// Si estamos en este punto significa que si hay 
									// autores insertados y podemos eliminar.
									eliminarAutor(autores,indice_autores);
								}
								break;
							}
							case 5:{
								// Caso de salida, no hacemos nada
								;
								break;
							}
							default:{
								error(1);
								break;
							}
						}
					}while (opcion1!=5);
					break;
				}
				case 3:{
					do {
						opcion1=mostrarMenuEditorial();
						switch(opcion1) {
						case 1:{
							//Insertamos editorial
							indice_editoriales=insertarEditorial(editoriales,indice_editoriales);
							break;
						}
						case 2:{
							
							if(indice_editoriales==0) {
								//Si no hemos insertado ninguna editorial
								errorEditorial(2);
							}else {
								//Listamos las editoriales creadas
								listarEditoriales(editoriales,indice_editoriales);
							}
								break;
							}
						case 3:{
							if(indice_editoriales==0) {
								//Si no hemos insertado ninguna editorial
								errorEditorial(2);
							}else {
								modificarEditorial(editoriales,indice_editoriales);
							}
							//Modificamos editorial
							break;
						}
						
						case 4:{
							if(indice_editoriales==0) {
								//Si no hemos insertado ninguna editorial
								errorEditorial(2);
							}else {
								eliminarEditorial(editoriales,indice_editoriales);
							}
							//Eliminamos editorial
							
							break;
						}
						case 5:{	
							//Caso de salida de este menu, no hacemos nada
							break;
						}
						
						default:{
							error(1);
							break;
						}
			
					}
				}while(opcion1!=5);
			}
		}
	}while(opcion!=4);
		System.out.println("Fin del programa.");
		
	}
}

