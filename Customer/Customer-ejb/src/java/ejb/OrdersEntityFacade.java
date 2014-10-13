/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Viraji
 */
@Stateless
public class OrdersEntityFacade extends AbstractFacade<OrdersEntity> {
    @PersistenceContext(unitName = "Customer-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersEntityFacade() {
        super(OrdersEntity.class);
    }
    
}
