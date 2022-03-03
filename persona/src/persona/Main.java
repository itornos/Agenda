package persona;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		boolean salir = true;
			
		Persona persona = new Persona();
		Preguntas preguntas = new Preguntas();
		Ficheros fichero = new Ficheros();

		fichero.leer();
		
		while(salir){
			
			//Opciones del menu
			System.out.println("Elige una opcion");
			System.out.println("1_ Regitrar datos");
			System.out.println("2_ Leer los datos");
			System.out.println("3_ Buscar datos");
			System.out.println("4_ Terminar");
		
			//Se escanea lo escrito en la terminal y se mueve a la opcion seleccionada
			int opcion = Auxiliar.registroNumero();
			System.out.println();
			switch(opcion) {
			case 1:
				preguntas.preguntas();
				break; 
			case 2:
				persona.leerPersona();
				break;
			case 3:
				persona.buscarDato();
				break;
			case 4:
				salir = false;
				System.out.println("La ejecucion va a terminar");
				break;
			}
		}
	}
}
