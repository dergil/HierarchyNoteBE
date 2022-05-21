package com.example.hierarchy_notes;

import com.example.hierarchy_notes.dto.CreateFileDto;
import com.example.hierarchy_notes.dto.ReadFileDto;
import com.github.vincemann.ezcompare.Comparator;
import com.github.vincemann.springrapid.coretest.controller.integration.IntegrationCrudControllerTest;
import com.github.vincemann.springrapid.coretest.util.TransactionalRapidTestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
class HierarchyNotesApplicationTests extends IntegrationCrudControllerTest<FileController, FileService> {

    @Autowired
    private FileRepository fileRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void createFile() throws Exception {
        CreateFileDto createFileDto = new CreateFileDto("name", "text", "my_dir", false);
        ReadFileDto fullVetDto = performDs2xx(create(createFileDto), ReadFileDto.class);

        Comparator.compare(createFileDto).with(fullVetDto)
                .properties()
                .all()
                .assertEqual();
    }

    @Test
    void findFile() throws Exception {
        String name = "name";
        File inputFile = new File(name, "text", "my_dir", false);
        fileRepository.save(inputFile);
        ReadFileDto readFileDto = performDs2xx(find(name), ReadFileDto.class);
        Comparator.compare(inputFile).with(readFileDto)
                .properties()
                .all()
                .assertEqual();
    }

    @Test
    void updateFile() throws Exception {
        String name = "name";
        File file = new File(name, "text", "my_dir", Boolean.FALSE);
        fileRepository.save(file);
        file.setText("newText");
        String jsonRequest = TransactionalRapidTestUtil.createUpdateJsonRequest(
                TransactionalRapidTestUtil.createUpdateJsonLine("replace", "/text", file.getText())
        );
        ReadFileDto readFileDto = performDs2xx(update(jsonRequest, name), ReadFileDto.class);
        Comparator.compare(file).with(readFileDto)
                .properties()
                .all()
                .assertEqual();

        File dbFile = fileRepository.findById(name).get();
        Comparator.compare(file).with(dbFile)
                .properties()
                .all()
                .assertEqual();
    }

    @Test
    void deleteFile() throws Exception {
        String name = "name";
        File file = new File(name, "text", "my_dir", Boolean.FALSE);
        fileRepository.save(file);
        perform2xx(delete(name));
        Optional<File> dbFile = fileRepository.findById(name);
        Assertions.assertTrue(dbFile.isEmpty());
    }
}
