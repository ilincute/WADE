package coreapi.coreapi;

import coreapi.coreapi.dao.TokenDAO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TokenDAOTest
{

    @Test
    void testCreate()
    {

        Exception ex = null;
        try
        {
            TokenDAO.addForUser("1234234");
        }
        catch (Exception e)
        {
            ex = e;
        }

        assertEquals(null, ex);

    }
}
