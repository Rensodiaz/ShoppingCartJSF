/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import ejb.MiEjb;
import entidades.Usuarios;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renso
 */
@Named("crearCuenta")
@RequestScoped
public class CrearCuenta implements Serializable{
    
    @EJB
    private MiEjb miEjb;
    
    @NotBlank
    @NotNull
    private String usuarioid;
    @NotBlank
    @NotNull
    private String nombre;
    @NotBlank
    @NotNull
    private String apellido;
    @NotBlank
    @NotNull
    private String clave;
    
    private String m;
    
    @Inject
    private CrearSesion userSesion;
    
    public String creacion(){
        //System.out.println("en crear cuenta mi nombre es: "+nombre);
        userSesion.setUser(miEjb.crearCuenta(usuarioid, nombre, apellido, clave));
        System.out.println("en crear cuenta mi clave es: "+clave);    
        if(userSesion.getUser().getNombre().equals("no")){
             m = "*Problemas en la creacion intente de nuevo.";
             return "crearCuenta?faces-redirect=true";
        }
        else if(userSesion.getUser().getUsuarioid().equals("esta")){
            m = "*UsuarioID ya existe seleccione otro.";
            return "crearCuenta?faces-redirect=true";
        }else{
            return "productosDisponibles?faces-redirect=true";
            
        }
        
    }

    /**
     * @return the usuarioid
     */
    public String getUsuarioid() {
        return usuarioid;
    }

    /**
     * @param usuarioid the usuarioid to set
     */
    public void setUsuarioid(String usuarioid) {
        this.usuarioid = usuarioid;
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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
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

    /**
     * @return the m
     */
    public String getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(String m) {
        this.m = m;
    }
    
}
