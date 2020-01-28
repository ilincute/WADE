package com.regauth.raservice;

import com.regauth.dao.UserDataDAO;
import com.regauth.data.UserData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserDataDAOTest {

    @Test
    void testCreate()
    {
        Exception ex = null;
        try
        {
            UserData metadata = new UserData();
            metadata.setId("123");
            metadata.setUserId("321");
            metadata.setActionType("action");
            metadata.setActionValue("value");

            UserDataDAO.create(metadata);
        }
        catch (Exception e)
        {
            ex = e;
        }

        assertEquals(null, ex);


    }

}
