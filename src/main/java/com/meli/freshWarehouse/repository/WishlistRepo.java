package com.meli.freshWarehouse.repository;

import com.meli.freshWarehouse.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepo extends JpaRepository<Wishlist, Long> {

}
