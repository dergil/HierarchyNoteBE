package com.example.hierarchy_notes;

import com.example.hierarchy_notes.auth.User;
import com.github.vincemann.springrapid.core.model.IdentifiableEntity;
import com.github.vincemann.springrapid.core.model.IdentifiableEntityImpl;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.common.aliasing.qual.Unique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "files")
public class File extends CustomIdentifiableEntityImpl<Long> {

    @Builder
    public File (String name, String text, String directory, Boolean isDir) {
        this.name = name;
        this.text = text;
        this.directory = directory;
        this.isDir = isDir;
    }

    @javax.persistence.Id
    private Long id;

//    @javax.persistence.Id
    @Unique
    @Column(name = "names")
    private String name;

    @Column(name = "texts")
    private String text;

    @Column(name = "directories")
    private String directory;

    @Column(name = "isDir")
    private Boolean isDir;

//    @Column(name = "user")
//    @OneToMany
//    private User user;

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
