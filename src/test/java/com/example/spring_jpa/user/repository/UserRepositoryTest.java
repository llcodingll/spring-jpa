package com.example.spring_jpa.user.repository;

import com.example.spring_jpa.user.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("빌더 테스트")
    void builderTest() {
        User user = User.builder()
                .email("email")
                .password("1234")
                .username("username")
                .build();
        assertEquals(new ArrayList<>(), user.getStores());
        assertEquals("email", user.getEmail());
    }

    @Test
    @Transactional
    void saveTest() {
        //given 이러한 값이 주어지고
        String email = "email";
        String password = "1234";
        String username = "username";

        User user = User.builder().email(email).password(password).username(username).build();

        //when 이거 실행했는데
        userRepository.save(user);

        //then 그 후 이런 값이랑 매칭이 되었다.
        assertEquals(email, user.getEmail());
        assertNotNull(user.getId());
    }

    @Test
    @DisplayName("5개 저장 후, 전부 5개가 맞는지 확인하는 테스트")
    void fiveTest() {
        String email = "email";
        String password = "1111";
        String username = "name";
        for (int i = 0; i < 5; i++) {
            User user = User.builder().email(email+i).password(password).username(username).build();
            userRepository.save(user);
        }

        List<User> all = userRepository.findAll();

        assertEquals(5, all.size());
        assertEquals(email+4, all.get(4).getEmail());
    }

    @Test
    @DisplayName("이메일로 저장 후, 이메일로 조회 테스트")
    void findByEmailTest() {
        String email = "email";
        String password = "1111";
        String username = "name";

        User user = User.builder().email(email).password(password).username(username).build();
        userRepository.save(user);

        Optional<User> byEmail = userRepository.findByEmail(email);

        assertTrue(byEmail.isPresent());
        assertEquals(email,  byEmail.get().getEmail());
    }
}
