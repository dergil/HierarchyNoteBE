package com.example.hierarchy_notes;

import com.github.vincemann.springrapid.core.model.IdentifiableEntityImpl;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "files")
public class File extends IdentifiableEntityImpl<Long> {

    @Unique
    @Column(name = "names")
    private String name;

    @Column(name = "texts")
    private String text;

    @Column(name = "directories")
    private String directory_name;

    @Column(name = "isDir")
    private Boolean isDir;

    @Column(name = "synced")
    private Boolean synced;

    @Builder
    public File (Long id, String name, String text, String directory_name, Boolean isDir, Boolean synced) {
        this.setId(id);
        this.name = name;
        this.text = text;
        this.directory_name = directory_name;
        this.isDir = isDir;
        this.synced = synced;
    }

//    @javax.persistence.Id



//    @Override
//    public Long getId() {
//        return id;
//    }
//
//    @Override
//    public void setId(Long l) {
//        this.id = l;
//    }
}
