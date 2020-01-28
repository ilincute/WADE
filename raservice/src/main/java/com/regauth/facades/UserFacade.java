package com.regauth.facades;

import com.regauth.dao.UserDAO;
import com.regauth.data.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

public class UserFacade
{
    public static void register(String userName, String lastName, String email, String password) throws Exception
    {
        User user = new User();

        user.setId(UUID.randomUUID().toString());
        user.setPassword(DigestUtils.sha256Hex(password));
        user.setUserName(userName);
        user.setEmail(email);
        user.setLastName(lastName);

        UserDAO.create(user);
    }

    public static User authenticate(String userName, String password)
    {
        User dbUser = UserDAO.getForUsername(userName);
        if (dbUser != null)
        {
            if (dbUser.getPassword().equals(DigestUtils.sha256Hex(password)))
            {
                return dbUser;
            }
        }
        return null;
    }

}
