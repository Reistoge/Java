 package nivelacion;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

//para abrir el archivo necesitas de primero importar import java.io.IOException; y ademas el texto debe estar en src
 
//Navegación y Edición:
//Ctrl + Shift + R: Abre el cuadro de diálogo “Abrir recurso” para buscar y abrir cualquier archivo en tu proyecto.
//Ctrl + Shift + T: Abre el cuadro de diálogo “Abrir tipo” para buscar y abrir una clase, interfaz o enum.
//Ctrl + E: Muestra una lista de los archivos abiertos recientemente.
//Ctrl + F6: Alterna entre los editores abiertos.
//Ctrl + L: Navega a una línea específica en el archivo actual.
//Ctrl + D: Borra la línea actual.
//Ctrl + /: Comenta o descomenta la línea o el bloque seleccionado.
//Ctrl + Shift + F: Formatea automáticamente el código.

//Refactorización:
//Alt + Shift + R: Renombra un elemento (variable, método, clase, etc.).
//Alt + Shift + M: Extrae un método.
//Alt + Shift + L: Extrae una variable local.
//Alt + Shift + C: Cambia la firma de un método.

//Depuración:
//F5: Paso a paso en (entra en) el método actual.
//F6: Paso a paso sobre (ignora) el método actual.
//F8: Continúa la ejecución hasta el siguiente punto de interrupción.
//Ctrl + Shift + B: Agrega o quita un punto de interrupción.

//Otras Funcionalidades:
//Ctrl + Space: Activa el asistente de contenido para autocompletar código.
//Ctrl + 1: Muestra las correcciones rápidas disponibles para el error o advertencia actual.
//Ctrl + Shift + O: Organiza las importaciones.
//Ctrl + Shift + L: Muestra todos los atajos de teclado disponibles.
 public class ejercicios3 {
	
	public static void main(String[] args) throws IOException {

		File file = new File("src/nivelacion/proyectos.txt");
		Scanner scan = new Scanner(file);
		String Line="";
		String[][] personas=new String[15][200];
		while (scan.hasNextLine()) {
			Line=scan.next();
			//System.out.println(scan.nextLine());
		}
		
		System.out.println(Line);
		scan.close();
		
		

	}
}
