package com.example.demo.Services;

import com.example.demo.Enums.GameResourceType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GameResourceService {
    public void up() {
    }

    public void upload(Long gameId, MultipartFile file,
                       String title, GameResourceType type) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED
        );
    }
}
