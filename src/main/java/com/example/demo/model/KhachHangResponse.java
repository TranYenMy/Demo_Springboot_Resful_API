package com.example.demo.model;

import com.example.demo.entity.HangKhachHang;

import java.util.Date;

public interface KhachHangResponse {
    Long getMaKhachHang();

    String getTenKhachHang();

    Date getSinhNhat();

    String getDiaChi();

    String getSoDienThoai();

    String getEmail();

    Boolean getGioiTinh();

    String getChungMinhThu();

    String getSoCanCuoc();

    Long getTrangThai();

    Long getMaHang();

    String getTenHang();

}
