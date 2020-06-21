package com.company.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class JavaMailSenderConfig {

    @Value("${mail.host}")
    private String host;
    @Value("${mail.port}")
    private int port;
    @Value("${mail.username}")
    private String username;
    @Value("${mail.password}")
    private String password;
    @Value("${mail.smtp.starttls.enable}")
    private String smtpEnable;
    @Value("${mail.smtp.auth}")
    private String isAuth;
    @Value("${mail.transport.protocol}")
    private String protocol;
    @Value("${mail.debug}")
    private String isDebugEnable;

    @Bean
    public JavaMailSenderImpl getJavaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        Properties javaMail = new Properties();
        javaMail.setProperty("mail.smtp.starttls.enable", smtpEnable);
        javaMail.setProperty("mail.smtp.auth", isAuth);
        javaMail.setProperty("mail.transport.protocol", protocol);
        javaMail.setProperty("mail.debug", isDebugEnable);
        javaMailSender.setJavaMailProperties(javaMail);
        return javaMailSender;
    }
}