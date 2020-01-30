package com.regauth.raservice;

import com.regauth.dao.UserDataDAO;
import com.regauth.data.User;
import com.regauth.data.UserData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class UserDataDAOTest
{

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

    @Test
    void testUpdate()
    {
        Exception ex = null;
        try
        {
            UserData metadata = new UserData();
            metadata.setId("123");
            metadata.setUserId("321");
            metadata.setActionType("@ction");
            metadata.setActionValue("valasdasue");


            UserDataDAO.update(metadata);
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
        User user = new User();
        user.setId("321");
        List<UserData> metadatas = UserDataDAO.getMetadataFor(user);

        assertNotEquals(null, metadatas);
    }

}
