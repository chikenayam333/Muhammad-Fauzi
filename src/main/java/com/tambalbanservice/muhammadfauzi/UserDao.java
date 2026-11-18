/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tambalbanservice.muhammadfauzi;

import java.util.List;
/**
 *
 * @author user
 */
public interface UserDao {
    void simpan(UserEntity user);
    List<UserEntity> semua();
    UserEntity cariById(int id);
    void ubah(UserEntity user);
    void hapus(int id);
    boolean cekUsername(String username);
    UserEntity login(String username, String password);
}
