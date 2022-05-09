package com.xkk.bean.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteLikeListDTO {
    private String like;
    private String parameter;
    private Integer page;
    private Integer pageSize;
}
