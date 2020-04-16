package com.oneslide.mybatis.mapper;

import com.oneslide.mybatis.model.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UsersMapper {

//
//    @Select("select * from address where userid=#{userId}")
//    List<Address> getAddressById(Integer userId);


    @Select("select * from users")
    @Results(value = {
            @Result(property = "addresses", javaType = List.class,
                    column = "id", many = @Many(select = "com.techprimers.mybatis.springbootmybatis.mapper.AddressMapper.getAddressById"))
    }
    )
    List<Users> findById();

    @Select("select name from users")
    List<Users> findAllNames();

    @Insert("insert into users(name,salary) values(#{name},#{salary})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    int insert(Users users);

    @Update("update users set name=#{name} where id=#{id}")
    void update(Users user);

    @Delete("delete from users;")
    void deleteAll();

    //mapper based
    Users findUsersById(int id);
    Users findUsersByIdRMap(int id);

    /**insert user with id**/
    void insertUser(Users users);

    /**insert user with auto-generated id**/
    int insertUserWithoutId(Users users);

    /**update user**/
    void updateUser(Users users);

    /**delete user by id**/
    void deleteUserById(int id);

    /**get all users**/
    List<Users> getAllUsers();

    /**get all users**/
    List<Users> getAllUsersRMap();

    /**get composite view**/
    Users getCompositeView(int id);

    /**get user by id with association**/
    Users getUsersByIdAssociation(int id);
}
