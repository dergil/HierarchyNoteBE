package com.example.hierarchy_notes;

import com.example.hierarchy_notes.auth.User;
import com.github.vincemann.springrapid.coretest.TestMethodInitializable;
import lombok.Getter;

@Getter
public class TestData implements TestMethodInitializable {

    User testUser1;
    User testUser2;
    File file1;

    @Override
    public void before() {
        this.testUser1 = User.builder()
                .email("gilgil@gil.com")
                .password("Password123")
                .build();

        this.testUser2 = User.builder()
                .email("gil@hro.de")
                .password("Password124")
                .build();

        this.file1 = File.builder()
                .id(42L)
                .directory("gilsDir")
                .name("gilsFile")
                .isDir(Boolean.TRUE)
                .text("hello gil")
                .build();
    }
}
