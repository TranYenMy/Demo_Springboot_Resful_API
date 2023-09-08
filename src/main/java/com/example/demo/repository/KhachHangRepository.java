package com.example.demo.repository;

import com.example.demo.entity.KhachHang;
import com.example.demo.model.KhachHangResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface KhachHangRepository extends JpaRepository<KhachHang,Long> {

    @Query(value = "SELECT kh.MaKhachHang, kh.TenKhachHang, kh.SinhNhat, kh.DiaChi, kh.SoDienThoai, kh.Email, kh.GioiTinh ,kh.ChungMinhThu,  kh.SoCanCuoc, kh.TrangThai, h.MaHang, h.TenHang \n"+
     "FROM KhachHang kh JOIN HangKhachHang  h on kh.hangKhachHang = h.maHang ", nativeQuery = true )

    List<KhachHangResponse> getAll();
}
