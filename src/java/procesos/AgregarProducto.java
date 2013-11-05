/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import ejb.MiEjb;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renso
 */
@ManagedBean(name="agregarProducto")
@RequestScoped
public class AgregarProducto implements Serializable{
    
    @EJB
    private MiEjb miEjb;
    
    @NotBlank
    @NotNull
    private String nombre;
    @NotBlank
    @NotNull
    private String cantidad;
    @NotBlank
    @NotNull
    private String precio;
    @NotBlank
    @NotNull
    private String descripcion;
    
    public String agregar(){        
        
        System.out.println("datos: "+nombre+" datos2: "+cantidad+" datos3: "+precio+" datos4: "+descripcion);
        if(miEjb.agregarProducto(nombre, descripcion, cantidad, precio)){
            return "productosDisponibles?faces-redirect=true";
         }else
            return "";
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
