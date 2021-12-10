package com.usa.ciclo4.app.controllers;

import com.usa.ciclo4.app.model.Order;
import com.usa.ciclo4.app.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrderController {

    @Autowired
    private OrderService OrderService;

    @GetMapping("/all")
    public List<Order> getOrders(){
        return OrderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id){
        return OrderService.getOrder(id);
    }

    @GetMapping("/zona/{zone}")
    public List<Order> getOrderByZone(@PathVariable("zone") String zone){
        return OrderService.getOrderByZone(zone);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order o){
        return OrderService.save(o);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order o){
        return OrderService.update(o);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return OrderService.deleteById(id);
    }

}
