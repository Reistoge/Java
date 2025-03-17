
public abstract class Videojuego {
	String tipo,titulo,desarrollador,releaseDate,plataforma,estado;
	
	
	
	
	
	protected Videojuego(String[] line) {
		this.tipo=line[0].strip();
		this.titulo=line[1].strip();
		this.desarrollador=line[2].strip();
		this.releaseDate=line[3].strip();
		this.plataforma=line[4].strip();
		this.estado=line[5].strip();
	
	}
	
	String info(Videojuego v) {
		return  ("Tipo:"+v.tipo+"\r\n"
				+ "Titulo:"+this.titulo+" \r\n"
				+ "Desarrollador:"+v.desarrollador+" \r\n"
				+ "Fecha de Lanzamiento"+v.releaseDate+"\r\n"
				+ "Plataforma:"+v.plataforma+" \r\n"
				+ "Estado:"+v.estado+"\n");
				 
	}
	public abstract String getInfo();
	public static Videojuego crearVideojuego(String[] partes) {
		Videojuego v = null;
		if(partes[0].equalsIgnoreCase("RPG")) {
			v= new Rpg(partes);
		}
		else if (partes[0].equalsIgnoreCase("Shooter")) {
			v= new Shooter(partes);
		}
		else if (partes[0].equalsIgnoreCase("Puzzle")) {
			v= new Puzzle(partes);
		}
		return v;
	}
	
	
	
	 
	
	 

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDesarrollador() {
		return desarrollador;
	}

	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
