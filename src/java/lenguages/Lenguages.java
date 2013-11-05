/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lenguages;

import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Renso
 */
@Named("lenguage")
@SessionScoped
public class Lenguages implements Serializable{
    
     private String locale = Locale.getDefault().getDisplayLanguage();

      public void setLocale(String locale1) {
        this.locale = locale1;
      }

      public synchronized String getLocale() {
        return locale;
      }

      public synchronized String changeLanguage() {
        return "";
      }
}
