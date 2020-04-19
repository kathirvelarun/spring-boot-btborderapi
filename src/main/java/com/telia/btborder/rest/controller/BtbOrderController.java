package com.telia.btborder.rest.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.telia.btborder.rest.dao.BtbOrderDAO;
import com.telia.btborder.rest.model.BtbOrder;
import com.telia.btborder.rest.model.BtbOrders;

@RestController
@RequestMapping(path = "/btborderapi")
public class BtbOrderController 
{
    @Autowired
    private BtbOrderDAO btbOrderDao;
    
    @GetMapping(path="/", produces = "application/json")
    public BtbOrders getEmployees() 
    {
        return btbOrderDao.getAllBtbOrders();
    }
    
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(
                        @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
                        @RequestHeader(name = "X-COM-LOCATION", required = false, defaultValue = "ASIA") String headerLocation,
                        @RequestBody BtbOrder employee) 
                 throws Exception 
    {       
        //Generate resource id
        Integer id = btbOrderDao.getAllBtbOrders().getBtbOrderList().size() + 1;
        employee.setId(id);
        
        //add resource
        btbOrderDao.addEmployee(employee);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.getId())
                                    .toUri();
        
        //Send location in response
        return ResponseEntity.created(location).build();
    }
}
