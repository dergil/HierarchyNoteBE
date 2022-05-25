package com.example.hierarchy_notes.dto;

import com.example.hierarchy_notes.CustomIdentifiableEntityImpl;
import com.example.hierarchy_notes.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFileDto extends CustomIdentifiableEntityImpl<Long> {
    private String name;
    private String text;
    private String directory;
    private Boolean isDir;

    public CreateFileDto(File file) {
        this.name = file.getName();
        this.text = file.getText();
        this.directory = file.getDirectory();
        this.isDir = file.getIsDir();
    }
}
