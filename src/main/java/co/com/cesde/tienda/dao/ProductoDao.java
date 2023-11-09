package co.com.cesde.tienda.dao;

import co.com.cesde.tienda.conexion.Conexion;
import co.com.cesde.tienda.modelo.ProductoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDao {

    public static void crearProductoDB(ProductoModelo pm){

        Conexion conexion = new Conexion();

        try(Connection connect = conexion.getConnectionDB()){

            PreparedStatement ps = null;

            try{
                String query = "INSERT INTO producto(nombre_producto, cantidad , precio)VALUES(?,?,?)";

                ps = connect.prepareStatement(query);
                ps.setString(1,pm.getNombreProducto());
                ps.setDouble(2,pm.getCantidad());
                ps.setDouble(3,pm.getPrecio());

                ps.executeUpdate();
                System.out.println("Se registro el producto correctamente");
            }catch (SQLException e ){
                System.out.println(e);
            }


        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void consultarProductoDB(){

        Conexion conexion = new Conexion();

        PreparedStatement ps = null;

        ResultSet rs = null;

        try(Connection connect = conexion.getConnectionDB()){

            String query = "SELECT * FROM producto";

            ps = connect.prepareStatement(query);

            rs = ps.executeQuery();

            while(rs.next()){

                System.out.println("Id del producto: " + rs.getInt("id_producto"));
                System.out.println("Nombre del Producto: " + rs.getString("nombre_producto"));
                System.out.println("Cantidad: " + rs.getDouble("cantidad"));
                System.out.println("Precio: " + rs.getDouble("precio"));
            }
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("No fue posible recuperar los registros");
        }

    }


    public static void eliminarProductoDB(int idProducto){

        Conexion conexion = new Conexion();


        try(Connection connect = conexion.getConnectionDB()){

            PreparedStatement ps = null;

            try{

                String query = "DELETE FROM producto WHERE productos.id_producto = ?";
                ps = connect.prepareStatement(query);

                ps.setInt(1,idProducto);
                ps.executeUpdate();
                System.out.println("Registro eliminado");
            }catch(SQLException e ){
                System.out.println(e);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }


    public static void actualizarProductoDB(ProductoModelo pm){

        Conexion conexion = new Conexion();

        try(Connection connect = conexion.getConnectionDB()){

            PreparedStatement ps = null;

            try{

                int opc = pm.getOpc();

                System.out.println(opc);

                if(opc == 1){

                    String query = "UPDATE producto SET nombre_producto = ? WHERE id_producto = ?";
                    ps = connect.prepareStatement(query);
                    ps.setString(1,pm.getNombreProducto());
                    ps.setInt(2, pm.getIdProducto());
                    ps.executeUpdate();
                    System.out.println("Se actualizo el registro exitosamente");
                }else if(opc==2){

                    String query = "UPDATE producto SET cantidad = ? WHERE id_producto = ?";
                    ps = connect.prepareStatement(query);
                    ps.setDouble(1,pm.getCantidad());
                    ps.setInt(2, pm.getIdProducto());
                    ps.executeUpdate();
                    System.out.println("Se actualizo el registro exitosamente");

                }else if(opc == 3){

                    String query = "UPDATE producto SET precio = ? WHERE id_producto = ?";
                    ps = connect.prepareStatement(query);
                    ps.setDouble(1,pm.getPrecio());
                    ps.setInt(2, pm.getIdProducto());
                    ps.executeUpdate();
                    System.out.println("Se actualizo el registro exitosamente");
                }

            }catch (SQLException e){

                System.out.println(e);
            }


        }catch (SQLException e){
            System.out.println(e);
        }

    }


}
