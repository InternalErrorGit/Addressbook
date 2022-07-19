package net.internalerror.addressbook.data.entity;

import lombok.*;
import net.internalerror.addressbook.data.util.AEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "person")
public class Person extends AEntity {
    @Column(name = "firstname", nullable = false)
    @Size(min = 3, max = 255, message = "Attribute firstname length has to be 3 - 255")
    private String firstname;

    @Column(name = "lastname", nullable = false)
    @Size(min = 3, max = 255, message = "Attribute lastname length has to be 3 - 255")
    private String lastname;

    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = true)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Override
    public boolean filter(String filter) {
        return firstname.contains(filter) || lastname.contains(filter) || contact.filter(filter) || address.filter(filter) || super.filter(filter);
    }
}
