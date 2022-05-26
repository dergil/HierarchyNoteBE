package com.example.hierarchy_notes.dto;

import com.example.hierarchy_notes.File;
import lombok.Data;

@Data
public class UpdateFileDto {
//    private Long id;
    private String name;
    private String text;
    private String directory;
    private Boolean isDir;

    public UpdateFileDto(File file) {
//        this.id = file.getId();
        this.name = file.getName();
        this.text = file.getText();
        this.directory = file.getDirectory();
        this.isDir = file.getIsDir();
    }
}
