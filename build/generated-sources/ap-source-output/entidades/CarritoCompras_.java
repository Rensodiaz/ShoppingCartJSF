package entidades;

import entidades.ItemCompras;
import entidades.Usuarios;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-02T10:34:02")
@StaticMetamodel(CarritoCompras.class)
public class CarritoCompras_ { 

    public static volatile SingularAttribute<CarritoCompras, Long> id;
    public static volatile SingularAttribute<CarritoCompras, Double> total;
    public static volatile SingularAttribute<CarritoCompras, Usuarios> usuario;
    public static volatile ListAttribute<CarritoCompras, ItemCompras> listaItemCompra;
    public static volatile SingularAttribute<CarritoCompras, Date> fechaVenta;

}