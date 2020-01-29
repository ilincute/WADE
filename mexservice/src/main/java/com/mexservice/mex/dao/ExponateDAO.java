package com.mexservice.mex.dao;

import com.mexservice.mex.coredb.DBFactory;
import com.mexservice.mex.data.Exponate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExponateDAO
{

    public static final String INSERT_FORMAT = "insert into exponates values (?, ?, ?, ?)";
    public static final String SELECT_FORMAT = "select * from exponates";

    public static List<Exponate> getAll()
    {
        Connection con = null;
        List<Exponate> exponates = null;

        try
        {
            con = DBFactory.getConnection();

            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);

            ResultSet rs = statement.executeQuery(SELECT_FORMAT);
            exponates = new ArrayList<>();
            while(rs.next())
            {
                Exponate exponate = new Exponate();
                exponate.setName(rs.getString("name"));
                exponate.setQueryName(rs.getString("queryName"));
                exponate.setId(rs.getString("id"));
                exponate.setImage(rs.getString("image"));

                exponates.add(exponate);
            }

            return exponates;
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

        return exponates;
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
            statement.setString(4, exponate.getQueryName());

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
