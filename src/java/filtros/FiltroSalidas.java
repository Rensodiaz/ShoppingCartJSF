/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtros;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import procesos.CrearSesion;

/**
 *
 * @author Renso
 */
public class FiltroSalidas implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ESTOY EN EL FILTER!!!!!!!!!!!!!!!"); //To change body of generated methods, choose Tools | Templates.
    }
    @Inject
    private CrearSesion userSesion;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        
        System.out.println("ENTRE DESPUES DE VERIFICAR"+userSesion.getUser());
        if (userSesion.getUser()!=null) { 
            System.out.println("ENTRE DESPUES DE VERIFICAR2222222222222");
            chain.doFilter(request, response);
        } else {
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect("./index.xhtml");
        }
    }
    @Override
    public void destroy() {
        System.out.println("SALI DEL FILTER!!!!!!!!!!!!!!!"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
