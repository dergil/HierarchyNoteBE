package com.example.hierarchy_notes;

import com.example.hierarchy_notes.dto.CreateFileDto;
import com.example.hierarchy_notes.dto.ReadFileDto;
import com.github.vincemann.springrapid.coretest.controller.integration.IntegrationCrudControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HierarchyNotesApplicationTests extends IntegrationCrudControllerTest<FileController, FileService> {

    @Test
    void contextLoads() {
    }

    @Test
    void createFile() throws Exception {
//        String json = getMvc().perform(create(createSpecialtyDto))
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
        CreateFileDto createFileDto = new CreateFileDto("name", "text", "dir", false);
        ReadFileDto fullVetDto = performDs2xx(create(createFileDto), ReadFileDto.class);
    }



}
