package ViewModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author buiti
 */
public class MaNVViewModel {
    private String maNV;

    public MaNVViewModel() {
    }

    public MaNVViewModel(String maNV) {
        this.maNV = maNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    @Override
    public String toString() {
        return "MaNVViewModel{" + "maNV=" + maNV + '}';
    }

}
