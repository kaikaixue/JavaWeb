package com.xkk.bean.DO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDO {
    private Integer id;
    private String name;
    private String email;
    private String flag;
    private String image;
}
