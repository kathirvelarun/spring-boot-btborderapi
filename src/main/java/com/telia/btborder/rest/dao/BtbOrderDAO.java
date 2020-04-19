package com.telia.btborder.rest.dao;

import org.springframework.stereotype.Repository;

import com.telia.btborder.rest.model.BtbOrder;
import com.telia.btborder.rest.model.BtbOrders;

@Repository
public class BtbOrderDAO 
{
    private static BtbOrders list = new BtbOrders();
    
    static 
    {
        list.getBtbOrderList().add(new BtbOrder(1, "Rod", "Johnson", "spring@gmail.com", "Btb Order"));
        list.getBtbOrderList().add(new BtbOrder(2, "James", "Goshling", "spring@gmail.com", "Btb Order"));
        list.getBtbOrderList().add(new BtbOrder(3, "Yann", "Carrdd", "spring@gmail.com", "Btb Order"));
    }
    
    public BtbOrders getAllBtbOrders() 
    {
        return list;
    }
    
    public void addEmployee(BtbOrder employee) {
        list.getBtbOrderList().add(employee);
    }
}
