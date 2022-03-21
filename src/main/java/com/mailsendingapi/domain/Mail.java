package com.mailsendingapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade de Email.
 *
 * @author Samuel Stalschus
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {

    private String to;

    private String subject;

    private String content;

}
