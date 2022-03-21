package com.mailsendingapi.provider;

import com.mailsendingapi.exception.MailDontSendException;
import com.sendgrid.*;

import java.io.IOException;

/**
 * The type Send grid provider.
 */
public class SendGridProvider {

    private static final SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));

    private static Request req = new Request();

    /**
     * Send mail response.
     *
     * @param mail the mail
     * @return the response
     */
    public static Response sendMail(com.mailsendingapi.domain.Mail mail) {
        return sendMail(mailFactory(mail));
    }

    private static Mail mailFactory(com.mailsendingapi.domain.Mail mail) {
        return new Mail(
                new Email("noreply@rentcar-api.com"),
                mail.getSubject(),
                new Email(mail.getTo()),
                new Content(
                        "text/plain",
                        mail.getContent()
                ));
    }

    private static Response sendMail(Mail mail) {
        try {
            req.setMethod(Method.POST);
            req.setEndpoint("mail/send");
            req.setBody(mail.build());
            return sg.api(req);
        } catch (IOException e) {
            System.out.println(e);
            throw new MailDontSendException("Error of send mail to: " + mail.getSubject());
        }
    }
}
