package com.example.spring_jpa.user.repository;

import com.example.spring_jpa.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    String email = "email";
    String password = "1234";
    String username = "username";

    @BeforeEach
        //아래의 테스트가 실행되기 전에 한 번 실행하겠다.
    void setUP() {
        User user = User.builder().email(email).password(password).username(username).build();
        userRepository.save(user);
    }

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
        String email = "email2"; //외부 영향 없이 저장해야 하는 저장 로직 테스트니까 다른 거로 바꿔 넣어야 함
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
        for (int i = 0; i < 4; i++) { //이미 1개는 저장되어 있으니까 인덱스 4까지
            User user = User.builder().email(email+i).password(password).username(username).build();
            userRepository.save(user);
        }

        List<User> all = userRepository.findAll();

        assertEquals(5, all.size());
        assertEquals(email+3, all.get(4).getEmail());
    }

    @Test
    @DisplayName("이메일로 저장 후, 이메일로 조회 테스트")
    void findByEmailTest() {
        Optional<User> byEmail = userRepository.findByEmail(email);

        assertTrue(byEmail.isPresent());
        assertEquals(email,  byEmail.get().getEmail());
    }

}
