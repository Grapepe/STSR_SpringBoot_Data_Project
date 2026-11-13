package com.example.demo.Controllers;

import com.example.demo.Enums.GameResourceType;
import com.example.demo.Services.GameResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameResourceController
{
    private final GameResourceService resourceService;

    @PostMapping(value = "/{gameId}/resources", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadResource(@PathVariable Long gameId,
                                            @RequestParam("file") MultipartFile file,
                                            @RequestParam("title") String title,
                                            @RequestParam("type") GameResourceType type)
    {
        resourceService.upload(gameId, file, title, type);
        return ResponseEntity.ok().build();
    }
}
