/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import entidades.Productos;
import entidades.Usuarios;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Renso
 */
@WebListener
public class Listener implements ServletContextListener{

    @PersistenceContext(unitName = "practica6_20090133PU")
    private EntityManager DB;
    @Resource
    private javax.transaction.UserTransaction utx;
    
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Usuarios user = new Usuarios();
        Productos p = new Productos();
        Productos p2 = new Productos();
       // System.out.println("entre aquiiiiii!!!!!!!!!!!!!");
        try{
            
            user.setUsuarioid("admin");
            user.setNombre("admin");            
            user.setApellido("papa");
            user.setClave("admin");
            
            p.setNombre("camisa");
            p.setCantidadExistencia(5);
            p.setDescripcion("camisa negra mangas cortas");
            p.setPrecioVenta(50);
            
            p2.setNombre("pantalon");
            p2.setCantidadExistencia(10);
            p2.setDescripcion("pantalones largos");
            p2.setPrecioVenta(100);
            
            utx.begin();
            DB.persist(p);
            DB.persist(p2);
            DB.persist(user);
            utx.commit();
        }catch(Exception ex){
            System.out.println("ENTRE AL LISTENER AQUI!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            ex.printStackTrace();
        }
        
        }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       }
    
}