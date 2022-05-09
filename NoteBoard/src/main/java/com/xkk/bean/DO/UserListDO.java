package com.xkk.bean.DO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserListDO {
    private Integer userId;
    private String name;
    private String email;
    private String flag;
}