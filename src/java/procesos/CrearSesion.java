/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import ejb.MiEjb;
import entidades.CarritoCompras;
import entidades.ItemCompras;
import entidades.Productos;
import entidades.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Renso
 */
@Named("userSesion")
@SessionScoped
public class CrearSesion implements Serializable{
        
    private Usuarios user;
    private CarritoCompras userCart;
    
    @Inject
    private ProductosDisponibles productos;
    
    @EJB
    private MiEjb miEjb;    
       
    
    /*
     * Calcular monto total del carrito
     */
    public double montoTotal(){
        double monto=0;
        if(userCart != null){
            for(ItemCompras i : userCart.getListaItemCompra()){
                monto = monto+(i.getProducto().getPrecioVenta()*i.getCantidad());
            }
        }
        return monto;
    }
    
    /**
     * @return the user
     */
    public Usuarios getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Usuarios user) {
        this.user = user;
    }

    /**
     * @return the userCart
     */
    public CarritoCompras getUserCart() {
        return userCart;
    }

    /**
     * @param userCart the userCart to set
     */
    public void setUserCart(CarritoCompras userCart) {
        this.userCart = userCart;
    }

    /**
     * @return the productos
     */
    public ProductosDisponibles getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(ProductosDisponibles productos) {
        this.productos = productos;
    }
    
}
