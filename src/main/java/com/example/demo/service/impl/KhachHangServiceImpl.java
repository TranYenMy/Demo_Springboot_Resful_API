package com.example.demo.service.impl;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.entity.KhachHang;
import com.example.demo.model.KhachHangRequest;
import com.example.demo.model.KhachHangResponse;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHangResponse> getAll() {
        return khachHangRepository.getAll();
    }

    //    @Override
//    public  Page<KhachHang> getALL(Integer pageable) {
//     Pageable pageable1 = PageRequest.of(pageable, 5);
//     return  khachHangRepository.findAll(pageable1);
//    }


    @Override
    public Page<KhachHang> findAll(Pageable pageable) {
         return  khachHangRepository.findAll(pageable);

    }

    @Override
    public KhachHang getOne(Long ma) {
        Optional<KhachHang>  optional = khachHangRepository.findById(ma);

        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public Boolean deleteKhachHang(Long ma) {
        khachHangRepository.deleteById(ma);
        return true;
    }

    @Override
    public KhachHang addKH(KhachHangRequest request) {
        KhachHang kh = request.map(new KhachHang());
        return khachHangRepository.save(kh);
    }

    @Override
    public KhachHang updateKH(Long ma, KhachHangRequest request) {
        Optional<KhachHang>  optional = khachHangRepository.findById(ma);


        return optional.map(khachHang -> {
            khachHang.setTenKhachHang(request.getTenKhachHang());
            khachHang.setSinhNhat(request.getSinhNhat());
            khachHang.setDiaChi(request.getDiaChi());
            khachHang.setSoDienThoai(request.getSoDienThoai());
            khachHang.setEmail(request.getEmail());
            khachHang.setGioiTinh(Boolean.valueOf(request.getGioiTinh()));
            khachHang.setChungMinhThu(request.getChungMinhThu());
            khachHang.setSoCanCuoc(request.getSoCanCuoc());
            khachHang.setHangKhachHang(HangKhachHang.builder().maHang(Long.valueOf(request.getMaHang())).build());
            return khachHangRepository.save(khachHang);
        }).orElse(null);
    }


}
