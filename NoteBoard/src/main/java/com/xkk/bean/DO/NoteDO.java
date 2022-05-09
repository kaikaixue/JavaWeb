package com.xkk.bean.DO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteDO {
    private Integer id;
    private String title;
    private String author;
    private String content;
}
