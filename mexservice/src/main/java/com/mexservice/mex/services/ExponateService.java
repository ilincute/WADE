package com.mexservice.mex.services;

import com.mexservice.mex.dao.ExponateDAO;
import com.mexservice.mex.data.Exponate;

import java.util.List;

public class ExponateService
{
    public static List<Exponate> getAll()
    {
        return ExponateDAO.getAll();
    }
}
