package com.study.mockitoedu.services;

import org.springframework.stereotype.Service;

@Service
public class TextService {
    public static final String ORIGINAL_OUTPUT = "Original Text Service Text";

    public String getText() {
        return ORIGINAL_OUTPUT;
    }
}
