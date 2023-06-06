package de.neuefische.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rick-and-morty")
@RequiredArgsConstructor
public class RickController {

    private final RickService rickService;

    @GetMapping("/characters")
    public List<RickCharacter> getRickCharacters() {
        return rickService.getRickCharacters();
    }


}
