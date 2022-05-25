package com.example.hierarchy_notes.auth;

import com.example.hierarchy_notes.File;
import com.github.vincemann.springrapid.auth.dto.user.RapidFullUserDto;
import com.github.vincemann.springrapid.autobidir.dto.child.annotation.UniDirChildIdCollection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class ReadUserDto extends RapidFullUserDto {

    @UniDirChildIdCollection(File.class)
    private Set<Long> fileIds = new HashSet<>();

    @Builder(builderMethodName = "Builder")
    public ReadUserDto(String email, Set<String> roles, String id, String password, Set<Long> fileIds) {
        super(email, roles, id, password);
        if (fileIds != null)
            this.fileIds = fileIds;
    }
}
