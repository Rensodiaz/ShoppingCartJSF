/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Renso
 */
@Table(name="productos")
@Entity
public class Productos implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private String descripcion;
    private int cantidadExistencia;
    private double precioVenta;
   
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
    /**
    * @return the cantidadExistencia
    */
    public int getCantidadExistencia() {
        return cantidadExistencia;
    }
    /**
    * @param cantidadExistencia the cantidadExistencia to set
    */
    public void setCantidadExistencia(int cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }
    /**
    * @return the precioVenta
    * 
    */
    public double getPrecioVenta() {
        return precioVenta;
    }
    /**
    * @param precioVenta the precioVenta to set
    */
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
