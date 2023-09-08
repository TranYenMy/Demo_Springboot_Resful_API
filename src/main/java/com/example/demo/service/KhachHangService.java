package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import com.example.demo.model.KhachHangRequest;
import com.example.demo.model.KhachHangResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface KhachHangService {
    List<KhachHangResponse> getAll();

//    Page<KhachHang> getALL(Integer pageable);

    Page<KhachHang> findAll(Pageable pageable);

    KhachHang getOne(Long ma);

    Boolean deleteKhachHang(Long ma);

    KhachHang addKH(KhachHangRequest request);

    KhachHang updateKH(Long ma, KhachHangRequest request);


}
