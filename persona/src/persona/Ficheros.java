package persona;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ficheros {
	
	//Metodo para guardar los datos de la persona dentro del fichero
	public void escribir(int DNINumero, String DNILetra, String nombre, String apellido1, String apellido2, String sexo, int edad, int cod_tlf, int tlf) throws IOException{
		
	    BufferedWriter escribir = null;
	    
	    //buscar fichero, en caso de error se mustra el mensaje y termina el metodo
	    try {
	        FileWriter ficheroE = new FileWriter("persona.txt", true);
	        escribir = new BufferedWriter(ficheroE);
	    
	    }catch (IOException e) {
	    	System.out.println("no se ha encotrdao es fichero");
			return;
	    }
	    
	    //Se intenta guardar cada valor de la persona dentro del fichero con un formato especificado
	    try {
		    escribir.write(DNINumero+";"+DNILetra+";"+nombre+";"+apellido1+";"+apellido2+";"+sexo+";"+edad+";"+cod_tlf+";"+tlf+";\n");
		    escribir.close();
		    System.out.println("Los datos se han guardado");	    
	    }catch (IOException e) {
	        System.out.println("No se han podido guardar los datos");
	    }
	}
	
	//Se lee el fichero con los datos de las personas y se guardan en una lista  
	public void leer() throws IOException {
		
		Persona persona = new Persona();//objeto de clase jugador para acceder a los valores de la clase

		int contador=0;//contador de palabras
		boolean repetido=true;//bucle
		FileReader fichero = null;//fichero a observar
		int caracter;//valor leido
		String palabra = "";//cadena de caracteres leidos
		
		//buscar fichero, en caso de error se mustra el mensaje y termina el metodo
		try {
			fichero = new FileReader("persona.txt");
			repetido = false;
		} catch (Exception e) {
			System.out.println("no se ha encotrdao es fichero");
			return;
		}
		
		//mientras haya caracteres en el fichero los leera
		while((caracter = fichero.read()) != -1) {
			if((char)caracter!=';') {//si se encuentra un ; la palabra esta completa
			    palabra = palabra + (char)caracter;
			}
			else {
				contador++;//Numero de palabras obtenidas
			    switch(contador) {
			    	case 1:
			    		persona.DNINumero =Integer.parseInt(palabra);break;//1º Palabra
			    	case 2:
			    		persona.DNILetra = palabra;break;//2º Palabra
			    	case 3:
						persona.nombre =palabra;break;//3º Palabra
			    	case 4:
						persona.apellido1=palabra;break;//4º Palabra
			    	case 5:
						persona.apellido2=palabra;break;//5º Palabra
			    	case 6:
						persona.sexo=palabra;break;//6º Palabra			
			    	case 7:
						persona.edad=Integer.parseInt(palabra);break;//7º Palabra
			    	case 8:
						persona.cod_tlf=Integer.parseInt(palabra);break;//8º Palabra	
			    	case 9:
						persona.tlf=Integer.parseInt(palabra);//9º Palabra	
						contador=0;//reseteo para nueva importacion de la siguiente linea
						
						//limpiar salto de linea del fichero
						int cont=1;
						while((caracter = fichero.read()) != -1) { 
							if(cont==2) {
								break;
							}
							cont++;
						}
						
						//Se pasan los valores obtenidos a un objeto persona y se añaden a la lista
						Persona rPersona = new Persona(persona.DNINumero,persona.DNILetra, persona.nombre, persona.apellido1, persona.apellido2, persona.sexo, persona.edad, persona.cod_tlf, persona.tlf);
						Persona.lista.add(rPersona);
						break;
			    }
				palabra = "";//reset de palabra para meter un campo nuevo
			}
		}
	}
}
