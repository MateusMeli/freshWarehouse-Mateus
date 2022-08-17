package com.meli.freshWarehouse.controller;

import com.meli.freshWarehouse.dto.WishListDto;
import com.meli.freshWarehouse.exception.NotFoundException;
import com.meli.freshWarehouse.exception.SectionIdNotFoundException;
import com.meli.freshWarehouse.model.Wishlist;
import com.meli.freshWarehouse.service.WishlistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/wishlist")
public class WishlistController {

    private final WishlistService wishListService;

    public WishlistController(WishlistService wishListService) {
        this.wishListService = wishListService;
    }

    /**
     * Get all wishlists
     * @return Returns a list with all saved wishlists.
     * @see <a href="http://localhost:8080/api/v1/fresh-products/wishlist">Get all wishlists</a>
     */
    @GetMapping
    public ResponseEntity<List<Wishlist>> getAll() {
        return new ResponseEntity<>(wishListService.getAll(), HttpStatus.OK);
    }

    /**
     * Gets wishlist by id
     *
     * @return wishlist with the designed iD.
     * @throws NotFoundException When a product doesn't exist with the informed ID.
     * @see <a href="http://localhost:8080/api/v1/fresh-products/wishlist/{id}">Get the wishlist by id</a>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Wishlist> getWishlistById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(wishListService.getWishlistById(id));
    }

    /**
     * Get a  wishlist from buyer.
     *
     * @param buyerId
     * @return a wishlist
     * @throws SectionIdNotFoundException When a section doesn't exist.
     * @see <a href="http://localhost:8080/api/v1/fresh-products/wishlist/list?buyerId=FS">Get Product list by category</a>
     */
    @GetMapping("/buyer")
    public ResponseEntity<Wishlist> getWishlistFromBuyer(
            @RequestParam Long buyerId) {
        return new ResponseEntity(wishListService.getWishListFromBuyer(buyerId), HttpStatus.OK);
    }

    /**
     * Saves a new wishlist
     * @return Saves a new wishlist, returns an exception if a product ID isn't found.
     * @throws NotFoundException When a product doesn't exist.
     * @see <a href="http://localhost:8080/api/v1/fresh-products/wishlist">Saves a wishlist</a>
     */
    @PostMapping
    public ResponseEntity<Wishlist> addToWishlist(@RequestBody @Valid WishListDto wishlistDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(wishListService.addToWishlist(wishlistDto));
    }
}
