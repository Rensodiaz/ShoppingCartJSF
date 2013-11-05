/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import ejb.MiEjb;
import entidades.CarritoCompras;
import entidades.Usuarios;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renso
 */
@Named("login")
@RequestScoped
public class Login implements Serializable{
    
    @NotBlank
    @NotNull
    private String usuarioID;   
    @NotBlank
    @NotNull
    private String password;
    
    private String mensaje;
    
    @Inject 
    private CrearSesion userSesion;
    
    @EJB
    private MiEjb miEjb;
     
    public String logear(){      
                
        userSesion.setUser(miEjb.login(getUsuarioID(), getPassword()));
        //System.out.println("mi nombre en login es: "+getUsuarioID());
        if(userSesion.getUser().getNombre().equals("no")){ 
            
            setMensaje("*Nombre de Usuario o Contrasena incorrectos.");            
            return "";           
        }else{
            return "productosDisponibles?faces-redirect=true";          
        }
    }

    /**
     * @return the usuarioID
     */
    public String getUsuarioID() {
        return usuarioID;
    }

    /**
     * @param usuarioID the usuarioID to set
     */
    public void setUsuarioID(String usuarioID) {
        this.usuarioID = usuarioID;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
}
