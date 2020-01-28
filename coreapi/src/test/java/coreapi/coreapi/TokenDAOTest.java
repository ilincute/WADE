package coreapi.coreapi;

import coreapi.coreapi.dao.TokenDAO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class TokenDAOTest
{

    @Test
    void testCreate()
    {


        assertNotEquals(null, TokenDAO.addForUser("1234234"));

    }
}
