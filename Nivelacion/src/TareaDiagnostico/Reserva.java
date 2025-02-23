package TareaDiagnostico;

import java.io.ObjectInputStream.GetField;

public class Reserva {
	int CantidadPersonas;
	int CapacidadQuincho;
	int NumeroZona;
	boolean Exitosa;
	
	public Reserva(int P, int Q, int Z) {
		CantidadPersonas=P;
		CapacidadQuincho=Q;
		NumeroZona=Z;
		
		Exitosa=false;
	}
	public int getCantidadPersonas() {
		return CantidadPersonas;
	}
	public int getCapacidadQuincho() {
		return CapacidadQuincho;
	}
	public int getNumeroZona() {
		return NumeroZona;
	}
	public void setExitosa(boolean exitosa) {
		Exitosa = exitosa;
	}
	public boolean getExitosa() {
		return Exitosa;
	}
	
	public void DetReserva(Zona Z) {
		if(CantidadPersonas<=CapacidadQuincho && Z.BinarySearch(CapacidadQuincho)!=0) {
			 setExitosa(true);;
		}
		else {
			setExitosa(false);
			
		}
	}
	public float DetIngreso() {
		return (4000*CantidadPersonas-(100*CapacidadQuincho*NumeroZona));
	}
	
}
