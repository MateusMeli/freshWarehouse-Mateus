package com.meli.freshWarehouse.util;

import com.meli.freshWarehouse.model.Buyer;
import com.meli.freshWarehouse.model.Seller;

public class GenerateBuyer {

    public static final Buyer validBuyer1() {

        return Buyer.builder()
                .id(1L)
                .name("New Buyer")
                .build();
    }

    public static final Buyer validBuyer2() {

        return Buyer.builder()
                .id(2L)
                .name("Other Buyer")
                .build();
    }
}
