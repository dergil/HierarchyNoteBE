package com.example.hierarchy_notes;

import com.github.vincemann.springrapid.coretest.TestMethodInitializable;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;

@Getter
public class TestData implements TestMethodInitializable {

    File file1;

    @Override
    public void before() {
        this.file1 = File.builder()
//                .id(42L)
                .directory_name("gilsDir")
                .name("gilsFile")
                .isDir(Boolean.TRUE)
                .text("hello gil")
                .build();
    }
}
