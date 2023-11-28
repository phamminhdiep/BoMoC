package com.example.BoMoC.controller;

import com.example.BoMoC.model.product.Clothes;
import com.example.BoMoC.dao.productdao.clothesdao.ClothesDao;
import com.example.BoMoC.model.product.MobilePhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    @Autowired
    public ClothesController(ClothesDao clothesDao) {
        this.clothesDao = clothesDao;
    }

    private ClothesDao clothesDao;

    @GetMapping
    public ResponseEntity<List<Clothes>> getAll() {
        List<Clothes> clothes = clothesDao.getAll();
        return new ResponseEntity<>(clothes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clothes> getById(@PathVariable Integer id) {
        Optional<Clothes> clothes = clothesDao.getOne(id);
        return clothes.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Clothes>> getByKeyword(@RequestParam String keyword) {
        List<Clothes> clothesList = clothesDao.findByNameWithKeyword(keyword);
        if (clothesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clothesList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Clothes> add(@RequestBody Clothes clothes) {
        Clothes savedClothes = clothesDao.add(clothes);
        return new ResponseEntity<>(savedClothes, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clothes> update(@PathVariable Integer id, @RequestBody Clothes clothes){
        return new ResponseEntity<>(clothesDao.update(id, clothes), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clothesDao.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
