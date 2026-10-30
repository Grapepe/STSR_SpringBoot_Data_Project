package com.example.demo.LoginAndRegistration.UserFactory;

import com.example.demo.Entities.UserEntities.User;

public interface UserCreator
{
     User createUser(String login, String password);
}
