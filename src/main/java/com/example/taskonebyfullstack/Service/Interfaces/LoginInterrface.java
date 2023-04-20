package com.example.taskonebyfullstack.Service.Interfaces;

public interface LoginInterrface  {
    public Boolean UserAuthantication(String username, String password);
    public int GetTheIdByUserName(String Username);
}
