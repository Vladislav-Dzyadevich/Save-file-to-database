package com.company.mail;

import com.company.dto.UserDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.ResourceBundle;

@Service
@Slf4j
public class MailingService {

    private static final String MAIL_MESSAGES_BUNDLE = "set_password_template";
    private static final String SET_PASSWORD_SUBJECT = "user.reset.password.subject";
    private static final String SET_PASSWORD_TEXT = "user.reset.password.text";

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Value("${mail.username}")
    private String from;
    private String resetLink;

    public void setResetLink(String resetLink) {
        this.resetLink = resetLink;
    }

    @SneakyThrows
    public void sendUserResetPasswordMessage(UserDto user) {
        sendMessage(user, SET_PASSWORD_SUBJECT, SET_PASSWORD_TEXT);
    }

    @SneakyThrows
    public void sendMessage(UserDto user, String subjectKey, String textKey) {
        ResourceBundle messageBundle = ResourceBundle.getBundle(MAIL_MESSAGES_BUNDLE);
        new MailBuilder(mailSender)
                .addSubject(messageBundle.getString(subjectKey))
                .from(from)
                .to(user.getEmail())
                .setHtmlText(generateMailMessage(textKey, messageBundle))
                .send();
    }

    private String generateMailMessage(String messageKey, ResourceBundle messageBundle) {
        return new MessageTemplateBuilder()
                .setExpression(messageBundle.getString(messageKey) + resetLink)
                .buildMessage();
    }
}