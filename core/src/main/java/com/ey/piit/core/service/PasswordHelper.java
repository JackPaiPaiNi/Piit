package com.ey.piit.core.service;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ey.piit.core.entity.User;

/**
 * <p>User: wuyingjie
 * 不能使用@Service注解，测试发现@Value会直接取括号中的字符串
 */
@Component
public class PasswordHelper {

    @Value("${password.algorithmName}")
    private String algorithmName;
    
    @Value("${password.hashIterations}")
    private String hashIterations;

    public void encryptPassword(User user) {

        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                null,
                Integer.valueOf(hashIterations)).toHex();

        user.setPassword(newPassword);
    }
}
