/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import ejb.MiEjb;
import entidades.CarritoCompras;
import entidades.ItemCompras;
import entidades.Productos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Renso
 */
@Named("productosDisponibles")
@ViewScoped
public class ProductosDisponibles implements Serializable{
        
    @EJB
    MiEjb miEjb;
    @Inject
    private Mensaje msg;
    
    private List<Productos> items;
    
    private String mensaje;    
        
    
    /*
     * llenar la lista de articulos
     */
    public List<Productos> listaProductos(){
        List<Productos> p = new ArrayList();
            
        for(Productos pro : miEjb.productos())
        {
            if(pro.getCantidadExistencia()>0){
                p.add(pro);
            }
        }
        return p;
    }    
    
    public String ProcesarAgregar(Productos pro, CrearSesion datos){        
                
        String cty = FacesContext.getCurrentInstance().
		getExternalContext().getRequestParameterMap().get("cantidadRequerida");
        
                      
        int entero = Integer.parseInt(cty);
        
        if(miEjb.diponibilidad(entero, pro)==true){
            List<ItemCompras> listaItems = new ArrayList();        
            ItemCompras item = new ItemCompras();
            //System.out.println("cantidad disponible: "+datos.getUserCart()+" cantidad convertida: "+entero);
            item.setProducto(pro);
            item.setCantidad(entero);            
            
            if(datos.getUserCart() == null){
                
                //System.out.println("cantida primer porducto: "+item.getCantidad()+" producto: "+item.getProducto().getNombre());
                datos.setUserCart(new CarritoCompras());
                listaItems.add(item);
                datos.getUserCart().setListaItemCompra(listaItems);
                
                msg.setMensaje("Agregado exitosamente.");
                return "";
            }else{
                //System.out.println("mierdaaaaaaaaaaaaa"+datos.getUserCart().getListaItemCompra());
                
                listaItems = datos.getUserCart().getListaItemCompra();
                for(int i=0; i<listaItems.size() ;i++){                    
                    if(listaItems.get(i).getProducto().getNombre().equals(pro.getNombre())){
                        int cnt = listaItems.get(i).getCantidad();
                        listaItems.get(i).setCantidad(entero+cnt);                
                        //System.out.println("cantidad de ese producto: "+listaItems.get(i).getCantidad()); 
                        msg.setMensaje("Agregado exitosamente.");
                        return "";
                    }
                }
                listaItems.add(item);
                datos.getUserCart().setListaItemCompra(listaItems);
                //System.out.println("mierdaaaaaaaaaaaaa");
                
                msg.setMensaje("Agregado exitosamente.");
                return "";              
            }            
        }else{
            msg.setMensaje("Cantidad deseada tiene que ser menor a la Disponible.");
            return "";
        }
    }
    /**
     * @return the items
     */
    public List<Productos> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<Productos> items) {
        //System.out.println("ENTRE EL BEAN DE PRODUCTOS!!!");
        this.items = items;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the msg
     */
    public Mensaje getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(Mensaje msg) {
        this.msg = msg;
    }
        
}
