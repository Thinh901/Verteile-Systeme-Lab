package com.example.Shoppinglist.Controller;

import java.util.List;

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
import io.opentelemetry.instrumentation.annotations.WithSpan;

@RestController
@CrossOrigin(origins = "*")
public class ShoppingController {
    

    @Autowired
    private ShoppingService shoppingService;


    @WithSpan
    @GetMapping("/shopping")
    ResponseEntity<List<Shopping>> getAllShoppingItems(){
        return new ResponseEntity<>(shoppingService.getAllShoppingItems(),HttpStatus.OK);
    }

    @WithSpan
    @PostMapping("/shopping")
    ResponseEntity<Shopping> createShoppingItem(@RequestBody Shopping shopping){
        Shopping createdShoppingItem = shoppingService.createShoppingItem(shopping);
        System.out.println(shopping.getDescription());
        return ResponseEntity.ok(createdShoppingItem);
    }

    @WithSpan
    @DeleteMapping("/shopping/{id}")
    ResponseEntity<String> deleteShoppingItem(@PathVariable Integer id){
        shoppingService.deleteShoppingItem(id);
        return ResponseEntity.ok("Deleted");
    }

    @WithSpan
    @DeleteMapping("/shopping")
    ResponseEntity<String> deleteAllShoppingItem(){
        shoppingService.deleteAllShoppingItem();
        return ResponseEntity.ok("Deleted All Shopping Items");
    }

    @WithSpan
    @PutMapping("/shopping/{id}")
    ResponseEntity<Shopping> updateShoppingItem(@PathVariable Integer id, @RequestBody Shopping shopping){
        return ResponseEntity.ok(shoppingService.updateShopping(id,shopping));
    }
}