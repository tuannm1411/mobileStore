/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import Service.EmailGiang;
import java.io.File;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;

/**
 *
 * @author togia
 */
public class EmailimplGiang implements EmailGiang {

    @Override
    public String sendEmail(String emailSend, String pass, String emailTo, String subJect, String messen, File file) {
        try {
            final String username = "hungbtph21019@fpt.edu.vn";
            final String password = "buitienhung09";
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(emailSend, pass);
                }
            });
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailSend));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo, false));
            message.setSubject(subJect);
            // Phan 1 gom doan tin nhan
            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText(subJect);

            messageBodyPart1.setText(messen);
            // phan 2 chua tap tin image
            MimeBodyPart messageBodyPart3 = new MimeBodyPart();
            // Duong dan den file cua ban

            String filePath = file.getPath();
            DataSource source2 = new FileDataSource(filePath);
            messageBodyPart3.setDataHandler(new javax.activation.DataHandler(source2));
            messageBodyPart3.setFileName(filePath);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart3);
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Gui mail thanh cong");

            return "Gửi thành công";
        } catch (Exception e) {
            e.printStackTrace();
            return "Gửi thất bại";
        }
    }

    public String sendEmail(String toEmail, String subject, String body) {
        final String username = "hungbtph21019@fpt.edu.vn";
        final String password = "buitienhung09";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("reset.mwcstore@gmail.com", "[BeePhone]"));

            msg.setReplyTo(InternetAddress.parse("reset.mwcstore@gmail.com", false));

            msg.setSubject(subject, "UTF-8");

            msg.setText(body, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("Successfully!!");
            return "Gửi thành công!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Gửi thất bại!";
        }
    }

    @Override
    public String sendEmail1(String emailTo, String subJect, String messen) {

        final String username = "giangtdhph20881@fpt.edu.vn";
        final String password = "giangto28102003";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage msg = new MimeMessage(session);

            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("reset.mwcstore@gmail.com", "[BeePhone]"));

            msg.setReplyTo(InternetAddress.parse("reset.mwcstore@gmail.com", false));

            msg.setSubject(subJect, "UTF-8");

            msg.setText(messen, "UTF-8");

            msg.setSentDate(new Date());

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo, false));
            System.out.println("Message is ready");
            Transport.send(msg);

            System.out.println("Successfully!!");
            return "Gửi thành công!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Gửi thất bại!";
        }
    }
}
