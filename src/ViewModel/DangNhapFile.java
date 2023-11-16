/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.io.Serializable;

/**
 *
 * @author buiti
 */
public class DangNhapFile implements Serializable{
    private String id;
    private String pass;

    @Override
    public String toString() {
        return "DangNhapFile{" + "id=" + id + ", pass=" + pass + '}';
    }

    public DangNhapFile(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }

    public DangNhapFile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
