package coreapi.coreapi.dao;

import coreapi.coreapi.coredb.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class TokenDAO
{

    public static final String INSERT_FORMAT = "insert into tokens values (?, ?)";

    public static String addForUser(String userId)
    {
        Connection con = null;
        String token = null;
        try
        {
            con = DBFactory.getConnection();

            PreparedStatement statement = con.prepareStatement(INSERT_FORMAT);
            statement.setQueryTimeout(30);
            statement.setString(1, userId);
            token = UUID.randomUUID().toString();
            statement.setString(2, token);

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


        return token;
    }

}
