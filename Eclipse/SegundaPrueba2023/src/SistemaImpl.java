import java.util.List;

public class SistemaImpl implements ISistema{

	private static SistemaImpl instance;
	List<Consulta> consultas;
	List<Medicamento> medicamentos;
	List<Paciente> pacientes;
	
	private SistemaImpl() {
		
	}
	public static SistemaImpl getInstance() {
		if(instance ==null) {
			instance=new SistemaImpl();
		}
		return instance;
	}

	@Override
	public String crearNuevoPaciente(String[] datos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String realizarConsulta(String[] datos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listarDueño(String[] datos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ingresarPorFecha(String[] datos) {
		// TODO Auto-generated method stub
		return null;
	}
	public void crearConsulta(String[] datos) {
		// TODO Auto-generated method stub
		
	}
	 
	

}
class Medicamento{
	
}
class Dueño{
	
}
class Mascota{
	
}
class MascotaExotica extends Mascota{
	
}
class MascotaComun extends Mascota{
	
}
class Paciente{
	Mascota m;
	Dueño d;
}
class Consulta{
	
}
interface Ivisitor{
	String visit(Mascota m);
	
}

 
