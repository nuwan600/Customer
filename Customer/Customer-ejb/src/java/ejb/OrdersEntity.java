/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Viraji
 */
@Entity
public class OrdersEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_NO")
    private Long id;
        
    @Column(name = "Amount")
    private double amount;
    
    @Column(name = "Comment")
    private String comment;
    
    @Column(name = "DueDate")
    private String dueDate;
    
    @ManyToOne
    @JoinColumn(name = "CUS_ORDER", referencedColumnName = "CustomerID")
    private CustomerEntity customer;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdersEntity)) {
            return false;
        }
        OrdersEntity other = (OrdersEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.OrdersEntity[ id=" + id + " ]";
    }
    
}
