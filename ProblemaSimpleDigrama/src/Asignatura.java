
public class Asignatura {
	String nombre,horasEstudio,semestre,estado,nota;
	Alumno alumno;
	public Asignatura(String semestre, Alumno a, String nombre, String estado, String nota,String horasEstudio) {
		
		this.nombre = nombre;
		this.horasEstudio = horasEstudio;
		this.semestre = semestre;
		this.estado = estado;
		this.nota = nota;
		this.alumno=a;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHorasEstudio() {
		return horasEstudio;
	}

	public void setHorasEstudio(String horasEstudio) {
		this.horasEstudio = horasEstudio;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public String mostrarAlumno() {
		
		return this.alumno.mostrarAlumno();
	}

	@Override
	public String toString() {
		return "Nombre:" + this.nombre +"\nHoras de estudio: " + this.horasEstudio + "\nSemestre: " + this.semestre
				+ "\nEstado:" + this.estado + "\nNota:" + this.nota + "\n";
	}

	
	
}
