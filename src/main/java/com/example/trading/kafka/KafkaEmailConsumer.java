package com.example.trading.kafka;

import com.example.trading.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaEmailConsumer {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "${application.topic.name}", groupId = "email-group")
    public void consumeEmailEvent(String message) {
        // Example message: "userEmail:subject:body"
        System.out.println("Consumed message for email: " + message);
        String[] parts = message.split(":");
        if (parts.length < 3) {
            System.err.println("Invalid message format: " + message);
            return;
        }

        String userEmail = parts[0];
        String subject = parts[1];
        String body = parts[2];

        // Send email
        try {
            emailService.sendEmail(userEmail, subject, body);
            System.out.println("Email sent successfully to " + userEmail);
        } catch (Exception e) {
            System.err.println("Failed to send email to " + userEmail + ": " + e.getMessage());
        }
    }
}
