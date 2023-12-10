package com.example.Shoppinglist.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Shoppinglist.Model.Shopping;
import com.example.Shoppinglist.Service.ShoppingService;
import org.springframework.web.bind.annotation.CrossOrigin;



@RestController
@CrossOrigin(origins = "*")
public class ShoppingController {
    
    private final Logger logger=LoggerFactory.getLogger(ShoppingController.class);

    @Autowired
    private ShoppingService shoppingService;


    @GetMapping("/shopping")
    ResponseEntity<List<Shopping>> getAllShoppingItems(){
        logger.info("Get all");
        return new ResponseEntity<>(shoppingService.getAllShoppingItems(),HttpStatus.OK);
    }


    @PostMapping("/shopping")
    ResponseEntity<Shopping> createShoppingItem(@RequestBody Shopping shopping){
        Shopping createdShoppingItem = shoppingService.createShoppingItem(shopping);
        System.out.println(shopping.getDescription());
        return ResponseEntity.ok(createdShoppingItem);
    }


    @DeleteMapping("/shopping/{id}")
    ResponseEntity<String> deleteShoppingItem(@PathVariable Integer id){
        shoppingService.deleteShoppingItem(id);
        return ResponseEntity.ok("Deleted");
    }


    @DeleteMapping("/shopping")
    ResponseEntity<String> deleteAllShoppingItem(){
        shoppingService.deleteAllShoppingItem();
        return ResponseEntity.ok("Deleted All Shopping Items");
    }


    @PutMapping("/shopping/{id}")
    ResponseEntity<Shopping> updateShoppingItem(@PathVariable Integer id, @RequestBody Shopping shopping){
        return ResponseEntity.ok(shoppingService.updateShopping(id,shopping));
    }
}
