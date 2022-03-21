package com.mailsendingapi.service.Impl;

import com.mailsendingapi.domain.Mail;
import com.mailsendingapi.provider.SendGridProvider;
import com.mailsendingapi.service.IMailService;
import com.sendgrid.Response;
import org.springframework.stereotype.Service;

/** Service de de email
 *
 * @author Samuel Stalschus
 *
 * */
@Service
public class MailService implements IMailService<Mail, Response> {

    /** Método usado para enviar o email
     *
     * @author Samuel Stalschus
     *
     * @param  mail - Email
     *
     * @return Cliente criado
     *
     * */
    @Override
    public Response sendMail(Mail mail) {
        return SendGridProvider.sendMail(mail);
    }
}
