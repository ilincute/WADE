package coreapi.coreapi.services;

import coreapi.coreapi.data.Exponate;
import coreapi.coreapi.data.RegisterResponse;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExponateService
{

    public static final String HTTP_104_197_243_168_80_MEX_GET_ALL = "http://104.197.243.168:80/mex/getAll";

    public static List<Exponate> getAll()
            throws IOException
    {

        List<Exponate> exponates = new ArrayList<>();
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(HTTP_104_197_243_168_80_MEX_GET_ALL);
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);

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
                    body = "{exponates: " + body + "}";
                    System.out.println(body);

                    JSONObject jsonObject = new JSONObject(body);
                    Iterator<String> keyList = jsonObject.keys();
                    JSONArray arr = (JSONArray) jsonObject.get("exponates");

                    arr.forEach(element -> {
                        Exponate exponate = new Exponate();
                        exponate.setId(((JSONObject)element).getString("id"));
                        exponate.setName(((JSONObject)element).getString("name"));
                        exponate.setImage(((JSONObject)element).getString("image"));
                        exponate.setQueryName(((JSONObject)element).getString("queryName"));
                        exponates.add(exponate);
                    });



                }
                catch (JSONException err)
                {
                    throw err;
                }
            }
        }

        return exponates;
    }

    public static List<Exponate> getEmptyResponse()
    {
        List<Exponate> exponates = new ArrayList<Exponate>();
        return exponates;
    }

}
