package com.capitole.inditex.domain.service;

import java.time.LocalDateTime;

import com.capitole.inditex.domain.presentation.dto.PriceDto;

public interface DefaultPriceService {
    PriceDto getPriceDetails(LocalDateTime dateTime, Long productId, Long brandId);
}
