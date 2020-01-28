package com.regauth.raservice;

import com.regauth.dao.UserDAO;
import com.regauth.data.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDAOTest
{

    @Test
    void testCreate()
    {

        // not really a test, more of a errors checker
        User user = new User();
        user.setId("sdasd");
        user.setUserName("foo");
        user.setLastName("vasile");
        user.setEmail("foo@foo.fo");
        user.setPassword("s3cr3t");

        UserDAO.create(user);



    }
}
