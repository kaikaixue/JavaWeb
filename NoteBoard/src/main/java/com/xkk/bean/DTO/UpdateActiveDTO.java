package com.xkk.bean.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateActiveDTO {
    private Integer id;
    private Integer active;
}
