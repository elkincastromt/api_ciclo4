package com.usa.ciclo4.app.services;

import com.usa.ciclo4.app.model.Order;
import com.usa.ciclo4.app.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id){
        return orderRepository.getOrderById(id);
    }

    public List<Order> getOrderByZone(String zone){
        return orderRepository.getOrderByZone(zone);
    }

    public List<Order> getOrderBySalesManId(Integer id){
        return orderRepository.getOrderBySalesManId(id);
    }

    public List<Order> ordersSalesManByState(String state, Integer id){
        return orderRepository.ordersSalesManByState(state, id);
    }

    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
        return orderRepository.ordersSalesManByDate(dateStr,id);
    }

    public Order save(Order o){

        Optional<Order> orderIdMax = orderRepository.lastOrderId();

        if(o.getId()==null){
            if (orderIdMax.isEmpty())
                o.setId(1);
            else
                o.setId(orderIdMax.get().getId() + 1);
        }

        if(o.getId()==null){
            return orderRepository.save(o);
        }else{
            Optional<Order> paux=orderRepository.getOrderById(o.getId());
            if(paux.isEmpty()){
                return orderRepository.save(o);
            }else{
                return o;
            }
        }
    }

    public Order update(Order o) {
        if (o.getId() != null) {
            Optional<Order> orderExist = orderRepository.getOrderById(o.getId());

            if (orderExist.isPresent()) {
                if (o.getStatus() != null) {
                    orderExist.get().setStatus(o.getStatus());
                }
                return orderRepository.save(orderExist.get());
            } else {
                return o;
            }
        } else {
            return o;
        }
    }

    public boolean deleteById(Integer id) {
        Boolean aBoolean = orderRepository.getOrderById(id).map(order -> {
            orderRepository.deleteById(id);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}