package umb.fpv.ki.demo;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    private static UserDto mapUserDto(UserEntity userEntity){
        UserDto userDto = new UserDto();

        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setEmail(userEntity.getEmail());
        return userDto;
    }

    //LIST OF CUSTOMERS
    @Transactional
    public List<UserDto> getUsers(String userLastName){
        List<UserDto> ret = new LinkedList<>();
        for (UserEntity u1 : userRepository.findAll()){
            UserDto u2 = mapUserDto(u1);
            ret.add(u2);
        }
        return ret;
    }

    //GET CUSTOMER BY ID
    @Transactional
    public UserDto getUserId(int userID){
        for (UserEntity u1 : userRepository.findAll()){
            if(u1.getId().equals(userID)){
                UserDto u2 = mapUserDto(u1);
                return u2;
            }
        }
        return null;
    }

    //CREATE CUSTOMER
    @Transactional
    public Long create_User(UserDto userDto){
        UserEntity userEntity = new UserEntity();

        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());

        this.userRepository.save(userEntity);
        return userEntity.getId();
    }

    //DELETE CUSTOMER
    @Transactional
    public void delete_User(int userId){
        Optional<UserEntity> byID = userRepository.findById(userId);
        if(byID.isPresent()){
            userRepository.delete(byID.get());
        }
    }

    //UPDATE CUSTOMER
    @Transactional
    public void put_User(int userId, UserDto userDto){
        Optional<UserEntity> byID = userRepository.findById(userId);
        if(byID.isPresent()){
            byID.get().setFirstName(userDto.getFirstName());
            byID.get().setLastName(userDto.getLastName());
            byID.get().setEmail(userDto.getEmail());
            byID.get().setId(userDto.getId());
        }
    }
}
