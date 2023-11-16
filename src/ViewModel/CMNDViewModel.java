/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author buiti
 */
public class CMNDViewModel {
    private String cmnd;

    public CMNDViewModel(String cmnd) {
        this.cmnd = cmnd;
    }

    public CMNDViewModel() {
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
    
}
