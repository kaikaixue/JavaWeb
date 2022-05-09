package com.xkk.mapper;

import com.xkk.bean.DO.NoteDO;
import com.xkk.bean.DO.NoteTotalDO;
import com.xkk.bean.DTO.AddNoteDTO;
import com.xkk.bean.DTO.AllNoteListDTO;
import com.xkk.bean.DTO.NoteLikeListDTO;
import com.xkk.bean.DTO.NoteLikeSizeDTO;

import java.util.List;

public interface NoteMapper {
    List<NoteDO> getNodeLikeList(NoteLikeListDTO noteLikeListDTO);
    NoteTotalDO getNoteLikeSize(NoteLikeSizeDTO noteLikeSizeDTO);
    List<NoteDO> getAllNoteList(AllNoteListDTO allNoteListDTO);
    NoteTotalDO getAllNoteSize();
    Integer addNote(AddNoteDTO addNoteDTO);
    Integer delNoteById(Integer id);
}
