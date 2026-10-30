package com.example.demo.Services;

import com.example.demo.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//@Bean
//public PasswordEncoder passwordEncoder()
//{
//    return new BCryptPasswordEncoder();
//}

@Service
public class AuthenticationService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void register()
    {

    }

    public void login()
    {

    }
}
