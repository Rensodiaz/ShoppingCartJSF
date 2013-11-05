/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import ejb.MiEjb;
import entidades.CarritoCompras;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Renso
 */
@Named("historialVentas")
@RequestScoped
public class HistorialVentas implements Serializable{
    
    @EJB
    private MiEjb miEjb;
    
    private List<CarritoCompras> datos;
    
    public List<CarritoCompras> historial(){
        datos = miEjb.historial();
        for(CarritoCompras c : datos)
            {
                System.out.println("mi carrito en historial: "+c.getFechaVenta());
            }
        return datos;
    }  

    /**
     * @return the datos
     */
    public List<CarritoCompras> getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(List<CarritoCompras> datos) {
        this.datos = datos;
    }
    
}
