package com.db.controllers;

import com.db.models.Shop;
import com.db.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;
    Shop shop = new Shop();

    @RequestMapping(value = "/all", method=RequestMethod.GET, produces = "application/json")
    public List<Shop> getAll() {
        return shopService.getAll();
    }

    @RequestMapping(method=RequestMethod.POST, produces = "application/json", consumes="application/json")
    public Shop create(@RequestBody String payload) { return shopService.create(shop.fromJson(payload)); }
    //@RequestMapping(method=RequestMethod.POST, produces = "application/json")
    //public String create(@RequestBody String payload) { return shopService.create(shop.fromJson(payload)).toJson(); }

    @RequestMapping(value = "/nearby", method=RequestMethod.POST, produces = "application/json")
    public List<Shop> nearBy(@RequestBody String payload) throws IOException {
        return shopService.nearBy(shop.fromJson(payload));
    }

    /*@RequestMapping(method=RequestMethod.PUT, value="{id}")
    public Shop update(@PathVariable String id, @RequestBody Shop location) {
        return null;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void delete(@PathVariable String id) {
    }*/
}