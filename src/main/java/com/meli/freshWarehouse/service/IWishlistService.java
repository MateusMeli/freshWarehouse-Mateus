package com.meli.freshWarehouse.service;

import com.meli.freshWarehouse.dto.WishListDto;
import com.meli.freshWarehouse.model.Wishlist;

import java.util.List;

public interface IWishlistService {
    List<Wishlist> getAll();
    Wishlist getWishlistById(Long id);
    Wishlist getWishListFromBuyer(Long buyerId);
    Wishlist addToWishlist(WishListDto wishlistDto);


}
