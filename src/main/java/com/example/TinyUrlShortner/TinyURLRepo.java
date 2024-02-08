package com.example.TinyUrlShortner;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TinyURLRepo extends JpaRepository<TinyURL, Long> {

  Optional<TinyURL> findByHashKey(String hashKey);
}
