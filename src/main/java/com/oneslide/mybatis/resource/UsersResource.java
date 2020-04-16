package com.oneslide.mybatis.resource;

import com.oneslide.mybatis.mapper.AddressMapper;
import com.oneslide.mybatis.model.Users;
import com.oneslide.mybatis.mapper.UsersMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    private UsersMapper usersMapper;
    private AddressMapper addressMapper;
    public UsersResource(UsersMapper usersMapper, AddressMapper mapper) {

        this.usersMapper = usersMapper;
        this.addressMapper=mapper;
    }


    @GetMapping("/find")
    public List<Users> getAll() {
        return usersMapper.findById();
    }
    @GetMapping("/updateName/{id}")
    public String updateUserName(@PathVariable String id,
                                 @RequestParam String newName){
        Users users=new Users();
        users.setId(Integer.parseInt(id));
        users.setName(newName);
        usersMapper.update(users);
        return "ok";
    }

    @GetMapping("/getAllNames")
    public List<Users> getAllNames(){
        return usersMapper.findAllNames();
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllUsers(){
        usersMapper.deleteAll();
    }



    // XML-based
    @GetMapping("/getUserById/{id}")
    public Users getUserById(@PathVariable int id){
        return usersMapper.findUsersByIdRMap(id);
    }

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody Users users){
        if (users.getId()==null){
            usersMapper.insertUserWithoutId(users);
            System.out.println("auto-generated primary key :" +users.getId());
        }else {
            usersMapper.insertUser(users);
        }
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody Users users){
        usersMapper.updateUser(users);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteUserById(@PathVariable int id){
        usersMapper.deleteUserById(id);
    }

    @GetMapping("/getAllUsers")
    public List<Users> getAllUser(){
        return usersMapper.getAllUsersRMap();
    }

    @GetMapping("/getCompositeUser/{id}")
    public Users getCompositeUsers(@PathVariable int id){
        return usersMapper.findUsersByIdRMap(id);
    }


}
