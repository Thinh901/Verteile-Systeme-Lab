package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Shopping;
import com.example.demo.Repository.ShoppingRepository;
import com.fasterxml.jackson.annotation.OptBoolean;

@Service
public class ShoppingService {

    @Autowired
    private ShoppingRepository shoppingRepo;

    public List<Shopping> getAllShoppingItems(){
        return shoppingRepo.findAll();
    }

    public Shopping createShoppingItem(Shopping shoppingItem){
        Shopping newShoppingItem = new Shopping();
        newShoppingItem.setDescription(shoppingItem.getDescription());
        newShoppingItem.setDone(shoppingItem.getDone());
        newShoppingItem.setTitle(shoppingItem.getTitle());
        return shoppingRepo.save(newShoppingItem);
    }

    public void deleteShoppingItem(Integer id){
        shoppingRepo.deleteById(id);
    }
    public void deleteAllShoppingItem(){
        shoppingRepo.deleteAll();
    }

    public Shopping updateShopping(Integer id, Shopping shopping){

        Shopping currentShoppingItem = shoppingRepo.findById(id).orElse(null);
        
        if(currentShoppingItem != null){
            currentShoppingItem.setDescription(shopping.getDescription());
            currentShoppingItem.setDone(shopping.getDone());
            currentShoppingItem.setTitle(shopping.getTitle());         
        }
        return shoppingRepo.save(currentShoppingItem);
    }
    
}
