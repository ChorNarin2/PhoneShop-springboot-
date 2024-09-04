package chornarin.com.kh.Phone_Shop.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import chornarin.com.kh.Phone_Shop.Dto.UserDto;
import chornarin.com.kh.Phone_Shop.models.User;

@Mapper
public interface UserMapper {

    UserMapper Instance = Mappers.getMapper(UserMapper.class);
    User toUser(UserDto userdDto);

}
