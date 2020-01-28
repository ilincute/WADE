package coreapi.coreapi;

import coreapi.coreapi.dao.TokenDAO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class TokenDAOTest
{
    @Test
    void testCreate()
    {
        assertNotEquals(null, TokenDAO.addForUser("1234234"));
    }

    @Test
    void testDelete()
    {
        Exception ex = null;
        try
        {
            TokenDAO.delete("9cb555f0-3afa-4b75-97b1-05d43d9451fd");
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
        assertEquals(true, TokenDAO.doesExist("4f0dccea-aac9-4cec-b411-83a7cdb79b64"));
    }
}
