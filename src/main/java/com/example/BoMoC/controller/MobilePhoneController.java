package com.example.BoMoC.controller;

import com.example.BoMoC.dao.productdao.mobilephonedao.MobilePhoneDao;
import com.example.BoMoC.model.product.MobilePhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mobile-phone")
public class MobilePhoneController {
    private MobilePhoneDao mobilePhoneDao;

    @Autowired
    public MobilePhoneController(MobilePhoneDao mobilePhoneDao) {
        this.mobilePhoneDao = mobilePhoneDao;
    }

    @GetMapping
    public ResponseEntity<List<MobilePhone>> getAll(){
        List<MobilePhone> mobilePhoneList = mobilePhoneDao.getAll();
        return new ResponseEntity<>(mobilePhoneList, HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MobilePhone> getById(@PathVariable Integer id) {
        Optional<MobilePhone> mobilePhone = mobilePhoneDao.getOne(id);
        return mobilePhone.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public ResponseEntity<List<MobilePhone>> getPersonsByKeyword(@RequestParam String keyword) {
        List<MobilePhone> mobilePhoneList = mobilePhoneDao.findByNameWithKeyword(keyword);
        if (mobilePhoneList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mobilePhoneList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MobilePhone> add(@RequestBody MobilePhone mobilePhone) {
        MobilePhone savedClothes = mobilePhoneDao.add(mobilePhone);
        return new ResponseEntity<>(savedClothes, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MobilePhone> update(@PathVariable Integer id, @RequestBody MobilePhone mobilePhone){
        return new ResponseEntity<>(mobilePhoneDao.update(id, mobilePhone), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        mobilePhoneDao.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
