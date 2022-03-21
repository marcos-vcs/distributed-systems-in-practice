package com.mailsendingapi.dto;

import com.mailsendingapi.domain.Mail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/** Entidade de DTO de Email assim podemos validar os atributos antes de chegar no domínio.
 *
 * @author Samuel Stalschus
 *
 * */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MailDTO {

    @NotNull(message = "O email do destinatário não pode estar vazio")
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Email com formato inválido")
    @Size(max = 155, message = "O email pode ter no máximo 155 caracteres")
    private String to;

    @NotNull(message = "O assunto da mensagem não pode estar vazio")
    @Size(max = 40, message = "O assunto pode ter no máximo 40 caracteres")
    private String subject;

    @NotNull(message = "O corpo do email não pode estar vazio")
    @Size(max = 500, message = "O corpo do email pode ter no máximo 500 caracteres")
    private String content;

    public static MailDTO convert(Mail address) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(address, MailDTO.class);
    }

    public static Mail convert(MailDTO addressDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(addressDTO, Mail.class);
    }
}
