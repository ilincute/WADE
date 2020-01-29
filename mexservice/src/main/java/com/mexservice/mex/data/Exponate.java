package com.mexservice.mex.data;

import java.util.List;

public class Exponate
{
    String id;
    String name;
    String queryName;
    String image;
    List<ExponateData> datas;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }
}
