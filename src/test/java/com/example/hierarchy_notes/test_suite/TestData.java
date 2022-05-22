package com.example.hierarchy_notes.test_suite;

import com.example.hierarchy_notes.File;
import com.example.hierarchy_notes.auth.User;
import com.github.vincemann.springrapid.coretest.TestMethodInitializable;
import com.github.vincemann.springrapid.coretest.bootstrap.BeforeEachTestMethodInitializable;
import lombok.Getter;

@Getter
public class TestData implements TestMethodInitializable {


    User testUser1;
    User testUser2;
    File file1;

    @Override
    public void before() {
        this.testUser1 = User.builder()
                .email("")
                .build();

        this.testUser2 = User.builder()
                .email("gil@hro.de")
                .build();

        this.file1 = File.builder()
                .directory("gilsDir")
                .name("gilsFile")
                .isDir(Boolean.TRUE)
                .text("hello gil")
                .build();
    }
}
