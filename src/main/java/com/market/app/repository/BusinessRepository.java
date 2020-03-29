package com.market.app.repository;

import com.market.app.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    Optional<Business> findById(Long id);

    Optional<Business> findByBusinessEmail(String email);

    List<Business> findBusinessByBusinessName(String businessName);
}
