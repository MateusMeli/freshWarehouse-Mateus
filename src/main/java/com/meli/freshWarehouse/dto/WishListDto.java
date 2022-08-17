package com.meli.freshWarehouse.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class WishListDto {

    Long buyerId;

    Long productId;
}
