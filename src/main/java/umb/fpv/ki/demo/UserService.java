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

        userDto.setId(userEntity.getId());
        userDto.setMeno(userEntity.getMeno());
        userDto.setPriezvisko(userEntity.getPriezvisko());
        userDto.setKontakt(userEntity.getKontakt());
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
    public UserDto getUserId(Long userId){
        for (UserEntity u1 : userRepository.findAll()){
            if(u1.getId().equals(userId)){
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

        userEntity.setMeno(userDto.getMeno());
        userEntity.setPriezvisko(userDto.getPriezvisko());
        userEntity.setKontakt(userDto.getKontakt());

        this.userRepository.save(userEntity);
        return userEntity.getId();
    }

    //DELETE CUSTOMER
    @Transactional
    public void delete_User(Long userId){
        Optional<UserEntity> byId = userRepository.findById(userId);
        if(byId.isPresent()){
            userRepository.delete(byId.get());
        }
    }

    //UPDATE CUSTOMER
    @Transactional
    public void put_User(Long userId, UserDto userDto){
        Optional<UserEntity> byId = userRepository.findById(userId);
        if(byId.isPresent()){
            byId.get().setMeno(userDto.getMeno());
            byId.get().setPriezvisko(userDto.getPriezvisko());
            byId.get().setKontakt(userDto.getKontakt());
            byId.get().setId(userDto.getId());
        }
    }
}