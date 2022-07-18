package com.example.hierarchy_notes;

import com.example.hierarchy_notes.dto.CreateFileDto;
import com.example.hierarchy_notes.dto.ReadFileDto;
import com.example.hierarchy_notes.dto.UpdateFileDto;
import com.github.vincemann.ezcompare.Comparator;
import com.github.vincemann.springrapid.auth.dto.SignupDto;
import com.github.vincemann.springrapid.auth.service.UserService;
import com.github.vincemann.springrapid.authtest.controller.template.UserControllerTestTemplate;
import com.github.vincemann.springrapid.coretest.util.TransactionalRapidTestUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
public class FileControllerIntegrationTest extends HierarchyNotesControllerTest<FileController, Long, FileService> {

    @Autowired
    TestData testData;

    @Autowired
    UserService userService;

    @Autowired
    UserControllerTestTemplate userControllerTestTemplate;

//    @Test
//    void userCanCrudOwnFile() throws Exception {
//        String token = createUser1();
//        // create file
//        CreateFileDto createFileDto = new CreateFileDto(testData.getFile1());
//        performDs2xx(create(createFileDto).header(HttpHeaders.AUTHORIZATION, token),ReadFileDto.class);
//
//        //crud file to showcase permissions
//        perform2xx(find(createFileDto.getId()).header(HttpHeaders.AUTHORIZATION, token));
//        perform2xx(delete(createFileDto.getId()).header(HttpHeaders.AUTHORIZATION, token));
//    }


    @Test
    void fileCanBeCreatedWithoutAuthentication() throws Exception {
        CreateFileDto createFileDto = new CreateFileDto(testData.getFile1());
        perform2xx(create(createFileDto));
    }

    @Test
    void fileCanBeDeletedWithoutAuthentication() throws Exception {
        CreateFileDto createFileDto = new CreateFileDto(testData.getFile1());
        ReadFileDto response = performDs2xx(create(createFileDto), ReadFileDto.class);
        perform2xx(delete(response.getId()));
    }

    @Test
    void fileCanBeCUpdatedWithoutAuthentication() throws Exception {
        CreateFileDto createFileDto = new CreateFileDto(testData.getFile1());
        ReadFileDto response = performDs2xx(create(createFileDto), ReadFileDto.class);
        String jsonRequest = TransactionalRapidTestUtil.createUpdateJsonRequest(
                TransactionalRapidTestUtil.createUpdateJsonLine("replace", "/text", "hro")
        );
        perform2xx(update(jsonRequest, response.getId()));
    }

    @Test
    void filesCanBeReadWithoutAuth() throws Exception {
        CreateFileDto createFileDto = new CreateFileDto(testData.getFile1());
        ReadFileDto response = performDs2xx(create(createFileDto), ReadFileDto.class);
        ReadFileDto readFileDto = performDs2xx(find(response.getId()), ReadFileDto.class);
        Comparator.compare(createFileDto).with(readFileDto)
            .properties()
            .all()
            .ignore(readFileDto::getId)
            .assertEqual();
    }

    //    @Test
//    void userCantReadForeignFile() throws Exception {
//        String token1 = createUser1();
//        String token2 = createUser2();
//
//        CreateFileDto createFileDto = new CreateFileDto(testData.getFile1());
//        perform2xx(create(createFileDto).header(HttpHeaders.AUTHORIZATION, token1));
//        perform(find(createFileDto.getId()).header(HttpHeaders.AUTHORIZATION, token2))
//                .andExpect(status().isForbidden());
//
//    }
//
//    @Test
//    void createFile() throws Exception {
//        String token = createUser1();
//
//        CreateFileDto createFileDto = new CreateFileDto(testData.getFile1());
//        ReadFileDto fullVetDto = performDs2xx(create(createFileDto).header(HttpHeaders.AUTHORIZATION, token), ReadFileDto.class);
//
//        Comparator.compare(createFileDto).with(fullVetDto)
//                .properties()
//                .all()
//                .assertEqual();
//    }
//
//    @Test
//    void findFile() throws Exception {
//        String token = createUser1();
//
//        CreateFileDto createFileDto = new CreateFileDto(testData.getFile1());
//        perform2xx(create(createFileDto).header(HttpHeaders.AUTHORIZATION, token));
//        ReadFileDto readFileDto = performDs2xx(find(createFileDto.getId()).header(HttpHeaders.AUTHORIZATION, token), ReadFileDto.class);
//        Comparator.compare(createFileDto).with(readFileDto)
//                .properties()
//                .all()
//                .assertEqual();
//    }
//
//    @Test
//    void updateFile() throws Exception {
//        String token = createUser1();
//        File file = testData.getFile1();
//        CreateFileDto createFileDto = new CreateFileDto(file);
//        perform2xx(create(createFileDto).header(HttpHeaders.AUTHORIZATION, token));
//        file.setText("newText");
//        String jsonRequest = TransactionalRapidTestUtil.createUpdateJsonRequest(
//                TransactionalRapidTestUtil.createUpdateJsonLine("replace", "/text", file.getText())
//        );
//        ReadFileDto readFileDto = performDs2xx(update(jsonRequest, file.getId()).header(HttpHeaders.AUTHORIZATION, token), ReadFileDto.class);
//        Comparator.compare(file).with(readFileDto)
//                .properties()
//                .all()
//                .assertEqual();
//
//        File dbFile = getService().findById(file.getId()).get();
//        Comparator.compare(file).with(dbFile)
//                .properties()
//                .all()
//                .assertEqual();
//    }
//
//    @Test
//    void deleteFile() throws Exception {
//        String token = createUser1();
//
//        CreateFileDto createFileDto = new CreateFileDto(testData.getFile1());
//        perform2xx(create(createFileDto).header(HttpHeaders.AUTHORIZATION, token));
//        perform2xx(delete(testData.getFile1().getId()).header(HttpHeaders.AUTHORIZATION, token));
//        Optional<File> dbFile = getService().findById(testData.getFile1().getId());
//        Assertions.assertTrue(dbFile.isEmpty());
//    }

    @AfterEach
    void tearDown() {
        TransactionalRapidTestUtil.clear(getService());
        TransactionalRapidTestUtil.clear(userService);
    }

    private String createUser1() throws Exception {
        SignupDto signupDto = SignupDto.builder()
                .email(testData.getTestUser1().getEmail())
                .password(testData.getTestUser1().getPassword())
                .build();
        perform2xx(userControllerTestTemplate.signup(signupDto));
        return userControllerTestTemplate.login2xx(signupDto.getEmail(), signupDto.getPassword());
    }

    private String createUser2() throws Exception {
        SignupDto signupDto = SignupDto.builder()
                .email(testData.getTestUser2().getEmail())
                .password(testData.getTestUser2().getPassword())
                .build();
        perform2xx(userControllerTestTemplate.signup(signupDto));
        return userControllerTestTemplate.login2xx(signupDto.getEmail(), signupDto.getPassword());
    }
}

