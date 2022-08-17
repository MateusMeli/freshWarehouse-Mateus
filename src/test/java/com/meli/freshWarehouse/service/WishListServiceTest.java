package com.meli.freshWarehouse.service;

import com.meli.freshWarehouse.exception.NotFoundException;
import com.meli.freshWarehouse.model.Wishlist;
import com.meli.freshWarehouse.repository.WishlistRepo;
import com.meli.freshWarehouse.util.GenerateBuyer;
import com.meli.freshWarehouse.util.GenerateProduct;
import com.meli.freshWarehouse.util.GenerateWishList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class WishListServiceTest {
    @InjectMocks
    private WishlistService wishlistService;

    @Mock
    private BuyerService buyerService;

    @Mock
    private ProductService productService;

    @Mock
    private WishlistRepo wishlistRepo;

    @Test
    void getAllWishLists() {

        List<Wishlist> wishlists = List.of(GenerateWishList.newWishlist(), GenerateWishList.newWishlist());
        BDDMockito.when(wishlistRepo.findAll()).thenReturn(wishlists);
        List<Wishlist> wishlistListResponse = wishlistService.getAll();
        assertThat(wishlistListResponse).isNotNull();
        assertThat(wishlistListResponse.size()).isEqualTo(2);
        verify(wishlistRepo, Mockito.times(1)).findAll();
    }

    @Test
    void getWishlistById_when_IdIsValid() {
        BDDMockito.when(wishlistRepo.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.ofNullable(GenerateWishList.newWishlist()));

        Wishlist wishlistResponse = wishlistService.getWishlistById(GenerateWishList.newWishlist().getId());

        assertThat(wishlistResponse).isNotNull();
        assertThat(wishlistResponse.getId()).isEqualTo(1L);

    }

    @Test
    void return_NotFoundException_when_IdIsNotValid() {
        String expectedMessage = "Can't find Wishlist with the informed id";

        Exception exception = assertThrows(NotFoundException.class,
                () -> wishlistService.getWishlistById(3L).getId());

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    void get_Wishlist_from_Buyer_WhenExists() {
        BDDMockito.when(buyerService.getBuyerById(ArgumentMatchers.anyLong()))
                .thenReturn(GenerateBuyer.validBuyer1());

        BDDMockito.when(wishlistRepo.findAll())
                .thenReturn(GenerateWishList.newWishlists());

        Wishlist wishlistResponse = wishlistService.getWishListFromBuyer(1l);

        assertThat(wishlistResponse).isNotNull();
    }

    @Test
    void get_Wishlist_from_Buyer_WhenNotExists() {
        Wishlist wishlistResponse = wishlistService.getWishListFromBuyer(1l);

        assertThat(wishlistResponse).isNull();

    }

    @Test
    void addToWishlist_whenBuyer_hasWishlist() {
        BDDMockito.when(buyerService.getBuyerById(ArgumentMatchers.anyLong()))
                .thenReturn(GenerateBuyer.validBuyer1());

        BDDMockito.when(productService.getProductById(ArgumentMatchers.anyLong()))
                .thenReturn(GenerateProduct.validFreshProduct());

        BDDMockito.when(wishlistRepo.save(ArgumentMatchers.any()))
                .thenReturn(GenerateWishList.newWishlist());


        Wishlist wishlistResponse = wishlistService.addToWishlist(GenerateWishList.newWishlistDto());

        assertThat(wishlistResponse).isNotNull();
    }

    @Test
    void addToWishlist_whenBuyer_DoesntHaveWishlist() {
        BDDMockito.when(buyerService.getBuyerById(ArgumentMatchers.anyLong()))
                .thenReturn(GenerateBuyer.validBuyer2());

        BDDMockito.when(productService.getProductById(ArgumentMatchers.anyLong()))
                .thenReturn(GenerateProduct.validFreshProduct());

        BDDMockito.when(wishlistRepo.save(ArgumentMatchers.any()))
                .thenReturn(GenerateWishList.newWishlist());


        Wishlist wishlistResponse = wishlistService.addToWishlist(GenerateWishList.newWishlistDto());

        assertThat(wishlistResponse).isNotNull();
        verify(wishlistRepo, Mockito.times(1)).save(ArgumentMatchers.any());
    }
}
