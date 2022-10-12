package uz.boom.chatserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import uz.boom.chatserver.domains.User;
import uz.boom.chatserver.dto.user.UserCreateDTO;
import uz.boom.chatserver.dto.user.UserDTO;
import uz.boom.chatserver.mappers.base.BaseMapper;

import java.util.List;

/**
 * @author - 'Zuhriddin Shamsiddionov' at 2:15 PM 10/9/22 on Sunday in October
 */
//@Component
@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface UserMapper extends BaseMapper {


    UserDTO toDTO(User entity);

    List<UserDTO> toDTO(List<User> entities);



    User fromCreateDTO(UserCreateDTO dto);
}
