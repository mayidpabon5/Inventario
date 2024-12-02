package Menu;

import java.util.Scanner;

public class Menu {

    //Menu principal

    public static int MenuPrincipal(Scanner a) {
        System.out.println("""
                ---------------------------------------------
                -               INVENTARIO                  -
                ---------------------------------------------
                - 1. Agregar Producto                       -
                - 2. Actualizar Producto                    -
                - 3. Eliminar Producto                      -
                - 4. Buscar por Categoria                   -
                - 5. Calcular precio Mayor                  -
                - 6. Cantidad de productos por categoría    -
                - 7. Reporte                                -
                - 8. Salir                                  -
                ---------------------------------------------
                Digite una opción para continuar:""");
        return a.nextInt();
    }
    public static int buscar (Scanner a) {
        System.out.println("""
                ---------------------------------------------
                -               BUSCAR                      -
                ---------------------------------------------
                - 1. Categoria                    -
                - 2. Nombre                   -
                - 3. Id Producto                   -                               -
                ---------------------------------------------
                Digite una opción para Buscar:""");
        return a.nextInt();
    }
}