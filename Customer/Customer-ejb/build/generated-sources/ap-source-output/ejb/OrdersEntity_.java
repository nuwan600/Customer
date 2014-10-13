package ejb;

import ejb.CustomerEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-02T08:12:40")
@StaticMetamodel(OrdersEntity.class)
public class OrdersEntity_ { 

    public static volatile SingularAttribute<OrdersEntity, Long> id;
    public static volatile SingularAttribute<OrdersEntity, Double> amount;
    public static volatile SingularAttribute<OrdersEntity, String> comment;
    public static volatile SingularAttribute<OrdersEntity, CustomerEntity> customer;
    public static volatile SingularAttribute<OrdersEntity, String> dueDate;

}