/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tambalbanservice.muhammadfauzi;

import java.util.List;

public interface StikerDao {
    void simpan(StikerEntity stiker);
    List<StikerEntity> semua();
    StikerEntity cariById(int id);
    void ubah(StikerEntity stiker);
    void hapus(int id);
}
