/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tambalbanservice.muhammadfauzi;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderEntity {

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setStiker(StikerEntity stiker) {
        this.stiker = stiker;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public void setGambarPath(String gambarPath) {
        this.gambarPath = gambarPath;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEstimasiHari(Integer estimasiHari) {
        this.estimasiHari = estimasiHari;
    }

    public void setTanggalOrder(LocalDateTime tanggalOrder) {
        this.tanggalOrder = tanggalOrder;
    }

    public int getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public StikerEntity getStiker() {
        return stiker;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public String getGambarPath() {
        return gambarPath;
    }

    public String getStatus() {
        return status;
    }

    public Integer getEstimasiHari() {
        return estimasiHari;
    }

    public LocalDateTime getTanggalOrder() {
        return tanggalOrder;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "stiker_id")
    private StikerEntity stiker;

    @Column(name = "jumlah")
    private int jumlah;

    @Column(name = "total_harga")
    private double totalHarga;

    @Column(name = "gambar_path")
    private String gambarPath;

    @Column(name = "status")
    private String status;

    @Column(name = "estimasi_hari")
    private Integer estimasiHari;

    @Column(name = "tanggal_order")
    private LocalDateTime tanggalOrder;

   
}
