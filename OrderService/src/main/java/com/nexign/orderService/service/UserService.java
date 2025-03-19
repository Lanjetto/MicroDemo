package com.nexign.orderService.service;

import com.nexign.orderService.dto.User;
import com.nexign.orderService.repostitory.UserEntityRepository;
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

    @Autowired
    public UserService(UserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserEntityMapper.INSTANCE::toUser)
                .collect(Collectors.toList());
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id)
                .map(UserEntityMapper.INSTANCE::toUser);
    }

    public User createUser(User user) {
        userRepository.save(UserEntityMapper.INSTANCE.toEntity(user));
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
