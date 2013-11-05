/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Renso
 */

@Table(name="itemCompras")
@Entity
public class ItemCompras implements Serializable{
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Productos producto;
    private int cantidad;
    /**
    * @return the producto
    */
    public Productos getProducto() {
        return producto;
    }
    /**
    * @param producto the producto to set
    */
    public void setProducto(Productos producto) {
        this.producto = producto;
    }
    /**
    * @return the cantidad
    */
    public int getCantidad() {
        return cantidad;
    }
    /**
    * @param cantidad the cantidad to set
    * 
    */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
