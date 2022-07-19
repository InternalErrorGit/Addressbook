package net.internalerror.addressbook.controller.data;

import lombok.*;
import net.internalerror.addressbook.data.entity.City;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddressModel {
    private City city;

    private String street;

    private String housenumber;

    private String cityId;


}
