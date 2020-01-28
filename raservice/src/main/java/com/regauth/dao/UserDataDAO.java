package com.regauth.dao;

import com.regauth.data.User;
import com.regauth.data.UserData;
import com.regauth.dbcore.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDataDAO
{

    private static final String INSERT_FORMAT = "insert into userdata values(?, ?, ?, ?)";


    public static void create(UserData metadata)
    {

        Connection con = null;
        try
        {
            con = DBFactory.getConnection();

            PreparedStatement statement = con.prepareStatement(INSERT_FORMAT);
            statement.setQueryTimeout(30);

            statement.setString(1, metadata.getId());
            statement.setString(2, metadata.getUserId());
            statement.setString(3, metadata.getActionType());
            statement.setString(4, metadata.getActionValue());

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

    public static void update(UserData metadata)
    {

    }


    public static UserData getMetadataFor(User user)
    {
        return null;
    }
}
