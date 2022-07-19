package net.internalerror.addressbook.data.entity;

import lombok.*;
import net.internalerror.addressbook.data.util.AEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "address")
public class Address extends AEntity {
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    @NotNull(message = "Attribute city cannot be null")
    private City city;

    @Column(name = "street", nullable = false)
    @NotNull(message = "Attribute street cannot be null")
    @Size(min = 3, max = 255, message = "Attribute street length has to be 3 - 255")
    private String street;

    @Column(name = "housenumber", nullable = false, length = 15)
    @NotNull(message = "Attribute housenumber cannot be null")
    @Size(min = 1, max = 15, message = "Attribute housenumber length has to be 1 - 15")
    private String housenumber;

    @Override
    public boolean filter(String filter) {
        return city.filter(filter) || street.contains(filter) || housenumber.contains(filter) || super.filter(filter);
    }
}
