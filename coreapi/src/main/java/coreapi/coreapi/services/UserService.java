package coreapi.coreapi.services;

import coreapi.coreapi.data.RegisterResponse;
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

public class UserService
{
    public static RegisterResponse registerUser(String userName, String lastName, String email, String password)
    {
        try {
            return registerHelper(userName, lastName, email, password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static RegisterResponse registerHelper(String userName, String lastName, String email, String password)
            throws IOException {

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://35.184.201.148:80/ra/register");

        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("userName", userName));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("lastName", lastName));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        RegisterResponse rr = new RegisterResponse();
        rr.setStatus("invalid");
        if (entity != null) {
            try (InputStream instream = entity.getContent()) {
                String body = IOUtils.toString(instream, "UTF-8");

                try
                {
                    JSONObject jsonObject = new JSONObject(body);
                    rr.setStatus(jsonObject.getString("status"));
                }
                catch (JSONException err)
                {
                }
            }
        }

        return rr;
    }
}
