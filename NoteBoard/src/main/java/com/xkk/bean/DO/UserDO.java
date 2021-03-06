package com.xkk.bean.DO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDO {
    private Integer id;
    private String name;
    private String email;
    private Boolean active;
    private String image;
}
