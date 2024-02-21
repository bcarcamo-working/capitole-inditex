package com.capitole.inditex.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capitole.inditex.domain.model.Price;
import com.capitole.inditex.domain.presentation.dto.PriceDto;
import com.capitole.inditex.domain.repository.PriceRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PriceService implements DefaultPriceService {

    private final PriceRepository priceRepository;

    @Override
    public PriceDto getPriceDetails(LocalDateTime dateTime, Long productId, Long brandId) {
        List<Price> prices = priceRepository.findPricesByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfter(
                brandId, productId, dateTime, dateTime);

        if (!prices.isEmpty()) {
            Price price = prices.get(0);
            return PriceDto.builder()
                    .productId(price.getProductId())
                    .brandId(price.getBrandId())
                    .priceList(price.getPriceList())
                    .startDate(price.getStartDate())
                    .endDate(price.getEndDate())
                    .price(price.getPrice())
                    .currency(price.getCurr())
                    .build();
        } else {
            log.warn("No se encontraron precios para la fecha {}, producto {} y marca {}.", dateTime, productId, brandId);
        }

        return null;
    }
}
