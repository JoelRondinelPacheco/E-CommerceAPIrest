package com.joel.spring.user.adapter.output.persistence;

import com.joel.spring.accounttoken.adapter.output.persistence.AccountTokenEntity;
import com.joel.spring.accounttoken.domain.AccountToken;
import com.joel.spring.cart.adapter.out.persistence.entity.CartEntity;
import com.joel.spring.cart.domain.Cart;
import com.joel.spring.user.domain.User;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("userMapper")
public class UserMapper implements Mapper<UserEntity, User> {

    @Autowired
    @Qualifier("accountTokenMapper")
    private Mapper<AccountTokenEntity, AccountToken> accountTokenMapper;
    @Autowired
    @Qualifier("cartMapper")
    private Mapper<CartEntity, Cart> cartMapper;

    @Override
    public User entityToDomain(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        return user;
    }

    @Override
    public UserEntity domainToEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setVerified(user.isVerified());

        AccountTokenEntity accountTokenEntity = this.accountTokenMapper.domainToEntity(user.getAccountToken());
        CartEntity cartEntity = this.cartMapper.domainToEntity(user.getCart());

        userEntity.setAccountToken(accountTokenEntity);
        userEntity.setCart(cartEntity);

        return userEntity;
    }
}
