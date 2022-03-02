package persona;

import java.util.Scanner;

public class Auxiliar {
	
	static Scanner sc = new Scanner(System.in);
	
	public static int registroNumero(){
		int numero=0;//valor que se develve
		boolean repetido = true;//bucle
		while(repetido){
            try {//en caso de fallo al escribir se repite
				numero = Integer.parseInt(sc.nextLine());//Recogida
                repetido = false;//termina el bucle
            }catch(Exception e) {//El valor Integer esta compuesto por valores no validos
                System.out.println("\nDebes dale un numero sin letras");
                repetido = true;
            }
        }
		return numero;//numero devuelto
    }
    
	public static boolean prueba(){
		boolean repetido=true;
		while(1<2){//bluce infinito que se rompe con la decision correcta
			int decision = registroNumero();//valor de la decision
			if(decision==1){//continuar probando
				repetido = true;
				break;
			}else if(decision==2){//salir 
				repetido=false;
				break;
			}else{//decision incorrecta
				System.out.println("Debes darme un 1 o un 2");
			}
		}
		return repetido;//decision devuelta, true o false
	}
}
