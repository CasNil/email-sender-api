package se.lexicon.emailsenderapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    private final EmailProperties properties;

    @Autowired
    public MailConfig(EmailProperties emailProperties) {
        this.properties = emailProperties;
    }

    @Bean
    public JavaMailSender JavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(properties.getHost());
        mailSender.setUsername(properties.getUsername());
        mailSender.setPassword(properties.getPassword());
        mailSender.getJavaMailProperties().put("mail.smtp.auth", properties.isSmtpAuth());
        mailSender.getJavaMailProperties().put("mail.smtp.starttls.enable", properties.isStartTls());
        return mailSender;
    }
}
