package persona;

import java.io.IOException;
import java.text.Normalizer;

public class Preguntas {
	
	boolean prueba = true;
	Persona P = new Persona();
	Ficheros fichero = new Ficheros();
	
	//Preguntas sobre los datos de la persona
	public void preguntas() throws IOException {
		
		prueba = true;
		
		//Prueba de DNI bien formado y no repetido
		while(prueba) {
			prueba = false;
			
			//Mentras el DNI no este bien formado no sale del bucle
			while(1<2) {
				System.out.println("Dame los numeros del DNI");
				P.DNINumero = Auxiliar.registroNumero();
				String comprobacion = P.DNINumero+"";
				if(comprobacion.length()== 8) {
					break;
				}
			}
			
			//Mentras el DNI no este bien formado no sale del bucle
			while(1<2) {
				System.out.println("Dame la letra del DNI");
				P.DNILetra = Auxiliar.sc.nextLine();	
				if(P.DNILetra.length()== 1) {
					break;
				}
			}
	
			//Comprobacion de la existencia del DNI, si existe dentro del fichero se pide otro
			for(Persona i: Persona.lista) {
				if(i.DNINumero == P.DNINumero) {

					if(i.DNILetra.equals(P.DNILetra)){
						System.out.println("Este DNI ya esta asignado a un nombre");
					}else{
						System.out.println("No puede haber dos personas con el mismo número de DNI y distintas letras");
					}

					System.out.println("1_Prueba otro o 2_salir");
					prueba = Auxiliar.prueba();
					if(!prueba) {
						return;
					}else{
						break;
					}
				}		
			}
		}
		
		System.out.println();//salto

		System.out.println("Dame la nombre");
		P.nombre = Auxiliar.sc.nextLine();
		
		System.out.println();//salto

		System.out.println("Dame el apellido 1");
		P.apellido1 = Auxiliar.sc.nextLine();

		System.out.println();//salto
		
		System.out.println("Dame el apellido 2");
		P.apellido2 = Auxiliar.sc.nextLine();

		System.out.println();//salto
		
		//Mientras el sexo de la persona no sea hombre mujer o ninguno se repite
		while(1<2) {
			System.out.println("Dame el sexo, hombre mujer o ninguno");
			P.sexo = Auxiliar.sc.nextLine();
			P.sexo = P.sexo.toLowerCase();
			if(P.sexo.equals("hombre") || P.sexo.equals("mujer") || P.sexo.equals("ninguno")) {
				break;
			}
		}

		System.out.println();//salto
		
		//Mientras la edad no sea >= de 0 se repite
		while(1<2) {
			System.out.println("Dame la edad");
			P.edad = Auxiliar.registroNumero();
			if(P.edad>=0) {
				break;
			}
		}

		System.out.println();//salto
		
		//Mientras el prefijo no sea <= de 3 digitos se repite
		while(1<2) {
			System.out.println("Dame el prefijo de telefono del pais");
			P.cod_tlf = Auxiliar.registroNumero();
			String tlfPrueba = P.cod_tlf+"";
			if(tlfPrueba.length()<=3) {
				break;
			}else{
				System.out.println("El prefijo debe de tener 3 numeros o menos");
			}
		}

		System.out.println();//salto
			
		//Mientras el telefono no sea == de 9 digitos se repite
		while(1<2) {
			System.out.println("Dame el numero de telefono");
			P.tlf = Auxiliar.registroNumero();
			String tlfPrueba = P.tlf+"";

			for(Persona i: Persona.lista) {
				if(i.tlf == P.tlf) {
					System.out.println("Este numero de telefono ya esta asignado a otra persona");
					tlfPrueba = "repetido";
					break;
				}
			}

			if(tlfPrueba.length()==9) {
				break;
			}
		}

		System.out.println();//salto

		System.out.println("Quieres guardar los datos\n1_SI\t2_NO");
		prueba = Auxiliar.prueba();
		if(prueba) {
			mayus();//Datos sin mayusculas
			sinTilde();//quitamos caracteres extra�os
			fichero.escribir(P.DNINumero,P.DNILetra,P.nombre,P.apellido1,P.apellido2,P.sexo,P.edad,P.cod_tlf,P.tlf);//Se guardan los datos en el fichero
			Persona.lista.add(P);//Se guardan los datos en la lista
		}

		System.out.println();//salto

		System.out.println("Quieres registrar mas datos?\n1_SI\t2_NO");
		prueba = Auxiliar.prueba();
		if(prueba) {
			preguntas();
		}
	}
	
	//Se quitan las mayusculas
	public void mayus() {
		
		P.nombre = P.nombre.toLowerCase();
		P.apellido1 = P.apellido1.toLowerCase();
		P.apellido2 = P.apellido2.toLowerCase();
		P.sexo = P.sexo.toLowerCase();
	}
	
	//Se quitan los caracteres extra�os
	public void sinTilde() {
		
		P.nombre = Normalizer.normalize(P.nombre, Normalizer.Form.NFD);
		P.nombre = P.nombre.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		
		P.apellido1 = Normalizer.normalize(P.apellido1, Normalizer.Form.NFD);
		P.apellido1 = P.apellido1.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		
		P.apellido2 = Normalizer.normalize(P.apellido2, Normalizer.Form.NFD);
		P.apellido2 = P.apellido2.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
		
		P.sexo = Normalizer.normalize(P.sexo, Normalizer.Form.NFD);
		P.sexo = P.sexo.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	}
}
