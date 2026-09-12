package com.watchlist.repository;

import com.watchlist.entity.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TitleRepository extends JpaRepository<Title, Long> {

    Optional<Title> findByNameIgnoreCaseAndCategory(String name, String category);

    List<Title> findByCategoryAndWatchedFalse(String category);

    List<Title> findByCategory(String category);
}
