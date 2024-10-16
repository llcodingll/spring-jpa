package com.example.spring_jpa.user.service;

import com.example.spring_jpa.user.domain.User;
import com.example.spring_jpa.user.repository.UserRepository;
import com.example.spring_jpa.user.request.UserRequest;
import com.example.spring_jpa.user.response.UserResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public UserResponse createUser(UserRequest request) {
        User entity = request.toEntity();
        userRepository.save(entity);
        return UserResponse.from(entity);
    }

    @Override
    @Transactional
    public UserResponse updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id).orElseThrow();
        user.update(request);
        return UserResponse.from(user);
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow();
        return UserResponse.from(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::from)
                .toList();
    }
}