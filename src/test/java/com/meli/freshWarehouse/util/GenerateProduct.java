package com.meli.freshWarehouse.util;

import com.meli.freshWarehouse.dto.ProductDTO;
import com.meli.freshWarehouse.dto.ProductStockResponseDTO;
import com.meli.freshWarehouse.dto.WarehouseForProductStockResponseDTO;
import com.meli.freshWarehouse.model.Batch;
import com.meli.freshWarehouse.model.Product;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class GenerateProduct {

    public final static Product newProduct1() {

        return Product.builder()
                .name("Toddy")
                .price(10.0)
                .seller(GenerateSeller.validSeller1())
                .sections(GenerateSection.validSectionList())
                .build();

    }

    public final static ProductDTO newProductDto1() {

        Set<Long> longSet = new HashSet<>();
        longSet.add(1l);

        return ProductDTO.builder()
                .name("Toddy")
                .price(10.0)
                .sectionsId(longSet)
                .sellerId(1L)
                .build();
    }


    public final static Product newProduct() {

        return Product.builder()
                .id(1L)
                .name("Milk")
                .price(8.0)
                .seller(GenerateSeller.validSeller2())
                .sections(GenerateSection.validSectionList())
                .build();
    }

    public final static Product validProduct1(){

        return Product.builder()
                .id(1L)
                .name("Toddy")
                .price(10.0)
                .seller(GenerateSeller.validSeller1())
                .sections(GenerateSection.validSectionList())
                .build();
    }


    public final static Product responseProduct(){

        return Product.builder()
                .id(1L)
                .name("New Product")
                .price(10.0)
                .seller(GenerateSeller.validSeller1())
                .sections(GenerateSection.validSectionList())
                .build();
    }

    public final static Product validProductToException1(){

        return Product.builder()
                .id(1L)
                .name("Toddy")
                .price(10.0)
                .seller(GenerateSeller.validSeller1())
                .sections(GenerateSection.validSectionListToException())
                .build();
    }

    public final static Product validProduct1WithListBatch(){

        Set<Batch> batchList = new HashSet<>();

        Batch batchResponse1 = Batch.builder()
                .id(1L)
                .minimumTemperature(25F)
                .currentTemperature(14F)
                .initialQuantity(2)
                .currentQuantity(2)
                .manufacturingDate(LocalDate.parse("2021-06-03"))
                .manufacturingTime(LocalDateTime.parse("2021-06-03T14:24:54"))
                .dueDate(LocalDate.parse("2022-11-24"))
                .order(GenerateOrder.validOrder1())
                .section(GenerateSection.validSection1())
                .product(GenerateProduct.validProduct1())
                .build();

        Batch batchResponse2 = Batch.builder()
                .id(2L)
                .minimumTemperature(15F)
                .currentTemperature(18F)
                .initialQuantity(4)
                .currentQuantity(5)
                .manufacturingDate(LocalDate.parse("2021-06-03"))
                .manufacturingTime(LocalDateTime.parse("2021-06-03T14:24:54"))
                .dueDate(LocalDate.parse("2022-11-12"))
                .order(GenerateOrder.validOrder1())
                .section(GenerateSection.validSection1())
                .product(GenerateProduct.validProduct1())
                .build();

        batchList.add(batchResponse1);
        batchList.add(batchResponse2);

        return Product.builder()
                .id(1L)
                .name("Toddy")
                .price(10.0)
                .seller(GenerateSeller.validSeller1())
                .sections(GenerateSection.validSectionList())
                .listBatch(batchList)
                .build();
    }

    public final static Product validProduct1WithListBatchWithDueDateLessThen3weeks(){

        Set<Batch> batchList = new HashSet<>();

        Batch batchResponse1 = Batch.builder()
                .id(1L)
                .minimumTemperature(25F)
                .currentTemperature(14F)
                .initialQuantity(2)
                .currentQuantity(2)
                .manufacturingDate(LocalDate.parse("2021-06-03"))
                .manufacturingTime(LocalDateTime.parse("2021-06-03T14:24:54"))
                .dueDate(LocalDate.parse("2021-11-24"))
                .order(GenerateOrder.validOrder1())
                .section(GenerateSection.validSection1())
                .product(GenerateProduct.validProduct1())
                .build();

        Batch batchResponse2 = Batch.builder()
                .id(2L)
                .minimumTemperature(15F)
                .currentTemperature(18F)
                .initialQuantity(4)
                .currentQuantity(5)
                .manufacturingDate(LocalDate.parse("2021-06-03"))
                .manufacturingTime(LocalDateTime.parse("2021-06-03T14:24:54"))
                .dueDate(LocalDate.parse("2021-11-12"))
                .order(GenerateOrder.validOrder1())
                .section(GenerateSection.validSection1())
                .product(GenerateProduct.validProduct1())
                .build();

        batchList.add(batchResponse1);
        batchList.add(batchResponse2);

        return Product.builder()
                .id(1L)
                .name("Toddy")
                .price(10.0)
                .seller(GenerateSeller.validSeller1())
                .sections(GenerateSection.validSectionList())
                .listBatch(batchList)
                .build();
    }

    public final static Product validProductToException2(){

        Set<Batch> batchList = new HashSet<>();

        Batch batchResponse1 = Batch.builder()
                .id(1L)
                .minimumTemperature(25F)
                .currentTemperature(14F)
                .initialQuantity(2)
                .currentQuantity(2)
                .manufacturingDate(LocalDate.parse("2021-06-03"))
                .manufacturingTime(LocalDateTime.parse("2021-06-03T14:24:54"))
                .dueDate(LocalDate.parse("2021-11-24"))
                .order(GenerateOrder.validOrder1())
                .section(GenerateSection.validSectionToExpection1())
                .product(GenerateProduct.validProduct1())
                .build();

        batchList.add(batchResponse1);

        return Product.builder()
                .id(1L)
                .name("Toddy")
                .price(10.0)
                .seller(GenerateSeller.validSeller1())
                .sections(GenerateSection.validSectionList())
                .listBatch(batchList)
                .build();
    }

    public final static Product validProduct2(){

        return Product.builder()
                .id(2L)
                .name("Leite")
                .price(8.0)
                .seller(GenerateSeller.validSeller2())
                .sections(GenerateSection.validSectionList())
                .build();
    }

    public final static ProductDTO validProductDto()
    {
        Set<Long> longSet = new HashSet<>();
        longSet.add(1l);

        return ProductDTO.builder()
                .name("Milk")
                .price(8.0)
                .sectionsId(longSet)
                .sellerId(1L)
                .build();
    }

    public final static Product validFreshProduct(){

        return Product.builder()
                .id(3L)
                .name("Milk")
                .price(10.0)
                .seller(GenerateSeller.validSeller2())
                .sections(GenerateSection.validFreshSectionList())
                .build();
    }


    public final static ProductStockResponseDTO productStockResponseDTOAvailableInStock() {
        return ProductStockResponseDTO.builder()
                .productId(1L)
                .warehouses(Arrays.asList(
                        WarehouseForProductStockResponseDTO.builder()
                                .warehouseId(1L)
                                .totalQuantity(4L)
                                .build(),
                        WarehouseForProductStockResponseDTO.builder()
                                .warehouseId(2L)
                                .totalQuantity(4L)
                                .build()
                ))
                .build();
    }

    public final static ProductStockResponseDTO productStockResponseDTONotAvailableInStock() {
        return ProductStockResponseDTO.builder()
                .productId(1L)
                .warehouses(Arrays.asList(
                        WarehouseForProductStockResponseDTO.builder()
                                .warehouseId(1L)
                                .totalQuantity(0L)
                                .build(),
                        WarehouseForProductStockResponseDTO.builder()
                                .warehouseId(2L)
                                .totalQuantity(0L)
                                .build()
                ))
                .build();
    }

    public static final List<Product> validProductList() {

        List<Product> productList = new ArrayList<>();
        productList.add(Product.builder()
                .id(1L)
                .name("Toddy")
                .price(10.0)
                .seller(GenerateSeller.validSeller1())
                .sections(GenerateSection.validSectionList())
                .build());

        productList.add(Product.builder()
                .id(2L)
                .name("Leite")
                .price(15.0)
                .seller(GenerateSeller.validSeller1())
                .sections(GenerateSection.validSectionList())
                .build());

        return productList;
    }

    public static final Set<Product> validProductSet() {

        Set<Product> productList = new HashSet<>();
        productList.add(Product.builder()
                .id(1L)
                .name("Toddy")
                .price(10.0)
                .seller(GenerateSeller.validSeller1())
                .sections(GenerateSection.validSectionList())
                .build());

        productList.add(Product.builder()
                .id(2L)
                .name("Leite")
                .price(15.0)
                .seller(GenerateSeller.validSeller1())
                .sections(GenerateSection.validSectionList())
                .build());

        return productList;
    }
}
