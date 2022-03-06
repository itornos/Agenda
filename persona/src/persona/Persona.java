package persona;

import java.util.ArrayList;

public class Persona {
	String DNILetra;
	int DNINumero;
	String nombre;
	String apellido1;
	String apellido2;
	String sexo;
	int edad;
	int tlf;
	int cod_tlf;
	static ArrayList<Persona> lista = new ArrayList<Persona>();
	
	public Persona (int DNINumero, String DNILetra, String nombre, String apellido1, String apellido2, String sexo, int edad, int cod_tlf, int tlf){
    	this.DNINumero = DNINumero;
    	this.DNILetra = DNILetra;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.sexo = sexo;
		this.edad = edad;
		this.cod_tlf = cod_tlf;
		this.tlf = tlf;
	}
    
    public Persona () {}
	
	public void leerPersona() {

		int personas=1;
		for(Persona i : Persona.lista) {
			
			String DNI = i.DNINumero + i.DNILetra.toUpperCase();
			String telefono = "#" + i.cod_tlf + " " + i.tlf;
			
			System.out.println("Persona "+personas);
			System.out.println("DNI: \t\t"+DNI);
			System.out.println("Nombre: \t"+i.nombre);
			System.out.println("1� apellido: \t"+i.apellido1);
			System.out.println("2� apellido: \t"+i.apellido2);
			System.out.println("Sexo: \t\t"+i.sexo);
			System.out.println("Edad: \t\t"+i.edad);
			System.out.println("Telefono: \t"+telefono);
			System.out.println();
			personas++;
		}
	}
}