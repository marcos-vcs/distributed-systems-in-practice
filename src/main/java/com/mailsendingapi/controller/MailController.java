package com.mailsendingapi.controller;

import com.mailsendingapi.dto.MailDTO;
import com.mailsendingapi.service.Impl.MailService;
import com.sendgrid.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/** Controller para envio de email
 *
 * @author Samuel Stalschus
 *
 * */
@RestController
@RequestMapping("/send-mail")
public class MailController {

        @Autowired
        MailService mailService;

        /** Método POST usado para enviar o email
         *
         * @author Samuel Stalschus
         *
         * @return Response do sendgrid
         *
         * */
        @PostMapping("")
        public ResponseEntity<Response> create(@Valid @RequestBody MailDTO mailDTO) {
            return ResponseEntity.ok(mailService.sendMail(MailDTO.convert(mailDTO)));
        }
}
