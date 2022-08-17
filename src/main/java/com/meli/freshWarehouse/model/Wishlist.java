package com.meli.freshWarehouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter @Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate created_at;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    private Buyer buyer;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "wishlist_product",
            joinColumns = @JoinColumn(name = "id_wishlist", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id")
    )
    Set<Product> products;
}
