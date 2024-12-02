package Controladores;

import java.util.Scanner;

public class Controladores {

    //Validador que controla opción valida para el menu principal
    public static int validarOpcionMenuPrincipal(int a, Scanner b){
        while (a<1 || a>9){
            System.out.println("Ingreso una opción invalida, por favor digite una opción valida:");
            a = b.nextInt();
        }
        return a;
    }
}
