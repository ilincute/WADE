package com.mexservice.mex.data;

import java.util.List;

public class Exponate
{
    String id;
    String Name;
    String image;
    List<ExponateData> datas;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<ExponateData> getDatas() {
        return datas;
    }

    public void setDatas(List<ExponateData> datas) {
        this.datas = datas;
    }
}
