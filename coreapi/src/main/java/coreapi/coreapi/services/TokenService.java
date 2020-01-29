package coreapi.coreapi.services;

import coreapi.coreapi.dao.TokenDAO;
import coreapi.coreapi.data.User;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TokenService
{

    public static boolean check(String token)
    {
        return TokenDAO.doesExist(token);
    }

    public static String getTokenForUser(String username, String password)
    {
        try
        {
            String token = UUID.randomUUID().toString();
            User user = helperGetUser(username, password);

            if (user.getUserName().equals("fail"))
            {
                return null;
            }

            TokenDAO.addForUser(user.getId(), token);

            return token;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    private static User helperGetUser(String username, String password) throws IOException
    {

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://35.184.201.148:80/ra/authenticate");

        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("userName", username));
        params.add(new BasicNameValuePair("password", password));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        User user = null;
        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                // do something useful
                String body = IOUtils.toString(instream, "UTF-8");

                try
                {
                    user = new User();
                    JSONObject jsonObject = new JSONObject(body);
                    user.setUserName(jsonObject.getString("userName"));
                    user.setEmail(jsonObject.getString("email"));
                    user.setLastName(jsonObject.getString("lastName"));
                    user.setId(jsonObject.getString("id"));
                }
                catch (JSONException err)
                {
                }
            }
        }

        return user;
    }


}
