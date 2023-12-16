package com.app.carcollector.repository;

import com.app.carcollector.entity.Body;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodyRepository extends JpaRepository <Body, Long> {}
