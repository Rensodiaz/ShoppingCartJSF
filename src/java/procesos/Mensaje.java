/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Renso
 */
@Named("mensaje")
@ViewScoped
public class Mensaje implements Serializable{
    
    private String mensaje;

    /**
     * @return the mensaje
     */
    public String m(){
        
       return "";
    }
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
