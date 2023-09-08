package com.example.demo.controller;


import com.example.demo.entity.KhachHang;
import com.example.demo.model.KhachHangRequest;
import com.example.demo.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(khachHangService.getAll());
    }

//    @GetMapping("hien-thi")
//    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "1", name = "page") Integer page) {
//
//        return ResponseEntity.ok(khachHangService.getALL(page));
//    }
@GetMapping("/pages")
public Page<KhachHang> getKhachHang(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
){
    PageRequest pageRequest = PageRequest.of(page, size);
    return  khachHangService.findAll(pageRequest);
}

    @DeleteMapping("delete/{maKhachHang}")
    public ResponseEntity deleteKH(@PathVariable("maKhachHang") Long ma){
        return new ResponseEntity(khachHangService.deleteKhachHang(ma), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addKH(@RequestBody @Valid KhachHangRequest request, BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> list  = result.getAllErrors();
            return ResponseEntity.ok(list);
        }else{
            return new ResponseEntity(khachHangService.addKH(request), HttpStatus.OK);
        }

    }

@PostMapping("update/{maKhachHang}")
    public ResponseEntity<?> updateKH(@PathVariable("maKhachHang")  Long ma, @RequestBody KhachHangRequest request){
        return  new ResponseEntity(khachHangService.updateKH(ma, request), HttpStatus.OK);
}


}
