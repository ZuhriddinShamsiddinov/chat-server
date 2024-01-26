package uz.boom.chatserver.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import uz.boom.chatserver.mappers.UserMapper;
import uz.boom.chatserver.repository.UserRepository;

import static org.mockito.Mockito.verify;


/**
 * @author - 'Zuhriddin Shamsiddionov' at 10:10 AM 10/13/22 on Thursday in October
 */
@ExtendWith(MockitoExtension.class)
@DataJpaTest
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, userMapper);
    }


    @Test
    void create() {
    }

    @Test
    void getAll() {
        userService.getAll();
        verify(userMapper).toDTO(userRepository.findAll());
    }

    @Test
    void getAllByIds() {
    }

    @Test
    void getById() {
    }
}