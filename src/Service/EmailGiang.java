/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.io.File;

/**
 *
 * @author togia
 */
public interface EmailGiang {

    String sendEmail(String emailSend, String pass, String emailTo, String subJect, String messen,File file);
    String sendEmail1( String emailTo, String subJect, String messen);
}
