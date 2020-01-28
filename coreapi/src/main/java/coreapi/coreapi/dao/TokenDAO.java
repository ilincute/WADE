package coreapi.coreapi.dao;

import coreapi.coreapi.coredb.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class TokenDAO
{

    public static final String INSERT_FORMAT = "insert into tokens values (?, ?)";
    public static final String DELETE_FORMAT = "delete from tokens where token = ?";
    public static final String GET_FORMAT = "select * from tokens where token = ?";

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


    public static void delete(String token)
    {
        Connection con = null;
        try
        {
            con = DBFactory.getConnection();

            PreparedStatement statement = con.prepareStatement(DELETE_FORMAT);
            statement.setString(1, token);

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

    public static boolean doesExist(String token)
    {
        Connection con = null;
        int i = 0;
        try
        {
            con = DBFactory.getConnection();
            PreparedStatement statement = con.prepareStatement(GET_FORMAT);
            statement.setString(1, token);

            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                i++;
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
                if (con != null) con.close();
            }
            catch(SQLException e)
            {
                System.err.println(e.getMessage());
            }
        }

        if (i > 0) return true;
        return false;
    }
}
