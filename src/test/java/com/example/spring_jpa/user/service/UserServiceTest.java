package com.example.spring_jpa.user.service;

import com.example.spring_jpa.user.domain.User;
import com.example.spring_jpa.user.repository.UserRepository;
import com.example.spring_jpa.user.request.UserRequest;
import com.example.spring_jpa.user.response.UserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserServiceTest {
    @Test
    void createUser() {

        UserResponse createUser = userService.createUser(new UserRequest("email", "password", "username"));

    }

    @Nested
    class GetUserById {
        @Test
        @DisplayName("성공")
        void getUserById() {
            Long id = users.get(0).getId();

            UserResponse userById = userService.getUserById(id);

            assertNotNull(userById);
            assertEquals(id, userById.id());
            assertEquals(users.get(0).getEmail(), userById.email());
        }

        @Test
        @DisplayName("실패: 못 찾는 경우, NoSuchElementException 발생")
        void getUserById_failure_not_found() {
            Long id = 93571L;

            assertThrows(NoSuchElementException.class,
                    () -> userService.getUserById(id));
        }
    }


    @Test
    void getAllUsers() {

        List<UserResponse> allUsers = userService.getAllUsers();

        assertEquals(10, allUsers.size());
        assertEquals(users.get(0).getId(), allUsers.get(0).id());
    }



    String email = "www@gmail.com";
    String password = "1234";
    String username = "admin";
    List<User> users;
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUP() {
        userService = new UserServiceImpl(userRepository);
        users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = User.builder()
                    .email(email+i)
                    .password(password)
                    .username(username+i)
                    .build();
            users.add(user);
        }
        userRepository.saveAll(users); //list를 넣으면 전체가 한 번에 저장됨
    }
}
