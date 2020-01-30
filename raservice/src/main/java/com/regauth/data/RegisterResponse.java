package com.regauth.data;

public class RegisterResponse
{
    String status;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public static RegisterResponse getInvalid()
    {
        RegisterResponse rr = new RegisterResponse();
        rr.setStatus("invalid");
        return rr;
    }
}
