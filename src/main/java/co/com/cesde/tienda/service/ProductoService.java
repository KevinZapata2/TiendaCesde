package co.com.cesde.tienda.service;

import co.com.cesde.tienda.dao.ProductoDao;
import co.com.cesde.tienda.modelo.ProductoModelo;

import java.util.Scanner;

public class ProductoService {

    Scanner sc = new Scanner(System.in);

    public void crearProducto(ProductoModelo pm){

        System.out.println("Ingrese el nombre del producto");
        String nombreProducto = sc.nextLine();
        System.out.println("Ingrese la cantidad del producto");
        double cantidad = sc.nextDouble();
        System.out.println("Ingrese el precio de venta:");
        double precio = sc.nextDouble();

        pm.setNombreProducto(nombreProducto);
        pm.setCantidad(cantidad);
        pm.setPrecio(precio);

        ProductoDao.crearProductoDB(pm);
    }


    public void consultarProducto(){

        ProductoDao.consultarProductoDB();
    }

    public void eliminarProducto(){

        System.out.println("Ingrese el id del producto a eliminar: ");
        int idProducto = sc.nextInt();

        ProductoDao.eliminarProductoDB(idProducto);

    }


    public void actualizarProducto( ProductoModelo pm){


        System.out.println("Actualizar 1: Nombre | 2: Cantidad | 3: Precio ");

        int opc = sc.nextInt();
        sc.skip("\n");

        if (opc == 1){

            System.out.println("Ingrese el nuevo nombre del producto:");
            String nuevoNombre= sc.nextLine();

            System.out.println("Indique el id del producto a actualizar: ");
            int idProducto= sc.nextInt();

            pm.setNombreProducto(nuevoNombre);
            pm.setIdProducto(idProducto);

            pm.setOpc(opc);

            ProductoDao.actualizarProductoDB(pm);
        }else if(opc==2){
            System.out.println("Ingrese la nueva cantidad de producto:");
            Double nuevaCantidad= sc.nextDouble();

            System.out.println("Indique el id del producto a actualizar: ");
            int idProducto= sc.nextInt();

            pm.setCantidad(nuevaCantidad);
            pm.setIdProducto(idProducto);

            pm.setOpc(opc);

            ProductoDao.actualizarProductoDB(pm);

        }else if(opc == 3){
            System.out.println("Ingrese el nuevo precio de producto:");
            Double nuevoPrecio= sc.nextDouble();

            System.out.println("Indique el id del producto a actualizar: ");
            int idProducto= sc.nextInt();

            pm.setPrecio(nuevoPrecio);
            pm.setIdProducto(idProducto);

            pm.setOpc(opc);

            ProductoDao.actualizarProductoDB(pm);
        }else{
            System.out.println("Ingrese una opción valida");
        }
    }
}
