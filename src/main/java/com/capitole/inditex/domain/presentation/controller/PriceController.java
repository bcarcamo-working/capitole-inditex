package com.capitole.inditex.domain.presentation.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.inditex.domain.presentation.dto.PriceDto;
import com.capitole.inditex.domain.service.DefaultPriceService;

@RestController
@RequestMapping("/api/prices")
public class PriceController {
	private final DefaultPriceService priceService;

    @Autowired
    public PriceController(DefaultPriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<PriceDto> getPriceDetails(
            @RequestParam LocalDateTime dateTime,
            @RequestParam Long productId,
            @RequestParam Long brandId) {
    	System.out.println("Request received: dateTime=" + dateTime + ", productId=" + productId + ", brandId=" + brandId);
        PriceDto priceDetails = priceService.getPriceDetails(dateTime, productId, brandId);

        if (priceDetails != null) {
            return ResponseEntity.ok(priceDetails);
        } else {
            return ResponseEntity.ok().build();
        }
    }

}
