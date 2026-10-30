package com.example.demo.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService
{
    public String store(MultipartFile file)
    {
        return "gen";
    }
}
