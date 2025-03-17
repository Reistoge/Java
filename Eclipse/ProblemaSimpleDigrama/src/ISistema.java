
public interface ISistema {
	
	void informe();
	void calcPromedio(String semestre);
	void agregarAlumno(String rut);
	void eliminarAlumno(String rut);
	void setAsignatura(String semestre, String rutAlumno, String nombre, String estado, String nota,String horasEstudio);
	void eliminarAsignatura(String nombre);
	void mostrarAlumnos();
	void mostrarAsignaturas();
	
}

