package com.company.mail;

import java.util.Arrays;
import java.util.Objects;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Slf4j
public class MailBuilder {

    private JavaMailSender mailSender;
    private MimeMessage mimeMessage;
    private MimeMessageHelper messageHelper;

    public MailBuilder(MailSender mailSender) {
        Objects.requireNonNull(mailSender);
        this.mailSender = (JavaMailSender) mailSender;
        mimeMessage = this.mailSender.createMimeMessage();
        messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
    }

    public MailBuilder from(String senderAddress) throws MessagingException {
        log.info("senderAddress=" + senderAddress);
        Objects.requireNonNull(senderAddress);
        messageHelper.setFrom(senderAddress);
        return this;
    }

    public MailBuilder to(String... receiverAddresses) throws MessagingException {
        log.info("receiverAddresses=" + Arrays.toString(receiverAddresses));
        Objects.requireNonNull(receiverAddresses);
        messageHelper.setTo(receiverAddresses);
        return this;
    }

    public MailBuilder addSubject(String subject) throws MessagingException {
        log.info("subject=" + subject);
        Objects.requireNonNull(subject);
        messageHelper.setSubject(subject);
        return this;
    }

    public MailBuilder setHtmlText(String text) throws MessagingException {
        log.info("setHtmlText=" + text);
        messageHelper.setText(text, true);
        return this;
    }

    public void send() {
        log.info("Send mail...");
        mailSender.send(mimeMessage);
    }


}