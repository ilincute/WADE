package com.regauth.dao;

import com.regauth.data.User;
import com.regauth.dbcore.DBFactory;

import java.sql.*;

public class UserDAO
{
    private static final String INSERT_FORMAT = "insert into user values(?, ?, ?, ?, ?)";
    private static final String SELECT_FORMAT = "select * from user where userName = ?";

    private static final String USER_ATTR_ID = "id";
    private static final String USER_ATTR_USER_NAME = "userName";
    private static final String USER_ATTR_LAST_NAME = "lastName";
    private static final String USER_ATTR_EMAIL = "email";
    private static final String USER_ATTR_PASSWORD = "password";

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
        Connection con = null;
        User user = null;

        try
        {
            con = DBFactory.getConnection();
            PreparedStatement statement = con.prepareStatement(SELECT_FORMAT);
            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) // match only the first result
            {
                user = new User();

                user.setId(rs.getString(USER_ATTR_ID));
                user.setUserName(rs.getString(USER_ATTR_USER_NAME));
                user.setLastName(rs.getString(USER_ATTR_LAST_NAME));
                user.setEmail(rs.getString(USER_ATTR_EMAIL));
                user.setPassword(rs.getString(USER_ATTR_PASSWORD));

            }

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
        return user;
    }

    public static void update(User user)
    {

    }
}
