package com.telia.btborder.rest.model;

import java.util.ArrayList;
import java.util.List;

public class BtbOrders 
{
    private List<BtbOrder> btbOrderList;
    
    public List<BtbOrder> getBtbOrderList() {
        if(btbOrderList == null) {
        	btbOrderList = new ArrayList<>();
        }
        return btbOrderList;
    }
 
    public void setBtbOrderList(List<BtbOrder> btbOrderList) {
        this.btbOrderList = btbOrderList;
    }
}
