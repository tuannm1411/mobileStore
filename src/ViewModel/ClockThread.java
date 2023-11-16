package ViewModel;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author buiti
 */
public class ClockThread implements Runnable {

    JLabel clockLabel;

    public ClockThread(JLabel clockLabel) {
        this.clockLabel = clockLabel;
    }

    @Override
    public void run() {
        while (true) {
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss aa");
            clockLabel.setText(dateFormat.format(now));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
    public static void main(String[] args) {
       System.out.println(java.time.LocalDate.now());
    }

}
