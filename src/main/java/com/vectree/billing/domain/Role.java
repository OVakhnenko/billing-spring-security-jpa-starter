package com.vectree.billing.domain;

import lombok.Data;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Roles of User.
 *
 * @version 0.1.
 */
@Entity
@Table(name = "roles")
@Data
public class Role {

    /**
     * Unique per role number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billingSequence")
    @SequenceGenerator(sequenceName = "billing_sequence", allocationSize = 1, name = "billingSequence")
    private Long id;

    /**
     * Name of the role.
     */
    @Column(name = "name")
    private String name;

    /**
     * Users with the roles.
     */
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<User> users;

    public Role() {
        this.name = "";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Role role = (Role) obj;
        return id.equals(role.getId())
                && name.equals(role.getName());
    }

    @Override
    public int hashCode() {
        return id.intValue() + name.hashCode();
    }

    @Override
    public String toString() {
        return "Role {" +
                "id=" + id +
                ", name='" + name + "}";
    }
}
