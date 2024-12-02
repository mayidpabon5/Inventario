package Inventario;

import Producto.Producto;
import java.io.*;
import java.util.*;

public class Inventario {
    // Crea la lista Producto que trabaja con Arraylist
    List<Producto> inventario = new ArrayList<>();
    //Crea variable Scanner para poder ingresar el Enter
    Scanner ingresar = new Scanner(System.in);

    // Metodo cargue del inventario desde un archivo
    public List<Producto> cargueInventario() {

        //Construir una variable para agregar la ruta donde se encuentra el archivo
        inventario.clear();
        String RutaArchivo = "D:\\Capitulo Programación basica\\TallerFinal\\Data.txt";

        //Agregar BufferedReader dentro de los parentesis garantiza el cierre del archivo
        try (BufferedReader br = new BufferedReader(new FileReader(RutaArchivo))) {
            String Linea;

            //Leemos las lineas del archivo
            while ((Linea = br.readLine()) != null) {
                String[] archivo = Linea.split(",");
                //Se agregan a las variables
                String idProducto = archivo[0];
                String nombreProducto = archivo[1];
                String categoria = archivo[2];
                int precio = Integer.parseInt(archivo[3]);
                int cantidadDisponible = Integer.parseInt(archivo[4]);

                //Se crea una instancia de la clase producto
                Producto b = new Producto(idProducto, nombreProducto, categoria, precio, cantidadDisponible);

                //Se agregan a la lista inventario
                inventario.add(b);
            }
        } catch (IOException e) {
            System.out.println("No se encontro archivo en la ruta");
        }
        return inventario;
    }

    //Metodo para guardar un nuevo producto en el archivo
    public void guardarProductoEnElArchivo() {
        System.out.println("Vas añadir un nuevo producto, presiona Enter para iniciar");
        ingresar.nextLine();
        System.out.println("Ingrese el idProducto");
        String idProducto = ingresar.nextLine();
        System.out.println("Ingrese nombreProducto");
        String nombreProducto = ingresar.nextLine();
        System.out.println("Ingrese la categoria");
        String categoria = ingresar.nextLine();
        System.out.println("Ingrese el precio");
        int precio = ingresar.nextInt();
        System.out.println("Ingrese cantidad disponible");
        int cantidadDisponible = ingresar.nextInt();
        Producto nuevoProducto = new Producto(idProducto, nombreProducto, categoria, precio, cantidadDisponible);
        inventario.add(nuevoProducto);
        String RutaArchivo = "D:\\Capitulo Programación basica\\TallerFinal\\Data.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RutaArchivo, true))) {
            for (Producto p : inventario) {
                // Escribir cada producto en una línea del archivo, separados por comas
                String linea = p.getidProducto() + "," + p.getnombreProducto() + "," + p.getcategoria() + ","
                        + p.getprecio() + "," + p.getcantidadDisponible();
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Se agrega nuevo producto, ingrese Enter para regresar al menu principal");
            System.in.read();
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Metodo para actualizar el archivo
    public void actualizarArchivo() {
        System.out.println("Vas actualizar un producto existente, presiona Enter para iniciar");
        ingresar.nextLine();
        System.out.println("Ingresa el IdProducto para actualizar:");
        String idProductoActualizar = ingresar.nextLine();
        inventario = cargueInventario();
        for (Producto c : inventario) {
            if (c.getidProducto().equals(idProductoActualizar)) {
                System.out.println("Id del producto fue encontrado en el inventario, presione Enter para agregadar los datos de la actualización");
                ingresar.nextLine();
                System.out.println("Ingresa nuevo precioAct");
                int precioAct = ingresar.nextInt();
                System.out.println("cantidadDisponibleAct");
                int cantidadDisponibleAct = ingresar.nextInt();
                c.setPrecio(precioAct);
                c.setcantidadDisponible(cantidadDisponibleAct);
            }
        }
        reescribirInventario(inventario);
    }

    //Metodo actualiza el archivo con la actualización realizada
    public static void reescribirInventario(List<Producto> producto) {
        String RutaArchivo = "D:\\Capitulo Programación basica\\TallerFinal\\Data.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RutaArchivo))) {
            for (Producto p : producto) {
                // Escribir cada producto en una línea del archivo, separados por comas
                String linea = p.getidProducto() + "," + p.getnombreProducto() + "," + p.getcategoria() + ","
                        + p.getprecio() + "," + p.getcantidadDisponible();
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Se actualiza el inventario correctamente, ingrese Enter para regresar al menu principal");
            System.in.read();
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    //Metodo de eliminar un producto del inventario
    public void eliminarProducto() {
        System.out.println("Vas eliminar un producto del inventario, presiona Enter para iniciar");
        ingresar.nextLine();
        System.out.println("Ingresa el idProducto que deseas eliminar");
        String idProducto = ingresar.nextLine();
        inventario = cargueInventario();
        inventario.removeIf(p -> p.getidProducto().equals(idProducto));
        reescribirInventario(inventario);
    }

    //Metodo para buscar por categoria
    public void buscarPorCategoria() {
        System.out.println("Ingresa la categoria a Buscar");
        String cat = ingresar.nextLine();
        inventario = cargueInventario();
        int contador = 0;
        for (Producto c : inventario) {
            if (c.getcategoria().equals(cat)) {
                System.out.println("Los productos con esa categoria son: " + c.getnombreProducto());
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("Esta categoria no existe en este inventario");
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("presione Enter para salir al menu principal");
        ingresar.nextLine();
    }

    //Metodo para buscar por nombre
    public void buscarPorNombre() {
        System.out.println("Ingresa el nombre a Buscar");
        String cat = ingresar.nextLine();
        inventario = cargueInventario();
        int contador = 0;
        for (Producto c : inventario) {
            if (c.getnombreProducto().equals(cat)) {
                System.out.println("Los productos con ese nombre son: " + c.getidProducto() + "," + c.getnombreProducto() + "," + c.getcategoria() + ","
                        + c.getprecio() + "," + c.getcantidadDisponible());
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("Esta nombre no existe en este inventario");
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("presione Enter para salir al menu principal");
        ingresar.nextLine();
    }

    //Metodo para buscar por id producto
    public void buscarPorIdProducto() {
        System.out.println("Ingresa el Id del producto a Buscar");
        String cat = ingresar.nextLine();
        inventario = cargueInventario();
        int contador = 0;
        for (Producto c : inventario) {
            if (c.getidProducto().equals(cat)) {
                System.out.println("Los productos con ese Id de producto son: " + c.getidProducto() + "," + c.getnombreProducto() + "," + c.getcategoria() + ","
                        + c.getprecio() + "," + c.getcantidadDisponible());
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("Esta id de producto no existe en este inventario");
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("presione Enter para salir al menu principal");
        ingresar.nextLine();
    }

    //Metodo para validar el producto con mayor valor
    public void mayorValor() {
        inventario = cargueInventario();
        int valorAlto = 0;
        String Pro = "VACIO";
        for (Producto c : inventario) {
            if (c.getprecio() > valorAlto) {
                valorAlto = c.getprecio();
                Pro = c.getnombreProducto();
            }
        }
        System.out.println("El producto con mayor valor es: " + Pro);
        System.out.println("-----------------------------------------");
        System.out.println("presione Enter para salir al menu principal");
        ingresar.nextLine();
    }

    //Metodo para validar cantidad de productos por categoria
    public Map<String, Integer> cantidadPorCategoria() {

        Map<String, Integer> cantidadPorCategoria = new HashMap<>();

        for (Producto d : cargueInventario()) {
            String categoria = d.getcategoria();
            int cantidad = d.getcantidadDisponible();

            // Sumar la cantidad al total de la categoría correspondiente
            cantidadPorCategoria.put(categoria, cantidadPorCategoria.getOrDefault(categoria, 0) + cantidad);
        }
        return cantidadPorCategoria;
    }

    //Metodo para Reporte
    public void reporte (){
        inventario = cargueInventario();
        String RutaArchivo = "D:\\Capitulo Programación basica\\TallerFinal\\Reporte.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RutaArchivo))) {
            Map<String, Integer> cantidadPorCategoria = new HashMap<>();
            bw.write("""
                        ----------------------------------------------------
                        -             Reporte de inventario                -
                        ----------------------------------------------------
                        Fecha de generación:""" + new Date());
            bw.newLine();
            bw.write("----------------------------------------------------");
            bw.newLine();
            int valorTotal = 0;
            for (Producto p : inventario) {
                String linea = p.getidProducto() + "," + p.getnombreProducto() + "," + p.getcategoria() + ","
                        + p.getprecio() + "," + p.getcantidadDisponible();
                bw.write(linea);
                bw.newLine();
                valorTotal += p.getprecio() * p.getcantidadDisponible();
            }
            for (Producto d : inventario) {
                String categoria = d.getcategoria();
                int cantidad = d.getcantidadDisponible();

                // Sumar la cantidad al total de la categoría correspondiente
                cantidadPorCategoria.put(categoria, cantidadPorCategoria.getOrDefault(categoria,0) + cantidad);
            }
            bw.write("----------------------------------------------");
            bw.newLine();
            bw.write("Total productos por categoria");
            bw.newLine();
            bw.write(cantidadPorCategoria.toString());
            bw.newLine();
            bw.write("Valor total del inventario: " + valorTotal);
            System.out.println("Se genera reporte en la ruta: D:\\Capitulo Programación basica\\TallerFinal\\Reporte.txt , ingrese Enter para regresar al menu principal");
            System.in.read();
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }

    }
}

