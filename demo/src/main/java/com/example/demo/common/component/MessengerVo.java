package com.example.demo.common.component;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessengerVo {
    private String message;
    private int sataus;
    private String code;
}
