package co.com.cesde.tienda.service;

import co.com.cesde.tienda.modelo.ProductoModelo;

public class TestService {


    public static void main(String[] args) {


        ProductoModelo pm = new ProductoModelo();
        ProductoService ps = new ProductoService();

        //ps.crearProducto(pm);
        ps.consultarProducto();
        //ps.eliminarProducto();
        ps.actualizarProducto(pm);
        ps.consultarProducto();


    }




}
