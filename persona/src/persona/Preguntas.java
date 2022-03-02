package persona;

import java.io.IOException;
import java.text.Normalizer;

public class Preguntas {
	
	boolean prueba = true;
	Persona P = new Persona();
	Ficheros fichero = new Ficheros();
	
	public void preguntas() throws IOException {
		
		prueba = true;
		
		while(prueba) {
			prueba = false;
			while(1<2) {
				System.out.println("Dame los numeros del DNI");
				P.DNINumero = Auxiliar.registroNumero();
				String comprobacion = P.DNINumero+"";
				if(comprobacion.length()== 8) {
					break;
				}
			}
			
			while(1<2) {
				System.out.println("Dame la letra del DNI");
				P.DNILetra = Auxiliar.sc.nextLine();	
				String comprobacion = P.DNILetra+"";
				if(comprobacion.length()== 1) {
					break;
				}
			}
	
			for(int i=0;i<Persona.lista.size();i++) {	
				if(Persona.lista.get(i).DNINumero == P.DNINumero && Persona.lista.get(i).DNILetra.equals(P.DNILetra)) {
					System.out.println("Este DNI ya esta asignado a un nombre, 1_Prueba otro o 2_salir");
					prueba = Auxiliar.prueba();
					if(!prueba) {
						return;
					}else{
						break;
					}
				}	
			}
		}
		
		System.out.println("Dame la nombre");
		P.nombre = Auxiliar.sc.nextLine();
		
		System.out.println("Dame el apellido 1");
		P.apellido1 = Auxiliar.sc.nextLine();
		
		System.out.println("Dame el apellido 2");
		P.apellido2 = Auxiliar.sc.nextLine();
		
		while(1<2) {
			System.out.println("Dame el sexo, hombre mujer o ninguno");
			P.sexo = Auxiliar.sc.nextLine();
			P.sexo = P.sexo.toLowerCase();
			if(P.sexo.equals("hombre") || P.sexo.equals("mujer") || P.sexo.equals("ninguno")) {
				break;
			}
		}
		
		while(1<2) {
			System.out.println("Dame la edad");
			P.edad = Auxiliar.registroNumero();
			if(P.edad>=0) {
				break;
			}
		}
		
		while(1<2) {
			System.out.println("Dame el prefijo de telefono del pais");
			P.cod_tlf = Auxiliar.registroNumero();
			String tlfPrueba = P.tlf+"";
			if(tlfPrueba.length()<=3) {
				break;
			}
		}
			
		while(1<2) {
			System.out.println("Dame la numero de telefono");
			P.tlf = Auxiliar.registroNumero();
			String tlfPrueba = P.tlf+"";
			if(tlfPrueba.length()==9) {
				break;
			}
		}

		System.out.println("Quieres guardar los datos\n1_SI\t2_NO");
		prueba = Auxiliar.prueba();
		if(prueba) {
			mayus();
			sinTilde();
			fichero.escribir(P.DNINumero,P.DNILetra,P.nombre,P.apellido1,P.apellido2,P.sexo,P.edad,P.cod_tlf,P.tlf);
			Persona.lista.add(P);
		}

		System.out.println("Quieres registrar mas datos?\n1_SI\t2_NO");
		prueba = Auxiliar.prueba();
		if(prueba) {
			preguntas();
		}
	}
	
	
	public void mayus() {
		
		P.nombre = P.nombre.toLowerCase();
		P.apellido1 = P.apellido1.toLowerCase();
		P.apellido2 = P.apellido2.toLowerCase();
		P.sexo = P.sexo.toLowerCase();
	}
	
	
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
