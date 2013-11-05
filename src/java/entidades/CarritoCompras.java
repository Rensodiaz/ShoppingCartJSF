/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Renso
 */
@Table(name="carritoCompras")
@Entity
public class CarritoCompras implements Serializable{
     
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;    
   
    @OneToOne
    private Usuarios usuario;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ItemCompras> listaItemCompra;
    private double total;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaVenta;
    /**
    * @return the usuarios
    */
    public Usuarios getUsuario() {
        return usuario;
    }
    /**
    * @param usuario the usuarios to set
    */
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    /**
    * @return the listaItemCompra
    */
    public List<ItemCompras> getListaItemCompra() {
        return listaItemCompra;
    }
    /**
    * @param listaItemCompra the listaItemCompra to set
    */
    public void setListaItemCompra(List<ItemCompras> listaItemCompra) {
        this.listaItemCompra = listaItemCompra;
    }
    /**
    * @return the fechaVenta
    */
    public Date getFechaVenta() {
        return fechaVenta;
    }
    /**
    * @param fechaVenta the fechaVenta to set
    */
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
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
