package com.regauth.raservice;

import com.regauth.facades.UserFacade;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


@SpringBootTest
public class UserFacadeTest
{

    @Test
    void testAuthenticateUser()
    {
        assertNotEquals(null, UserFacade.authenticate("vasile", "s3cr3t"));
    }
}
