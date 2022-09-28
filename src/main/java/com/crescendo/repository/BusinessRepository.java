package com.crescendo.repository;

import com.crescendo.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BusinessRepository extends JpaRepository<Business, Long> {

}
