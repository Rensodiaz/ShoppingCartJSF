/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entidades.CarritoCompras;
import entidades.ItemCompras;
import entidades.Productos;
import entidades.Usuarios;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import procesos.CrearSesion;

/**
 *
 * @author Renso
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class MiEjb {
    
    @PersistenceContext(unitName = "practica6_20090133PU")
    private EntityManager DB;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    /*v
     * Login de los usuarios
     */    
    public Usuarios login(String usuarioId, String password) {
        //System.out.println("estoy en el EJB!!!!!!!!!!!1111111111111");
        Usuarios usuario = new Usuarios();
        //Long id = Long.parseLong(usuarioId);
        
        String consulta = "SELECT u FROM Usuarios u where u.usuarioid=?1 and u.clave='"+password+"'";
        //System.out.println("estoy en el EJB!!!!!!!!!!!33333333333");
        Query query = DB.createQuery(consulta);
        //System.out.println("estoy en el EJB!!!!!!!!!!!4444444444444");
        query.setParameter(1,usuarioId);
        
        try{
            
            usuario = (Usuarios) query.getSingleResult();
            //System.out.println("estoy en el EJB!!!!!!!!!!!555555555555555"+usuario.getNombre());
            return usuario;
            
        }catch(Exception ex){
            //ex.printStackTrace();
            usuario.setNombre("no");
            return usuario;
        }
        
    }
    
    /*
     * creacion de cuenta del usuario
     */
    public Usuarios crearCuenta(String usuarioId, String nombre, String apellido, String clave){
        
        List<Usuarios> users = new ArrayList();
        Usuarios user = new Usuarios();
        int c = 0;
        
        String jpql = "SELECT u FROM Usuarios u";
        Query query = DB.createQuery(jpql);
        users = query.getResultList();
        
        
        for(int i =0 ; i<users.size(); i++){
            if(users.get(i).getUsuarioid().equals(usuarioId)){
                user.setUsuarioid("esta");
                user.setNombre("esta");       
                user.setApellido("esta");
                user.setClave("esta");
                c=1;
                break;
            }
        }
        if(c==1){
            return user;
        }else{
            user.setUsuarioid(usuarioId);
            user.setNombre(nombre);
            user.setApellido(apellido);
            user.setClave(clave);
            
            //users.add(user);
            
            try{

                utx.begin();
                DB.persist(user);        
                utx.commit();
                return user;

            }catch(Exception ex){
                ex.printStackTrace();
                user.setUsuarioid("no");
                user.setNombre("no");            
                user.setApellido("no");
                user.setClave("no");
                return user;
            }        
        }        
        
    }
    
    /*
     * productos disponibles
     */
    public List<Productos> productos(){
        
        List<Productos> items = new ArrayList();
        //System.out.println("entre aqui a los productos");
        try{
            
            String sentencia = "SELECT p FROM Productos p";
            Query query = DB.createQuery(sentencia);
            items = query.getResultList();
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return items;
    }
    
    /*
     * Disponibilidad de productos
     */
    public boolean diponibilidad(int cty, Productos pro){
        
       // System.out.println("Este es Mi nombre++++++: "+cty);
        try{
            String sentencia = "SELECT p FROM Productos p where p.id=?1";
            Query query = DB.createQuery(sentencia);
            query.setParameter(1, pro.getId());
            pro = (Productos)query.getSingleResult();            
            
            if(cty<=pro.getCantidadExistencia()){
                
                return true;
            }else{
                return false;
            }
            
        }
        catch(Exception ex){
            ex.printStackTrace();            
            return true;
        }        
    }
    
    public boolean checkOut(CrearSesion datos){
        
        Productos productoDB = new Productos();
        CarritoCompras cartVendido = new CarritoCompras();
        
        for(ItemCompras i : datos.getUserCart().getListaItemCompra()){
            if(!diponibilidad(i.getCantidad(), i.getProducto())){
                return false;
            }
            else{                
                try{
                    
                    //Aqui lo busco en la BD y le cambio el valor de la cantidad
                    Productos p = DB.find(Productos.class, i.getProducto().getId());
                    
                    p.setCantidadExistencia(p.getCantidadExistencia()- i.getCantidad());
                    
                    utx.begin();
                    DB.merge(p);
                    utx.commit();                               
                }
                catch(Exception ex){
                   ex.printStackTrace();
                }
            }
        }
        
        //total vendido
        double monto=0;
        for(ItemCompras i : datos.getUserCart().getListaItemCompra()){
            monto = monto+(i.getProducto().getPrecioVenta()*i.getCantidad());
        }
        System.out.println("aqui me quede");
        cartVendido.setUsuario(datos.getUser());
        cartVendido.setListaItemCompra(datos.getUserCart().getListaItemCompra());
        cartVendido.setFechaVenta(new Date());
        cartVendido.setTotal(monto);
        try{    
        
            utx.begin();
            DB.persist(cartVendido);    
            utx.commit();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return true;
    }
    
    /*
     * historial de todas las ventas
     */
    public List<CarritoCompras> historial(){
        
        List<CarritoCompras> datos = new ArrayList();
        
         try{
            String sentencia = "SELECT h FROM CarritoCompras h";
            Query query = DB.createQuery(sentencia);            
            datos = query.getResultList();            
            
            return datos;
         }
         catch(Exception ex){
            ex.printStackTrace();            
            return datos;
        }        
    }
    
    /*
     * Insertar producto en la base de datos
     */
    public boolean agregarProducto(String nombre, String desc, String cant, String precio){
        Productos p = new Productos();
        int c = Integer.parseInt(cant);
        double pre = Double.parseDouble(precio);
        
        //Aqui lo busco en la BD y le cambio el valor de la cantidad        
        p.setNombre(nombre);
        p.setDescripcion(desc);
        p.setCantidadExistencia(c);
        p.setPrecioVenta(pre);
        
        try{        
            utx.begin();
            DB.persist(p);    
            utx.commit();
        }
        catch(Exception ex){
            return false;
        }
        
        return true;
    }
}
