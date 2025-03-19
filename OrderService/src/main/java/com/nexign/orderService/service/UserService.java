package com.nexign.orderService.service;

import com.nexign.orderService.dto.User;
import com.nexign.orderService.repostitory.UserEntityRepository;
import com.nexign.orderService.util.ProductEntityMapper;
import com.nexign.orderService.util.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {
    private final UserEntityRepository userRepository;
    private final UserEntityMapper userMapper;


    @Autowired
    public UserService(UserEntityRepository userRepository, UserEntityMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUser)
                .collect(Collectors.toList());
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toUser);
    }

    public User createUser(User user) {
        userRepository.save(userMapper.toEntity(user));
        return user;
    }


    public boolean deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
