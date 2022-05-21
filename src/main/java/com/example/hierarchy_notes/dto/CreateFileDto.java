package com.example.hierarchy_notes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFileDto {
    private String name;
    private String text;
    private String directory;
    private boolean isDir;
}
