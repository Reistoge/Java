import java.util.*;
public class SistemaImp implements ISistema{
	List<Alumno> Alumnos;
	List<Asignatura > Asignaturas;
	List<String > tiposAsignaturas;
	int nAlumnos;
	int nAsignaturas;
	int promGeneral;
	public SistemaImp () {
		this.promGeneral=0;
		this.nAlumnos=0;
		this.promGeneral=0;
		this.Alumnos= new ArrayList<Alumno>();
		this.Asignaturas= new ArrayList<Asignatura>();
		this.tiposAsignaturas= new ArrayList<String>();
	}
	
	
	
	@Override
	public void informe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calcPromedio(String semestre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarAlumno(String rut) {
		
		Alumnos.add(new Alumno(rut));
		this.nAlumnos++;
		
		
	}

	@Override
	public void eliminarAlumno(String rut) {
		// TODO Auto-generated method stub
		for(int i =0; i <Alumnos.size();i++) {
			if(Alumnos.get(i).getRut().equalsIgnoreCase(rut)) {
				Alumnos.remove(i);
				break;
			}
			
		}
	}
	
	@Override
	public void setAsignatura(String semestre, String rutAlumno, String nombre, String estado, String nota,String horasEstudio ) {
		// TODO Auto-generated method stub
		Asignatura nuevaAsignatura = new Asignatura(semestre,buscarAlumno(rutAlumno),nombre,estado,nota,horasEstudio);
		buscarAlumno(rutAlumno).getAsignaturas().add(nuevaAsignatura);
		Asignaturas.add(nuevaAsignatura);
		agregarTipoAsignatura(nombre);
		
	}
	public void agregarTipoAsignatura(String tipo) {
		if(!tiposAsignaturas.contains(tipo)) {
			tiposAsignaturas.add(tipo);
		};
	}

	@Override
	public void eliminarAsignatura(String nombre) {
		// TODO Auto-generated method stub
		
	}
	private Alumno buscarAlumno(String rut) {
		for(Alumno a: Alumnos) {
			if(a.getRut().equalsIgnoreCase(rut)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public void mostrarAlumnos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarAsignaturas() {
		// TODO Auto-generated method stub
		
	}

}
