package com.example.hierarchy_notes;

import com.github.vincemann.springrapid.core.model.IdentifiableEntity;
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
public class File implements IdentifiableEntity<String> {

    @Builder
    public File (String name, String text, String directory, Boolean isDir) {
        this.name = name;
        this.text = text;
        this.directory = directory;
        this.isDir = isDir;
    }

    @javax.persistence.Id
    @Column(name = "names")
    private String name;

    @Column(name = "texts")
    private String text;

    @Column(name = "directories")
    private String directory;

    @Column(name = "isDir")
    private boolean isDir;

    @Override
    public String getId() {
        return name;
    }

    @Override
    public void setId(String s) {
        this.name = s;
    }
}
