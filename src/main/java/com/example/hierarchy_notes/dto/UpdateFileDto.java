package com.example.hierarchy_notes.dto;

import lombok.Data;

@Data
public class UpdateFileDto {
    private String name;
    private String text;
    private String directory;
    private boolean isDir;
}
