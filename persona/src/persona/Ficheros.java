package persona;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ficheros {
	public void escribir(int DNINumero, String DNILetra, String nombre, String apellido1, String apellido2, String sexo, int edad, int cod_tlf, int tlf) throws IOException{
	    BufferedWriter escribir = null;
	    try {
	        FileWriter ficheroE = new FileWriter("persona.txt", true);
	        escribir = new BufferedWriter(ficheroE);
	    
	    }catch (IOException e) {
	        System.err.println("Error: " + e.getMessage());
	    }
	    try {
		    escribir.write(DNINumero+";"+DNILetra+";"+nombre+";"+apellido1+";"+apellido2+";"+sexo+";"+edad+";"+cod_tlf+";"+tlf+";\n");
		    escribir.close();
		    System.out.println("Los datos se han guardado");	    
	    }catch (IOException e) {
	        System.out.println("No se han podido guardar los datos");
	    }
	}
	
	public void leer() throws IOException {
		Persona persona = new Persona();//objeto de clase jugador para acceder a los valores de la clase

		int contador=0;//contador de palabras
		boolean repetido=true;//bucle
		FileReader fichero = null;//fichero a observar
		int caracter;//valor leido
		String palabra = "";//cadena de caracteres leidos
		
		//buscar fichero
		while(repetido){
			try {
				fichero = new FileReader("persona.txt");
				repetido = false;
			} catch (Exception e) {
			}
		}
		while((caracter = fichero.read()) != -1) {
			if((char)caracter!=';') {
			    palabra = palabra + (char)caracter;
			}
			else {
				contador++;
			    switch(contador) {
			    	case 1:
			    		persona.DNINumero =Integer.parseInt(palabra);break;
			    	case 2:
			    		persona.DNILetra = palabra;break;
			    	case 3:
						persona.nombre =palabra;break;
			    	case 4:
						persona.apellido1=palabra;break;
			    	case 5:
						persona.apellido2=palabra;break;
			    	case 6:
						persona.sexo=palabra;break;					
			    	case 7:
						persona.edad=Integer.parseInt(palabra);break;	
			    	case 8:
						persona.cod_tlf=Integer.parseInt(palabra);break;	
			    	case 9:
						persona.tlf=Integer.parseInt(palabra);			
						contador=0;//reseteo para nueva importacion
						
						//limpiar salto de linea del fichero
						int cont=1;
						while((caracter = fichero.read()) != -1) { 
							if(cont==2) {
								break;
							}
							cont++;
						}
						Persona rPersona = new Persona(persona.DNINumero,persona.DNILetra, persona.nombre, persona.apellido1, persona.apellido2, persona.sexo, persona.edad, persona.cod_tlf, persona.tlf);
						Persona.lista.add(rPersona);
						break;
			    }
				palabra = "";//reset de palabra para meter un campo nuevo
			}
		}
	}
}
