package com.example.hierarchy_notes.auth;

import com.example.hierarchy_notes.test_suite.EnableProjectComponentScan;
import com.github.vincemann.springrapid.authtests.ResetPasswordTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
@EnableProjectComponentScan
public class MyResetPasswordTest extends ResetPasswordTest {

    @Test
    @Override
    public void getDirectedToForgotPasswordPage() throws Exception {
        super.getDirectedToForgotPasswordPage();
    }
}
