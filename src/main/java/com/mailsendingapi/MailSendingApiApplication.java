package com.mailsendingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * The type Mail sending api application.
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MailSendingApiApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(MailSendingApiApplication.class, args);
    }

}
