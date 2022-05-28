package com.example.hierarchy_notes.dto;

import com.github.vincemann.springrapid.core.model.IdentifiableEntityImpl;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReadFileDto extends IdentifiableEntityImpl<Long> {
    private Long id;
    private String name;
    private String text;
    private String directory_name;
    private Boolean isDir;
}
