package com.example.Shoppinglist.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Shoppinglist.Model.Shopping;

@Repository
public interface ShoppingRepository extends JpaRepository<Shopping,Integer>{
    
} 