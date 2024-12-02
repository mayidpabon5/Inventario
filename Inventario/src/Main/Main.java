package Main;

import Controladores.Controladores;
import Inventario.Inventario;
import Menu.Menu;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Variable donde se guarda la opción ingresada en el menu
        int a;
        //Variable donde se guarda la opción ingresada en buscar
        int b;
        //Variable que me indicara la opción del Menu
        Scanner opcionMenu = new Scanner(System.in);
        //Variable que sirve para regresar al menu principal una vez realizada la opción elegida por el usuario
        Scanner ingresar = new Scanner(System.in);
        //Variable de la clase inventario
        Inventario inventario = new Inventario();

        //Do - While que se encarga de repetir el menu principal, hasta que la opción sea 8
        do {
            //Metodo que se encarga de traer el menu principal
            a = Menu.MenuPrincipal(opcionMenu);
            //Valida que la opción ingresada sea correcta
            a = Controladores.validarOpcionMenuPrincipal(a, opcionMenu);

            switch (a) {

                case 1:
                    inventario.guardarProductoEnElArchivo();
                    break;
                case 2:
                    inventario.actualizarArchivo();
                    break;
                case 3:

                    inventario.eliminarProducto();
                    break;
                case 4:
                    b = Menu.buscar(ingresar);
                    switch (b) {

                        case 1:
                            inventario.buscarPorCategoria();
                            break;
                        case 2:
                            inventario.buscarPorNombre();
                            break;
                        case 3:
                            inventario.buscarPorIdProducto();
                            break;
                    }
                    break;
                case 5:
                    inventario.mayorValor();
                    break;
                case 6:
                    System.out.println("""
                            A continuación se relaciona el total de cantidades agrupados por Categoria:
                            -----------------------------------------------------------------------------""");
                    System.out.println(inventario.cantidadPorCategoria());
                    System.out.println("-----------------------------------------------------");
                    System.out.println("presione Enter para salir al menu principal");
                    ingresar.hasNextLine();
                    break;
                case 7:
                    inventario.reporte();
                    break;
            }
        } while (a != 8);
    }
}