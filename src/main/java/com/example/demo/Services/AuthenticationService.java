package com.example.demo.Services;

import com.example.demo.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//@Bean
//public PasswordEncoder passwordEncoder()
//{
//    return new BCryptPasswordEncoder();
//}
@Service
@RequiredArgsConstructor
public class AuthenticationService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register()
    {

    }

    public void login()
    {

    }
}
