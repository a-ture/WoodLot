package it.unisa.WoodLot.web.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller root che ridereziona alla GUI di Swagger
 */
@RestController
@RequestMapping("/")
public class RootController {


    @RequestMapping("/")
    public String rootMap(){
        return "Woodlot";
    }



}