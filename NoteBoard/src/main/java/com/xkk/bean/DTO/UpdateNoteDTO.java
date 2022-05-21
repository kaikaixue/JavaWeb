package com.xkk.bean.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNoteDTO {
    private Integer id;
    private String author;
    private String title;
    private String content;
}
