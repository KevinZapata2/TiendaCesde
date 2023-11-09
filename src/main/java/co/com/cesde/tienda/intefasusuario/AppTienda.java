package co.com.cesde.tienda.intefasusuario;

import co.com.cesde.tienda.modelo.ProductoModelo;
import co.com.cesde.tienda.service.ProductoService;

import java.util.Scanner;

public class AppTienda {

    Scanner sc = new Scanner(System.in);
    ProductoService productoService= new ProductoService();
    ProductoModelo productoModelo = new ProductoModelo();

    public void menuApp() {

        int init = 1;

        System.out.println("Oprima 1 para iniciar la aplicacion:");

        init = sc.nextInt();

        do {
            System.out.println("Oprima 1 para iniciar la aplicacion:");

            init = sc.nextInt();

            System.out.println("1: Regristar producto\n" +
                    "2. Consultar producto\n" +
                    "3. Actualizar producto\n" +
                    "4. Eliminar Producto");

            int opc = sc.nextInt();


            switch (opc) {

                case 1:
                    System.out.println("Registar producto");
                    productoService.crearProducto(productoModelo);

                    break;
                case 2:
                    System.out.println("Consultar producto");
                    productoService.consultarProducto();
                    break;
                case 3:
                    System.out.println("Actualizar producto");
                    productoService.actualizarProducto(productoModelo);
                    break;
                case 4:
                    System.out.println("Eliminar Producto");
                    productoService.eliminarProducto();
                    break;
                case 5:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");


            }


        } while (init != 0);}

    }
