package com.br.larissa.crudvendas.model;

import org.apache.catalina.User;

public enum UserRole {

    GERENTE("gerente"),
    USER("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }



}
