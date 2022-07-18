package com.example.hierarchy_notes.auth;

import com.example.hierarchy_notes.test_suite.EnableProjectComponentScan;
import com.github.vincemann.springrapid.authtests.ChangeEmailTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
@EnableProjectComponentScan
public class MyChangeEmailTest extends ChangeEmailTest {

    @Test
    @Override
    public void canChangeOwnEmail() throws Exception {
        super.canChangeOwnEmail();
    }
}
