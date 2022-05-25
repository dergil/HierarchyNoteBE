package com.example.hierarchy_notes;

import org.springframework.context.annotation.Bean;

@com.github.vincemann.springrapid.coretest.slicing.TestConfig
public class TestConfig {

    @Bean
    public TestData testData(){
        return new TestData();
    }
}
