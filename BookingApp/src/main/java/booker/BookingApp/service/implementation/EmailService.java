package booker.BookingApp.service.implementation;

import booker.BookingApp.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    /*
     * Koriscenje klase za ocitavanje vrednosti iz application.properties fajla
     */
    @Autowired
    private Environment env;

    /*
     * Anotacija za oznacavanje asinhronog zadatka
     * Vise informacija na: https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#scheduling
     */
    @Async
    public void sendNotificaitionAsync(User user) throws MailException, InterruptedException {
        System.out.println("Async metoda se izvrsava u drugom Threadu u odnosu na prihvaceni zahtev. Thread id: " + Thread.currentThread().getId());
        //Simulacija duze aktivnosti da bi se uocila razlika
        Thread.sleep(10000);
        System.out.println("Slanje emaila...");
        String ipAddress = getIpAddress();
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject("Primer slanja emaila pomoću asinhronog Spring taska");
        mail.setText("Pozdrav " + user.getName() + ",\n\n Activation Link: http://"+ getIpAddress() +":4200/activate_profile/" + user.getActivationLink());
//        if (ipAddress.equals("")) {
//            mail.setText("Pozdrav " + user.getName() + ",\n\n Activation Link: http://localhost:4200/activate_profile/" + user.getActivationLink());
//        } else {
//        mail.setText("Pozdrav " + user.getName() + ",\n\n Activation Link: http://"+ipAddress+":4200/activate_profile/" + user.getActivationLink());
//        }

        System.setProperty("mail.debug", "true");
        javaMailSender.send(mail);

        System.out.println("Email poslat!");
    }

    public void sendNotificaitionSync(User user) throws MailException, InterruptedException {
        System.out.println("Sync metoda se izvrsava u istom Threadu koji je i prihvatio zahtev. Thread id: " + Thread.currentThread().getId());
        //Simulacija duze aktivnosti da bi se uocila razlika
        Thread.sleep(50000);
        System.out.println("Slanje emaila...");

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject("Primer slanja emaila pomocu asinhronog Spring taska");
        mail.setText("Pozdrav " + user.getName() + ",\n\n.");
        javaMailSender.send(mail);

        System.out.println("Email poslat!");
    }

    public static String getIpAddress() {
        String ipAddress = "";
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            ipAddress = localhost.getHostAddress();
            System.out.println("Local IP Address: " + localhost.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ipAddress;
    }
}
