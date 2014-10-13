package ejb;

import ejb.OrdersEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-08-02T08:12:40")
@StaticMetamodel(CustomerEntity.class)
public class CustomerEntity_ { 

    public static volatile SingularAttribute<CustomerEntity, Long> id;
    public static volatile SingularAttribute<CustomerEntity, String> Name;
    public static volatile SingularAttribute<CustomerEntity, String> Address;
    public static volatile SetAttribute<CustomerEntity, OrdersEntity> orders;
    public static volatile SingularAttribute<CustomerEntity, String> ContactNo;

}