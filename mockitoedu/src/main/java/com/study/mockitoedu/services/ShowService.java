package com.study.mockitoedu.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ShowService {
    private final TextService textService;

    public String getShowLable() {
        return textService.getText();
    }
}
