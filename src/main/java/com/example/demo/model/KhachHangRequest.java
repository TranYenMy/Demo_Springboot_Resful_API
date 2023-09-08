package com.example.demo.model;

import com.example.demo.entity.HangKhachHang;
import com.example.demo.entity.KhachHang;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.concurrent.atomic.LongAccumulator;

@Getter
@Setter
public class KhachHangRequest {

    private String tenKhachHang;

    private Date sinhNhat;

    private String diaChi;

    private String soDienThoai;

    private String email;

    private Boolean gioiTinh;

    private String chungMinhThu;

    private String soCanCuoc;

    private Long trangThai;

    private Long maHang;

    public KhachHang map(KhachHang kh){
        kh.setTenKhachHang(this.getTenKhachHang());
        kh.setSinhNhat(this.getSinhNhat());
        kh.setDiaChi(this.getDiaChi());
        kh.setSoDienThoai(this.getSoDienThoai());
        kh.setEmail(this.getEmail());
        kh.setGioiTinh(Boolean.valueOf(this.getGioiTinh()));
        kh.setChungMinhThu(this.getChungMinhThu());
        kh.setSoCanCuoc(this.getSoCanCuoc());
        kh.setHangKhachHang(HangKhachHang.builder().maHang(Long.valueOf(maHang)).build());
        return kh;
    }


}
