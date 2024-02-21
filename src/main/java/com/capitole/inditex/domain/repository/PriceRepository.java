package com.capitole.inditex.domain.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capitole.inditex.domain.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findPricesByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(
            Long brandId, Long productId, LocalDateTime start, LocalDateTime end);
}
