package com.xkk.bean.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AllNoteListDTO {
    private Integer page;
    private Integer pageSize;
}
