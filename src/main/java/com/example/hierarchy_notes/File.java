package com.example.hierarchy_notes;

import com.github.vincemann.springrapid.core.model.IdentifiableEntityImpl;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "files")
public class File extends IdentifiableEntityImpl<Long> {

    @Builder
    public File (String name, String text, String directory, boolean isDir) {
        this.name = name;
        this.text = text;
        this.directory = directory;
        this.isDir = isDir;
    }

    @Column(name = "names")
    private String name;

    @Column(name = "texts")
    private String text;

    @Column(name = "directories")
    private String directory;

    @Column(name = "isDir")
    private boolean isDir;
}
