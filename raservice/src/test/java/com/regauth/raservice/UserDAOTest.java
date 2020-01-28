package com.regauth.raservice;

import com.regauth.dao.UserDAO;
import com.regauth.data.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserDAOTest
{

    @Test
    void testCreate()
    {
        Exception ex = null;
        try
        {
            User user = new User();
            user.setId("sdasd");
            user.setUserName("foo");
            user.setLastName("vasile");
            user.setEmail("foo@foo.fo");
            user.setPassword("s3cr3t");

            UserDAO.create(user);
        }
        catch (Exception e)
        {
            ex = e;
        }

        assertEquals(null, ex);
    }


    @Test
    void testGet()
    {
        User user = UserDAO.getForUsername("foo");
        assertEquals(user.getId(), "sdasd");
        assertEquals(user.getUserName(),"foo" );
        assertEquals(user.getLastName(),"vasile" );
        assertEquals(user.getEmail(), "foo@foo.fo");
        assertEquals(user.getPassword(), "s3cr3t");

    }
}
