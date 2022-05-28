package com.example.hierarchy_notes.dto;

import com.example.hierarchy_notes.File;
import com.github.vincemann.springrapid.core.model.IdentifiableEntityImpl;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateFileDto extends IdentifiableEntityImpl<Long> {
    private String name;
    private String text;
    private String directory_name;
    private Boolean isDir;

    public CreateFileDto(File file) {
        this.name = file.getName();
        this.text = file.getText();
        this.directory_name = file.getDirectory_name();
        this.isDir = file.getIsDir();
    }
}
