/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 *
 * @author Viraji
 */
@Entity
public class CustomerEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="CustomerID")  
    private Long id;
    
    @Column(name = "Name")
    private String Name;
    
    @Column(name = "Address")
    private String Address;
    
    @Column(name = "ContactNo")
    private String ContactNo;
    
    @OneToMany(mappedBy = "Customer")
    private Set<OrdersEntity> orders;

    public Set<OrdersEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrdersEntity> orders) {
        this.orders = orders;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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
        if (!(object instanceof CustomerEntity)) {
            return false;
        }
        CustomerEntity other = (CustomerEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.CustomerEntity[ id=" + id + " ]";
    }
    
}
