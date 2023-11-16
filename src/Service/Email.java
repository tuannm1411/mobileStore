/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.io.File;

/**
 *
 * @author haha
 */
public interface Email {
    String sendEmail(String fromEmail, String passWord, String toEmail, String subject,String body,File file);//null
    String sendEmail(String fromEmail, String passWord, String toEmail, String subject,String body);//null
}
