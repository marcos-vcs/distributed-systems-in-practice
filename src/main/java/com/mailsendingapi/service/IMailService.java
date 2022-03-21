package com.mailsendingapi.service;

/**
 * The interface Mail service.
 *
 * @param <T> the type parameter
 * @param <J> the type parameter
 */
public interface IMailService<T,J> {
    /**
     * Send mail j.
     *
     * @param t the t
     * @return the j
     */
    public J sendMail(T t);
}
