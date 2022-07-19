package net.internalerror.addressbook.controller;

import net.internalerror.addressbook.data.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/city")
    public String city(Model model, @RequestParam(name = "filter", required = false) String filter){
        model.addAttribute("filter", "cityService.read()");
        model.addAttribute("list", cityService.read());
        if(filter != null)
            model.addAttribute("list", cityService.filter(filter));
        return "city";
    }

}
