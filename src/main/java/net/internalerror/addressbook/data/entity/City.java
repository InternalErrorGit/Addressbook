package net.internalerror.addressbook.data.entity;

import lombok.*;
import net.internalerror.addressbook.data.util.AEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "city")
public class City extends AEntity {
    @Column(name = "name", nullable = false, length = 50)
    @NotNull(message = "Attribute name cannot be null")
    @Size(min = 3, max = 255, message = "Attribute name length has to be 3 - 255")
    private String name;

    @Column(name = "zip", nullable = false, length = 10)
    @NotNull(message = "Attribute zip cannot be null")
    @Size(min = 1, max = 10, message = "Attribute zip length has to be 1 - 10")
    private String zip;

    @Override
    public boolean filter(String filter) {
        return name.contains(filter) || zip.contains(filter) || super.filter(filter);
    }

}
