package com.fotsfer.amazon.domain.customer.impl.basket;

import com.fotsfer.amazon.domain.customer.api.basket.BasketDto;
import com.fotsfer.amazon.domain.customer.api.basket.BasketService;
import com.fotsfer.amazon.domain.customer.api.basketProduct.BasketProductDto;
import com.fotsfer.amazon.domain.customer.api.basketProduct.BasketProductService;
import com.fotsfer.amazon.domain.product.api.product.ProductService;
import com.fotsfer.amazon.domain.product.impl.product.Product;
import com.fotsfer.amazon.domain.user.api.UserService;
import com.fotsfer.amazon.domain.user.impl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    BasketRepository repository;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    BasketProductService basketProductService;

    public BasketDto save(BasketDto basket) {
        Basket entity = repository.save(toEntity(basket));
        return toDto(entity);
    }

    @Override
    public BasketDto addBasket(BasketDto dto){
        User user = userService.findUserById(dto.getUserId());
        if(user == null){
            throw new IllegalArgumentException("User not found");
        }
        Basket basket = repository.findBasketByUser_UserIdAndStatus(user.getUserId(),Basket.BASKET_STATUS_NONE);
        if (basket == null) {
            // 1- Kullanıcının hiç sepeti yok (Yeni sepet oluştur ve ürünü ekle)
            Basket newBasket = new Basket();
            newBasket.setUser(user);
            newBasket.setStatus(Basket.BASKET_STATUS_NONE);

            Product product = productService.getProductById(dto.getProducts().get(0).getProductId());
            if (product == null) {
                throw new IllegalArgumentException("Product not found");
            }

            BasketProduct basketProduct = new BasketProduct();
            basketProduct.setProduct(product);
            basketProduct.setCount(dto.getProducts().get(0).getCount());
            basketProduct.setBasketProductAmount(product.getAmount() * basketProduct.getCount());
            basketProduct.setBasket(newBasket);

            List<BasketProduct> productList = new ArrayList<>();
            productList.add(basketProduct);
            newBasket.setBasketProductList(productList);

            // Sepetin toplam tutarını hesaplayıp set ediyoruz:
            newBasket.setAmount(basketProduct.getBasketProductAmount());

            basket = repository.save(newBasket);
        } else {
            BasketProduct basketProduct = basketProductService.exist(basket.getBasketId(), dto.getProducts().get(0).getProductId());

            Product product = productService.getProductById(dto.getProducts().get(0).getProductId());
            if (product == null) {
                throw new IllegalArgumentException("Product not found");
            }
            if (basketProduct == null) {
                // 2- Sepette ürün yok -> Yeni ürünü sepete ekle
                basketProduct = new BasketProduct();
                basketProduct.setProduct(product);
                basketProduct.setCount(dto.getProducts().get(0).getCount());
                basketProduct.setBasketProductAmount(product.getAmount() * basketProduct.getCount());
                basketProduct.setBasket(basket);

                if (basket.getBasketProductList() == null) {
                    basket.setBasketProductList(new ArrayList<>());
                }
                basket.getBasketProductList().add(basketProduct);
                basket.setAmount(totalAmount(basket));
                basket = repository.save(basket);
            } else {
                // 3- Sepette ürün var -> Adet ve ürün tutarını güncelle
                basketProduct.setCount(basketProduct.getCount() + dto.getProducts().get(0).getCount());
                basketProduct.setBasketProductAmount(product.getAmount() * basketProduct.getCount());
                basket.setAmount(totalAmount(basket));
                basket = repository.save(basket);
            }
        }
        return toDto(basket);
    }

    private BasketDto toDto(Basket basket) {
        BasketDto dto = new BasketDto();
        dto.setBasketId(basket.getBasketId());
        if (basket.getUser() != null) {
            dto.setUserId(basket.getUser().getUserId());
        }
        dto.setStatus(basket.getStatus());
        dto.setTotalPrice(basket.getAmount());

        List<BasketProductDto> productDtoList = new ArrayList<>();
        if (basket.getBasketProductList() != null) {
            for (BasketProduct bp : basket.getBasketProductList()) {
                BasketProductDto bpDto = new BasketProductDto();
                if (bp.getId() != null) {
                    bpDto.setBasketProductId(bp.getId());
                }
                bpDto.setCount(bp.getCount());
                bpDto.setBasketProductAmount(bp.getBasketProductAmount());
                if (basket.getBasketId() != null) {
                    bpDto.setBasketId(basket.getBasketId());
                }
                if (bp.getProduct() != null) {
                    bpDto.setProductId(bp.getProduct().getProductId());
                }
                productDtoList.add(bpDto);
            }
        }
        dto.setProducts(productDtoList);
        return dto;
    }

    private Basket toEntity(BasketDto dto) {
        Basket entity = new Basket();
        entity.setBasketId(dto.getBasketId());
        entity.setStatus(dto.getStatus());
        entity.setAmount(dto.getTotalPrice());
        return entity;
    }

    private double totalAmount(Basket basket){
        double total = 0;
        if (basket.getBasketProductList() != null) {
            for (BasketProduct bp : basket.getBasketProductList()) {
                total += bp.getBasketProductAmount();
            }
        }
        return total;
    }
}
