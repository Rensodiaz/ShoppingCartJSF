/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import ejb.MiEjb;
import entidades.CarritoCompras;
import entidades.ItemCompras;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Renso
 */
@Named("checkOut")
@RequestScoped
public class CheckOut implements Serializable{
    
    private CrearSesion userSesion;
    private double montoTotal;
    
    private String m;
    
    @EJB
    private MiEjb miEjb;
    public String checkOut(CrearSesion datos){
        
        if(miEjb.checkOut(datos)){
            m = "Compra exitosa!";
            datos.getUserCart().getListaItemCompra().clear();
        }
        else{
            m = "Cantidad de uno de los productos no diponible.";
        }        
        return "productosDisponibles?faces-redirect=true";
    }
    
    
    /**
     * @return the userSesion
     */
    public CrearSesion getUserSesion() {
        return userSesion;
    }

    /**
     * @param userSesion the userSesion to set
     */
    public void setUserSesion(CrearSesion userSesion) {
        this.userSesion = userSesion;
    }

    /**
     * @return the montoTotal
     */
    public double getMontoTotal() {
        return montoTotal;
    }

    /**
     * @param montoTotal the montoTotal to set
     */
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * @return the m
     */
    public String getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(String m) {
        this.m = m;
    }
    
}
