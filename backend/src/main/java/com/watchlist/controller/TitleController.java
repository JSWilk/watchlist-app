package com.watchlist.controller;

import com.watchlist.dto.AddTitleRequest;
import com.watchlist.entity.Title;
import com.watchlist.service.TitleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/titles")
public class TitleController {

    private final TitleService titleService;

    public TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping
    public List<Title> getAllTitlesByCategory(@RequestParam String category) {
        return titleService.getAllTitlesByCategory(category);
    }

    @GetMapping("/random")
    public Title getRandomTitle(@RequestParam String category,
                                 @RequestParam(required = false) Long watchlistId) {
        if (watchlistId != null) {
            return titleService.getRandomTitle(watchlistId);
        }
        return titleService.getRandomTitle(category);
    }

    @PostMapping
    public Title addTitle(@RequestBody AddTitleRequest request) {
        Title title = new Title();
        title.setName(request.name());
        title.setCategory(request.category());
        title.setLengthMinutes(request.lengthMinutes());
        title.setProvider(request.provider());
        return titleService.addTitleToWatchlists(title, request.watchlistIds());
    }

    @PutMapping("/{id}")
    public Title updateTitle(@PathVariable Long id, @RequestBody Title newTitle) {
        Title oldTitle = titleService.getTitleById(id);
        return titleService.editTitle(oldTitle, newTitle);
    }

    @DeleteMapping("/{id}")
    public void deleteTitle(@PathVariable Long id) {
        titleService.deleteTitleById(id);
    }
}
