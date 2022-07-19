package net.internalerror.addressbook.data.entity;

import lombok.*;
import net.internalerror.addressbook.data.util.AEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "contact")
public class Contact extends AEntity {
    @Column(name = "email", nullable = false)
    @Email(message = "Invalid email")
    private String email;

    @Column(name = "tel", nullable = false)
    private String tel;

    @Override
    public boolean filter(String filter) {
        return email.contains(filter) || tel.contains(filter) || super.filter(filter);
    }
}
