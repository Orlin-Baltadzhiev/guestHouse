package com.GuestHouseBaltadzhiev.service;

import com.GuestHouseBaltadzhiev.Repository.ReservationRepository;
import com.GuestHouseBaltadzhiev.model.Entity.Reservation;
import com.GuestHouseBaltadzhiev.model.service.ReservationServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ModelMapper modelMapper;
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ModelMapper modelMapper, ReservationRepository reservationRepository){
        this.modelMapper = modelMapper;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void registerReservation(ReservationServiceModel reservationServiceModel){
        Reservation reservation = modelMapper.map (reservationServiceModel, Reservation.class);
        reservationRepository.save (reservation);
    }

    @Override
    public void sendEmailToMe(ReservationServiceModel reservationServiceModel){
        //authentication info
        final String myUsername =System.getenv("MY_USERNAME");
        final String myPassword =System.getenv("MY_PASSWORD");
        String fromEmail ="orlin.baltadzhiev@yahoo.com";
        String toEmail = "orlin.baltadzhiev@yahoo.com";

        Properties properties = new Properties ();
        properties.put ("mail.smtp.auth", "true");
        properties.put ("mail.smtp.starttls.enable", "true");
        properties.put ("mail.smtp.host", "smtp.mail.yahoo.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.trust", "*");

        Session session = Session.getInstance (properties, new javax.mail.Authenticator () {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication (myUsername,myPassword);
            }
        });
        StringBuilder message = processedMessage(reservationServiceModel);

        //Start our mail message
        MimeMessage msg = new MimeMessage (session);
        try {
            msg.setFrom (new InternetAddress (fromEmail));
            msg.addRecipients (Message.RecipientType.TO, String.valueOf (new InternetAddress (toEmail)));
            msg.setSubject ("Hello smart guy");
            msg.setText (message.toString ());
            Transport.send (msg);
            System.out.println ("Send Message");
        } catch (MessagingException e) {
            e.printStackTrace ();
        }
    }

    private StringBuilder processedMessage(ReservationServiceModel reservationServiceModel){
        StringBuilder message = new StringBuilder ();
        message
                .append ("Name: " +reservationServiceModel.getName ()).append ("\n")
                .append ("Email: " + reservationServiceModel.getEmail ()).append ("\n")
                .append ("Phone Number: " + reservationServiceModel.getPhone ()).append ("\n")
                .append ("Date: " + reservationServiceModel.getDate ()).append ("\n")
                .append ("Time: " + reservationServiceModel.getTime ()).append ("\n")
                .append ("Number of people: " + reservationServiceModel.getPeople ()).append ("\n")
                .append ("Message: -> " +reservationServiceModel.getMessage ());
        return message;
    }
}
