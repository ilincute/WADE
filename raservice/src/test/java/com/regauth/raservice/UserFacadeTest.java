package com.regauth.raservice;

import com.regauth.facades.UserFacade;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class UserFacadeTest
{

    @Test
    void testAuthenticateUser()
    {
        assertEquals(true, UserFacade.authenticate("vasile", "s3cr3t"));
        assertEquals(false, UserFacade.authenticate("vasile", "s3cr3tt"));
    }
}
