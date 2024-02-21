package com.capitole.inditex.infrastructure.persistence;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capitole.inditex.domain.model.Price;
import com.capitole.inditex.domain.repository.PriceRepository;

@Repository
public interface JpaPriceRepository extends JpaRepository<Price, Long>, PriceRepository {
    List<Price> findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
            Long brandId, Long productId, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
