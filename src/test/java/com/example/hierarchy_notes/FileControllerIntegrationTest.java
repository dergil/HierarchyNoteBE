package com.example.hierarchy_notes;

import com.example.hierarchy_notes.dto.CreateFileDto;
import com.example.hierarchy_notes.dto.ReadFileDto;
import com.github.vincemann.ezcompare.Comparator;
import com.github.vincemann.springrapid.auth.dto.SignupDto;
import com.github.vincemann.springrapid.auth.dto.user.RapidFindOwnUserDto;
import com.github.vincemann.springrapid.auth.service.UserService;
import com.github.vincemann.springrapid.authtest.controller.template.UserControllerTestTemplate;
import com.github.vincemann.springrapid.coretest.controller.integration.IntegrationCrudControllerTest;
import com.github.vincemann.springrapid.coretest.util.TransactionalRapidTestUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
public class FileControllerIntegrationTest extends HierarchyNotesControllerTest<FileController, String, FileService> {

    @Autowired
    TestData testData;

    @Autowired
    UserService userService;

    @Autowired
    UserControllerTestTemplate userControllerTestTemplate;

    @Test
    void userCanCrudOwnFile() throws Exception {
        String token = createUser1();
        // create file
        CreateFileDto createFileDto = new CreateFileDto(testData.getFile1());
        performDs2xx(create(createFileDto).header(HttpHeaders.AUTHORIZATION, token),ReadFileDto.class);

        //crud file to showcase permissions
        perform2xx(find(createFileDto.getName()).header(HttpHeaders.AUTHORIZATION, token));
        perform2xx(delete(createFileDto.getName()).header(HttpHeaders.AUTHORIZATION, token));
    }

    @Test
    void userCantReadForeignFile() throws Exception {
        String token1 = createUser1();
        String token2 = createUser2();

        CreateFileDto createFileDto = new CreateFileDto(testData.getFile1());
        perform2xx(create(createFileDto).header(HttpHeaders.AUTHORIZATION, token1));
        perform(find(createFileDto.getName()).header(HttpHeaders.AUTHORIZATION, token2))
                .andExpect(status().isUnauthorized());

    }



    @Test
    void createFile() throws Exception {
        CreateFileDto createFileDto = new CreateFileDto(testData.getFile1());
        ReadFileDto fullVetDto = performDs2xx(create(createFileDto), ReadFileDto.class);

        Comparator.compare(createFileDto).with(fullVetDto)
                .properties()
                .all()
                .assertEqual();
    }

    @Test
    void findFile() throws Exception {
        String name = "name";
        File inputFile = testData.getFile1();
        getService().save(inputFile);
        ReadFileDto readFileDto = performDs2xx(find(name), ReadFileDto.class);
        Comparator.compare(inputFile).with(readFileDto)
                .properties()
                .all()
                .assertEqual();
    }

    @Test
    void updateFile() throws Exception {
        String name = "name";

        File file1 = getService().save(testData.getFile1());
        file1.setText("newText");
        String jsonRequest = TransactionalRapidTestUtil.createUpdateJsonRequest(
                TransactionalRapidTestUtil.createUpdateJsonLine("replace", "/text", file1.getText())
        );
        ReadFileDto readFileDto = performDs2xx(update(jsonRequest, name), ReadFileDto.class);
        Comparator.compare(file1).with(readFileDto)
                .properties()
                .all()
                .assertEqual();

        File dbFile = getService().findById(name).get();
        Comparator.compare(file1).with(dbFile)
                .properties()
                .all()
                .assertEqual();
    }

    @Test
    void deleteFile() throws Exception {
        String name = "name";
        getService().save(testData.getFile1());
        perform2xx(delete(name));
        Optional<File> dbFile = getService().findById(name);
        Assertions.assertTrue(dbFile.isEmpty());
    }

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
        RapidFindOwnUserDto userDto = performDs2xx(userControllerTestTemplate.signup(signupDto), RapidFindOwnUserDto.class);

        MockHttpServletRequestBuilder builder = post("/api/core/login")
                .param("username", testData.getTestUser1().getEmail())
                .param("password", testData.getTestUser1().getPassword())
                .header("contentType", MediaType.APPLICATION_FORM_URLENCODED);

        return getMvc().perform(builder)
                .andExpect(status().is2xxSuccessful())
                .andReturn().getResponse().getHeader(HttpHeaders.AUTHORIZATION);




//        return userControllerTestTemplate.login2xx(signupDto.getEmail(), signupDto.getPassword());
    }

    private String createUser2() throws Exception {
        SignupDto signupDto = SignupDto.builder()
                .email(testData.getTestUser2().getEmail())
                .password(testData.getTestUser2().getPassword())
                .build();
        RapidFindOwnUserDto userDto = performDs2xx(userControllerTestTemplate.signup(signupDto), RapidFindOwnUserDto.class);
        return userControllerTestTemplate.login2xx(signupDto.getEmail(), signupDto.getPassword());
    }
}

