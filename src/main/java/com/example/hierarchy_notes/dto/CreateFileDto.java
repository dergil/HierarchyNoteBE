package com.example.hierarchy_notes.dto;

import com.example.hierarchy_notes.CustomIdentifiableEntityImpl;
import com.example.hierarchy_notes.File;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateFileDto extends CustomIdentifiableEntityImpl<Long> {
    private String name;
    private String text;
    private String directory_name;
    private Boolean isDir;

    public CreateFileDto(File file) {
        this.setId(file.getId());
        this.name = file.getName();
        this.text = file.getText();
        this.directory_name = file.getDirectory_name();
        this.isDir = file.getIsDir();
    }
}
