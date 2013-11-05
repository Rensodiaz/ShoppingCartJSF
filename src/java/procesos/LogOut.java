/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procesos;

import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Renso
 */
@Named("logout")
@ViewScoped
public class LogOut {
    
    public String logout(){
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.getExternalContext().getSessionMap().clear();
        return "index?faces-redirect=true";
    }
}
