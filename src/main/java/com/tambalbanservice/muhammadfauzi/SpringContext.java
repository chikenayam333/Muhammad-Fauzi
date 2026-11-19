/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tambalbanservice.muhammadfauzi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContext {

    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

    public static <T> T getBean(Class<T> type) {
        return context.getBean(type);
    }
}