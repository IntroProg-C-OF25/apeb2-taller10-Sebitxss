
import java.util.Scanner;


/**
 * Crea un programa que gestione el inventario de una tienda. 
 * Utiliza una matriz bidimensional para almacenar los productos disponibles en la tienda, con información como nombre, precio y cantidad. 
 * El programa debe permitir agregar nuevos productos, actualizar existencias, buscar productos y eliminarlos.
 * @author sebas
 */
public class problema4_Inventario {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        // Definir una matriz para almacenar los productos
        // Cada producto tiene: [Nombre, Precio, Cantidad]
        String[][] inventario = new String[100][3]; // Máximo 100 productos
        int numProductos = 0;

        int opcion;
        do {
            // Mostrar menú de opciones
            System.out.println("\n--- Gestión de Inventario ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar existencias");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Agregar producto
                    if (numProductos < inventario.length) {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el precio del producto: ");
                        String precio = scanner.nextLine();
                        System.out.print("Ingrese la cantidad del producto: ");
                        String cantidad = scanner.nextLine();

                        inventario[numProductos][0] = nombre;
                        inventario[numProductos][1] = precio;
                        inventario[numProductos][2] = cantidad;
                        numProductos++;

                        System.out.println("Producto agregado exitosamente.");
                    } else {
                        System.out.println("El inventario está lleno.");
                    }
                    break;

                case 2:
                    // Actualizar existencias
                    System.out.print("Ingrese el nombre del producto a actualizar: ");
                    String productoActualizar = scanner.nextLine();
                    boolean encontradoActualizar = false;

                    for (int i = 0; i < numProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(productoActualizar)) {
                            System.out.print("Ingrese la nueva cantidad: ");
                            inventario[i][2] = scanner.nextLine();
                            encontradoActualizar = true;
                            System.out.println("Cantidad actualizada exitosamente.");
                            break;
                        }
                    }

                    if (!encontradoActualizar) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    // Buscar producto
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String productoBuscar = scanner.nextLine();
                    boolean encontradoBuscar = false;

                    for (int i = 0; i < numProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(productoBuscar)) {
                            System.out.println("Producto encontrado:");
                            System.out.println("Nombre: " + inventario[i][0]);
                            System.out.println("Precio: $" + inventario[i][1]);
                            System.out.println("Cantidad: " + inventario[i][2]);
                            encontradoBuscar = true;
                            break;
                        }
                    }

                    if (!encontradoBuscar) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    // Eliminar producto
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String productoEliminar = scanner.nextLine();
                    boolean encontradoEliminar = false;

                    for (int i = 0; i < numProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(productoEliminar)) {
                            // Eliminar producto desplazando los elementos hacia la izquierda
                            for (int j = i; j < numProductos - 1; j++) {
                                inventario[j] = inventario[j + 1];
                            }
                            numProductos--;
                            encontradoEliminar = true;
                            System.out.println("Producto eliminado exitosamente.");
                            break;
                        }
                    }

                    if (!encontradoEliminar) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 5:
                    // Mostrar inventario
                    if (numProductos == 0) {
                        System.out.println("El inventario está vacío.");
                    } else {
                        System.out.println("\nInventario actual:");
                        for (int i = 0; i < numProductos; i++) {
                            System.out.println((i + 1) + ". Nombre: " + inventario[i][0] +
                                    ", Precio: $" + inventario[i][1] +
                                    ", Cantidad: " + inventario[i][2]);
                        }
                    }
                    break;

                case 6:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 6);
    }
}
