package com.joel.spring.cartproduct.application.usecases;

import com.joel.spring.cartproduct.application.dto.AddProductToCartDTO;
import com.joel.spring.cart.application.dto.UpdateQuantityDTO;
import com.joel.spring.cart.application.port.input.CartSelector;
import com.joel.spring.cart.application.port.output.CartProductPersistencePort;
import com.joel.spring.cart.domain.Cart;
import com.joel.spring.cartproduct.application.port.input.CartProductsService;
import com.joel.spring.cartproduct.application.port.output.CartProductSelector;
import com.joel.spring.cartproduct.domain.CartProduct;
import com.joel.spring.product.application.port.output.ProductDomainSelectorPort;
import com.joel.spring.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CartProductServiceImpl implements CartProductsService {

    @Autowired
    private CartProductPersistencePort cartProductRepository;

    @Autowired
    @Qualifier("cartById")
    private CartSelector<String> cartById;
    @Autowired
    @Qualifier("cartProductById")
    private CartProductSelector<CartProduct, String> cartProductById;
    @Autowired
    private ProductDomainSelectorPort productRepository;

    @Override
    public String add(AddProductToCartDTO info) {
 /*
        TODO
            Chekear que la cart proporcionada pertence al usuario que hace la solicitud
         */
        Cart cart = this.cartById.get(info.getCartId());
        Product product = this.productRepository.getById(info.getProductId());

        CartProduct cartProduct = CartProduct.NewCartProduct(info.getQuantity(), product, cart);
        this.cartProductRepository.save(cartProduct);

        //TODO DEFINE RETURN
        return null;    }

    @Override
    public String delete(String cartProductId) {
        this.cartProductRepository.delete(cartProductId);
        return "Deleted";
    }

    @Override
    public String editQuantity(UpdateQuantityDTO info) {
        CartProduct cartProduct = this.cartProductById.get(info.getCartProductId());
        //TODO ACTUALIZAR, QUE EN VEZ DE CART PRODUCT RETORNE UN DTO CON LA INFO NECESARIA
        Product product = cartProduct.getProduct();

        this.updateQuantity(cartProduct, info.getQuantity(), product.getPrice());
        this.cartProductRepository.save(cartProduct);

        return "todo return message";
    }

    @Override
    public String plusQuantity(UpdateQuantityDTO info) {
        return null;
    }

    @Override
    public String minusQuantity(UpdateQuantityDTO info) {
        return null;
    }

    private void updateQuantity(CartProduct cartProduct, Long newQuantity, Double productPrice) {
        Double newPrice = newQuantity * productPrice;
        cartProduct.setPrice(newPrice);
    }
}
