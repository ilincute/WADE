package com.mexservice.mex;

import com.mexservice.mex.dao.ExponateDAO;
import com.mexservice.mex.data.Exponate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class ExponateDAOTest
{
    @Test
    void testCreate()
    {
        Exception ex = null;
        try
        {
            Exponate exponate = new Exponate();
            exponate.setId("1234");
            exponate.setName("Gioconda");
            exponate.setImage("imgsrc");

            ExponateDAO.create(exponate);
        }
        catch (Exception e)
        {
            ex = e;
        }

        assertEquals(null, ex);
    }

    @Test
    void testGetAll()
    {
        List<Exponate> exponates = ExponateDAO.getAll();
        assertNotEquals(null, exponates);
    }

}
