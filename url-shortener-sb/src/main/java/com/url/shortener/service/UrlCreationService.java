package com.url.shortener.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlCreationService {

    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encodeBase62(long value) {
        StringBuilder sb = new StringBuilder();

        while (value > 0) {
            sb.append(BASE62.charAt((int) (value % 62)));
            value = value / 62;
        }

        return sb.reverse().toString();
    }
}