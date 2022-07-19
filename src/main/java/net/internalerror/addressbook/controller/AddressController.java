package net.internalerror.addressbook.controller;

import net.internalerror.addressbook.controller.data.AddressModel;
import net.internalerror.addressbook.data.service.AddressService;
import net.internalerror.addressbook.data.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AddressController {

    private final AddressService addressService;
    private final CityService cityService;

    public AddressController(AddressService addressService, CityService cityService) {
        this.addressService = addressService;
        this.cityService = cityService;
    }

    @GetMapping("/get-addresses")
    public String getAddresses(Model model){
        model.addAttribute("addresses", addressService.read());
        model.addAttribute("addressPreset", new AddressModel());
        model.addAttribute("cities", cityService.read());
        return "city";
    }

    @PostMapping("/add-address")
    public String addAddress(Model model, @ModelAttribute @Valid AddressModel address){

        //addressService.create(address);


        return "redirect:/get-addresses";
    }
}
