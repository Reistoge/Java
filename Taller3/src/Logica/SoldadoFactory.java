package Logica;

import java.util.ArrayList;

public class SoldadoFactory {
	float maxFactorEntrenamiento;
	float maxFactorCorrer;

	public SoldadoFactory() {
		maxFactorCorrer = 0;
		maxFactorCorrer = 0;
	}

	public Soldado crearSoldado(String[] datosSoldado) {

		String nombre = datosSoldado[0];
		String rut = datosSoldado[1];
		String contraseña = datosSoldado[2];
		String cede = datosSoldado[3];
		String tipo = datosSoldado[4];
		// los diferentes tipos de soldados se deben de construir de distinta manera.
		if (tipo.equalsIgnoreCase("fusilero")) {
			String arma = datosSoldado[5];
			String clase = datosSoldado[6];
			String pesoArma = datosSoldado[7];

			Fusilero f = new Fusilero(nombre, rut, contraseña, cede, tipo);
			f.setArma(arma);
			f.setClase(clase);
			f.setPesoArma(pesoArma);
			agregarEntrenamiento(f);

			return f;

		} else if (tipo.equalsIgnoreCase("marino")) {
			String tipoEmbarcacion = datosSoldado[5];
			String puestoEmbarcacion = datosSoldado[6];

			Marino m = new Marino(nombre, rut, contraseña, cede, tipo);

			m.setEmbarcacion(tipoEmbarcacion);
			m.setPuestoEmbarcacion(puestoEmbarcacion);
			agregarEntrenamiento(m);

			return m;
		} else if (tipo.equalsIgnoreCase("piloto")) {
			String lugarEspionaje = datosSoldado[5];
			String tipoNave = datosSoldado[6];
			String alturaDeVuelo = datosSoldado[7];

			Piloto p = new Piloto(nombre, rut, contraseña, cede, tipo);
			p.setLugarEspionaje(lugarEspionaje);
			p.setTipoNave(tipoNave);
			p.setAlturaVuelo(alturaDeVuelo);
			agregarEntrenamiento(p);
			return p;

		} else if (tipo.equalsIgnoreCase("infante")) {
			String tipoDeRol = datosSoldado[5];
			String lugarQueVigila = datosSoldado[6];
			Infante inf = new Infante(nombre, rut, contraseña, cede, tipo);
			inf.setRol(tipoDeRol);
			inf.setLugarQueVigila(lugarQueVigila);
			agregarEntrenamiento(inf);
			return inf;
		}

		return null;

	}

	private void agregarEntrenamiento(Soldado s) {
		// System.out.println(s.getRut());
		String rut = s.getRut();
		String[] rutPartes = rut.split("\\.");

		float primerosDosDigitos = Float.parseFloat(rutPartes[0]);
		float penultimoDigito = Float.parseFloat(rutPartes[2].split("-")[0].charAt(2) + "");
		float factorEntrenamiento = penultimoDigito * primerosDosDigitos;

		float tercerDigito = Float.parseFloat(rutPartes[1].charAt(0) + "");
		float cuartoDigito = Float.parseFloat(rutPartes[1].charAt(1) + "");
		float factorCorrer = ((tercerDigito + cuartoDigito) * 100) / 9.8f;
		s.setFactorCorrer(factorCorrer);
		s.setFactorEntrenamiento(factorCorrer);

		ActividadComponent entrenamiento = new Actividad("Entrenar",
				"Ecuacion entrenamiento: " + factorEntrenamiento + "\nEcuacion de correr: " + factorCorrer);
		s.getActividades().add(entrenamiento);
	}
}
