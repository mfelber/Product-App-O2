package com.o2.felber.product_app.dto;

import java.math.BigDecimal;

public record ProductDto (
    Long id,
    String nameSk,
    BigDecimal price,
    boolean enabled
) {
}
