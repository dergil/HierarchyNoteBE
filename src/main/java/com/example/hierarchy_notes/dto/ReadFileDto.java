package com.example.hierarchy_notes.dto;

import com.example.hierarchy_notes.CustomIdentifiableEntityImpl;
import com.github.vincemann.springrapid.core.model.IdentifiableEntityImpl;
import lombok.Data;

@Data
public class ReadFileDto extends CustomIdentifiableEntityImpl<Long> {
    private String name;
    private String text;
    private String directory;
    private Boolean isDir;
}
