package com.regauth.dao;

import com.regauth.data.User;
import com.regauth.dbcore.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO
{
    private static final String INSERT_FORMAT = "insert into user values(?, ?, ?, ?, ?)";

    public static void create(User user)
    {
        Connection con = null;
        try
        {
            con = DBFactory.getConnection();

            PreparedStatement statement = con.prepareStatement(INSERT_FORMAT);
            statement.setQueryTimeout(30);
            statement.setString(1, user.getId());
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());

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
                if(con != null)
                    con.close();
            }
            catch(SQLException e)
            {
                System.err.println(e.getMessage());
            }
        }

    }


    public static User getForUsername(String username)
    {
        return null;
    }

    public static void update(User user)
    {

    }
}
