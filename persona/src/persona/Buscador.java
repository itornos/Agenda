package persona;

public class Buscador {

    public void menu(){
        System.out.println("1_ Buscar por DNI");
        System.out.println("2_ Buscar por nombre");
        System.out.println("3_ Buscar por apellido1");
        System.out.println("4_ Buscar por apellido2");
        System.out.println("5_ Buscar por sexo");
        System.out.println("6_ Buscar por edad");
        System.out.println("7_ Buscar por tlf");

        int opcion = Auxiliar.registroNumero();

        switch (opcion) {
            case 1:
                buscarDNI();
                break;
            case 2:
                buscarNombre();
                break;
            case 3:
                buscarApellido1();
                break;
            case 4:
                buscarApellido2();
                break;
            case 5:
                buscarSexo();
                break;
            case 6:
                buscarEdad();
                break;
            case 7:
                buscarTelefono();
                break;
            default:
                System.out.println("Debes poner un numero del 1 al 7");
                break;
        }
    }

    public void buscarDNI() {
		
		System.out.println("Dime el DNI de la persona");
		String palabra = Auxiliar.sc.nextLine();
		
		for(Persona i : Persona.lista) {	
			
			String DNIPrueba = i.DNINumero + i.DNILetra;
			String telefono = i.cod_tlf + " " + i.tlf;
			
			if(palabra.equals(DNIPrueba)) {
				
				System.out.println("DNI: \t\t"+DNIPrueba);
				System.out.println("Nombre: \t"+i.nombre);
				System.out.println("1º apellido: \t"+i.apellido1);
				System.out.println("2º apellido: \t"+i.apellido2);
				System.out.println("Sexo: \t\t"+i.sexo);
				System.out.println("Edad: \t\t"+i.edad);
				System.out.println("Telefono: \t#"+telefono);
				System.out.println();
			}	
		}
		
		if(!existe) {
			System.out.println("1_prueba con otro\t2_Salir");
			existe = Auxiliar.prueba();
			if(existe) {
				buscarDNI();
			}else {
				return;
			}
		}
	}

    public void buscarNombre() {
		
		System.out.println("Dime el Nombre de la persona");
		String palabra = Auxiliar.sc.nextLine();
		
		for(Persona i : Persona.lista) {	
			
			String DNIPrueba = i.DNINumero + i.DNILetra;
			String telefono = i.cod_tlf + " " + i.tlf;
			
			if(palabra.toLowerCase().equals(i.nombre.toLowerCase())) {
				
				System.out.println("DNI: \t\t"+DNIPrueba);
				System.out.println("Nombre: \t"+i.nombre);
				System.out.println("1º apellido: \t"+i.apellido1);
				System.out.println("2º apellido: \t"+i.apellido2);
				System.out.println("Sexo: \t\t"+i.sexo);
				System.out.println("Edad: \t\t"+i.edad);
				System.out.println("Telefono: \t#"+telefono);
				System.out.println();
			}	
		}
		
		if(!existe) {
			System.out.println("1_prueba con otro\t2_Salir");
			existe = Auxiliar.prueba();
			if(existe) {
				buscarNombre();
			}else {
				return;
			}
		}
	}

    public void buscarApellido1() {
		
		System.out.println("Dime el 1º apellido de la persona");
		String palabra = Auxiliar.sc.nextLine();
		
		for(Persona i : Persona.lista) {	
			
			String DNIPrueba = i.DNINumero + i.DNILetra;
			String telefono = i.cod_tlf + " " + i.tlf;
			
			if(palabra.toLowerCase().equals(i.apellido1.toLowerCase())) {
				
				System.out.println("DNI: \t\t"+DNIPrueba);
				System.out.println("Nombre: \t"+i.nombre);
				System.out.println("1º apellido: \t"+i.apellido1);
				System.out.println("2º apellido: \t"+i.apellido2);
				System.out.println("Sexo: \t\t"+i.sexo);
				System.out.println("Edad: \t\t"+i.edad);
				System.out.println("Telefono: \t#"+telefono);
				System.out.println();
			}	
		}
		
		if(!existe) {
			System.out.println("1_prueba con otro\t2_Salir");
			existe = Auxiliar.prueba();
			if(existe) {
				buscarApellido1();
			}else {
				return;
			}
		}
	}

    public void buscarApellido2() {
			
		System.out.println("Dime el 2º apellido de la persona");
		String palabra = Auxiliar.sc.nextLine();
	
		for(Persona i : Persona.lista) {	
			
			String DNIPrueba = i.DNINumero + i.DNILetra;
			String telefono = i.cod_tlf + " " + i.tlf;
			
			if(palabra.toLowerCase().equals(i.apellido2.toLowerCase())) {
				System.out.println("DNI: \t\t"+DNIPrueba);
				System.out.println("Nombre: \t"+i.nombre);
				System.out.println("1º apellido: \t"+i.apellido1);
				System.out.println("2º apellido: \t"+i.apellido2);
				System.out.println("Sexo: \t\t"+i.sexo);
				System.out.println("Edad: \t\t"+i.edad);
				System.out.println("Telefono: \t#"+telefono);
				System.out.println();
			}	
		}
		
		if(!existe) {
			System.out.println("1_prueba con otro\t2_Salir");
			existe = Auxiliar.prueba();
			if(existe) {
				buscarApellido2();
			}else {
				return;
			}
		}
	}

    public void buscarSexo() {
		
		System.out.println("Dime el sexo de la persona");
		String palabra = Auxiliar.sc.nextLine();
		
		for(Persona i : Persona.lista) {	
			
			String DNIPrueba = i.DNINumero + i.DNILetra;
			String telefono = i.cod_tlf + " " + i.tlf;
			
			if(palabra.toLowerCase().equals(i.sexo)) {
				System.out.println("DNI: \t\t"+DNIPrueba);
				System.out.println("Nombre: \t"+i.nombre);
				System.out.println("1º apellido: \t"+i.apellido1);
				System.out.println("2º apellido: \t"+i.apellido2);
				System.out.println("Sexo: \t\t"+i.sexo);
				System.out.println("Edad: \t\t"+i.edad);
				System.out.println("Telefono: \t#"+telefono);
				System.out.println();
			}	
		}
		
		if(!existe) {
			System.out.println("1_prueba con otro\t2_Salir");
			existe = Auxiliar.prueba();
			if(existe) {
				buscarSexo();
			}else {
				return;
			}
		}
	}

	public void buscarEdad() {
		
		
		System.out.println("Dime la edad de la persona");
		int palabra = Auxiliar.registroNumero();
		
		for(Persona i : Persona.lista) {	
			
			String DNIPrueba = i.DNINumero + i.DNILetra;
			String telefono = i.cod_tlf + " " + i.tlf;
			
			if(palabra == i.edad) {
				System.out.println("DNI: \t\t"+ DNIPrueba);
				System.out.println("Nombre: \t"+i.nombre);
				System.out.println("1º apellido: \t"+i.apellido1);
				System.out.println("2º apellido: \t"+i.apellido2);
				System.out.println("Sexo: \t\t"+i.sexo);
				System.out.println("Edad: \t\t"+i.edad);
				System.out.println("Telefono: \t#"+telefono);
				System.out.println();
			}	
		}
		
		if(!existe) {
			System.out.println("1_prueba con otro\t2_Salir");
			existe = Auxiliar.prueba();
			if(existe) {
				buscarEdad();
			}else {
				return;
			}
		}
	}

    public void buscarTelefono() {
		
		System.out.println("Dime el prefijo del numero de telefono");
		String palabra = Auxiliar.registroNumero() + "";//Pedimos un int llamando al metedo y sumamos nada para que pase de int a String

		System.out.println("Dime el numero del numero de telefono");
		palabra = palabra + " " +Auxiliar.registroNumero();//Se añade el numero al prefijo

		for(Persona i : Persona.lista) {	
			
			String DNIPrueba = i.DNINumero + i.DNILetra;
			String telefono = i.cod_tlf + " " + i.tlf;
			
			if(palabra.toLowerCase().equals(telefono)) {
				System.out.println("DNI: \t\t"+DNIPrueba);
				System.out.println("Nombre: \t"+i.nombre);
				System.out.println("1º apellido: \t"+i.apellido1);
				System.out.println("2º apellido: \t"+i.apellido2);
				System.out.println("Sexo: \t\t"+i.sexo);
				System.out.println("Edad: \t\t"+i.edad);
				System.out.println("Telefono: \t#"+telefono);
				System.out.println();
			}	
		}
		
		if(!existe) {
			System.out.println("1_prueba con otro\t2_Salir");
			existe = Auxiliar.prueba();
			if(existe) {
				buscarTelefono();
			}else {
				return;
			}
		}
	}
}