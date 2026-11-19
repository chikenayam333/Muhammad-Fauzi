/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tambalbanservice.muhammadfauzi;

import java.util.List;

public interface OrderDao {
    void simpan(OrderEntity order);
    List<OrderEntity> semua();
    List<OrderEntity> cariByUser(int userId);
    OrderEntity cariById(int id);
    void ubah(OrderEntity order);
}
