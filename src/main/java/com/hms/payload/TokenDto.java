package com.hms.payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TokenDto {
    private String token;
    private String type;
}
