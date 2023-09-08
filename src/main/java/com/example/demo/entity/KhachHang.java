package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Builder
@ToString
@Entity
@Table(name = "KhachHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKhachHang")
    private Long maKhachHang;

    @Column(name = "TenKhachHang")
    private String tenKhachHang;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Column(name = "SinhNhat")
    private Date sinhNhat;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "Email")
    private String email;

    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

    @Column(name = "ChungMinhThu")
    private String chungMinhThu;

    @Column(name = "SoCanCuoc")
    private String soCanCuoc;

    @Column(name = "TrangThai")
    private Long trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HangKhachHang")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private HangKhachHang hangKhachHang;


}
