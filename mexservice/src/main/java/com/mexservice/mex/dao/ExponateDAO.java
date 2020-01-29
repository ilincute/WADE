package com.mexservice.mex.dao;

import com.mexservice.mex.coredb.DBFactory;
import com.mexservice.mex.data.Exponate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ExponateDAO
{

    public static final String INSERT_FORMAT = "insert into exponates values (?, ?, ?)";

    public static List<Exponate> getAll()
    {
        return null;
    }

    public static void create(Exponate exponate)
    {
        Connection con = null;

        try
        {
            con = DBFactory.getConnection();

            PreparedStatement statement = con.prepareStatement(INSERT_FORMAT);
            statement.setQueryTimeout(30);

            statement.setString(1, exponate.getId());
            statement.setString(2, exponate.getName());
            statement.setString(3, exponate.getImage());

            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (con != null) con.close();
            }
            catch(SQLException e)
            {
                System.err.println(e.getMessage());
            }
        }


    }
}
