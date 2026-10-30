package com.example.demo.LoginAndRegistration.UserFactory;

import com.example.demo.Entities.UserEntities.User;
import com.example.demo.Enums.UserRole;

public class RegularUserCreator implements UserCreator
{

    @Override
    public User createUser(String login, String encodedPassword)
    {
        return new User(login, encodedPassword, UserRole.USER);
    }
}