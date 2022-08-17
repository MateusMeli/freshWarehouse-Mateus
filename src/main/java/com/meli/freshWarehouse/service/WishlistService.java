package com.meli.freshWarehouse.service;

import com.meli.freshWarehouse.dto.WishListDto;
import com.meli.freshWarehouse.exception.NotFoundException;
import com.meli.freshWarehouse.model.Buyer;
import com.meli.freshWarehouse.model.Product;
import com.meli.freshWarehouse.model.Wishlist;
import com.meli.freshWarehouse.repository.WishlistRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class WishlistService implements IWishlistService{

    private final WishlistRepo wishlistRepo;
    private final BuyerService buyerService;
    private final ProductService productService;

    public WishlistService(WishlistRepo wishlistRepo, BuyerService buyerService, ProductService productService) {
        this.wishlistRepo = wishlistRepo;
        this.buyerService = buyerService;
        this.productService = productService;
    }

    @Override
    public List<Wishlist> getAll() {
        return wishlistRepo.findAll();
    }

    @Override
    public Wishlist getWishlistById(Long id) {
        return wishlistRepo.findById(id).orElseThrow(() ->
                new NotFoundException("Can't find Wishlist with the informed id"));
    }

    @Override
    public Wishlist getWishListFromBuyer(Long buyerId) {
        Buyer buyer = buyerService.getBuyerById(buyerId);
        List<Wishlist> wishlists;
        Wishlist wishlistFromBuyer;
        wishlists = wishlistRepo.findAll();
        wishlistFromBuyer = wishlists.stream()
                .filter(w -> buyer.getId().equals(w.getBuyer().getId()))
                .findAny()
                .orElse(null);

        return wishlistFromBuyer;
    }

    @Override
    public Wishlist addToWishlist(WishListDto wishlistDto) {
        Buyer buyer = buyerService.getBuyerById(wishlistDto.getBuyerId());
        Product product = productService.getProductById(wishlistDto.getProductId());
        Wishlist wishlist = this.getWishListFromBuyer(buyer.getId());
        Set<Product> actualProductList;
        Set<Product> newProductList = new HashSet<>();
        newProductList.add(product);
        LocalDate currentDate = LocalDate.now();
        if (wishlist != null) {
            actualProductList = wishlist.getProducts();
            actualProductList.add(product);
            wishlist.setProducts(actualProductList);
        }
        else {
            wishlist = Wishlist.builder()
                    .created_at(currentDate)
                    .buyer(buyer)
                    .products(newProductList)
                    .build();
        }
        return wishlistRepo.save(wishlist);
    }
}
