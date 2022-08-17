package com.meli.freshWarehouse.util;

import com.meli.freshWarehouse.dto.WishListDto;
import com.meli.freshWarehouse.model.Wishlist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GenerateWishList {

    public static Wishlist newWishlist() {
        return Wishlist.builder()
                .id(1l)
                .created_at(LocalDate.now())
                .buyer(GenerateBuyer.validBuyer1())
                .products(GenerateProduct.validProductSet())
                .build();
    }

    public static Wishlist newWishlist2() {
        return Wishlist.builder()
                .id(2l)
                .created_at(LocalDate.now())
                .buyer(GenerateBuyer.validBuyer2())
                .products(GenerateProduct.validProductSet())
                .build();
    }

    public static WishListDto newWishlistDto() {
        return WishListDto.builder()
                .buyerId(1L)
                .productId(1L)
                .build();
    }

    public static List<Wishlist> newWishlists() {
        List<Wishlist> wishlists = new ArrayList<>();
        Wishlist firstWish =  Wishlist.builder()
                .id(1l)
                .created_at(LocalDate.now())
                .buyer(GenerateBuyer.validBuyer1())
                .products(GenerateProduct.validProductSet())
                .build();

        Wishlist secondWish =  Wishlist.builder()
                .id(2l)
                .created_at(LocalDate.now())
                .buyer(GenerateBuyer.validBuyer2())
                .products(GenerateProduct.validProductSet())
                .build();

        wishlists.add(firstWish);
        wishlists.add(secondWish);

        return wishlists;
    }
}
