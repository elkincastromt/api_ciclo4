package com.usa.ciclo4.app.repositories;

import com.usa.ciclo4.app.model.Order;
import com.usa.ciclo4.app.repositories.crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public List<Order> getAll(){
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Order save(Order o){
        return orderCrudRepository.save(o);
    }

    public Optional<Order> getOrderById(Integer id){
        return orderCrudRepository.findById(id);
    }

    public List<Order> getOrderByZone(String zone){
        return orderCrudRepository.findByZone(zone);
    }

    public void deleteById (Integer id){
        orderCrudRepository.deleteById(id);
    }

    public Optional<Order> lastOrderId(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }

}
