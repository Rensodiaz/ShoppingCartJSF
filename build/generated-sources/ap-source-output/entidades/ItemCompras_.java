package entidades;

import entidades.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-02T10:34:02")
@StaticMetamodel(ItemCompras.class)
public class ItemCompras_ { 

    public static volatile SingularAttribute<ItemCompras, Long> id;
    public static volatile SingularAttribute<ItemCompras, Integer> cantidad;
    public static volatile SingularAttribute<ItemCompras, Productos> producto;

}