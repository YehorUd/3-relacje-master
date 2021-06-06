package com.example.demo.repository;

import com.example.demo.model.Odznaka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdznakaRepository extends JpaRepository<Odznaka, Integer > {
    Odznaka findByNumerOdznaki(String numerOdznaki);
}
