package com.xkk.bean.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddNoteDTO {
    private String title;
    private String author;
    private String content;
}
