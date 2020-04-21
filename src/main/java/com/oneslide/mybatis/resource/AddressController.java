package com.oneslide.mybatis.resource;

import com.oneslide.mybatis.mapper.AddressMapper;
import com.oneslide.mybatis.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressMapper mapper;

    @Autowired
    @Qualifier("mybatis-auto-addr")
    com.oneslide.mybatis.mybatis.mapper.AddressMapper autoMapper;
    @GetMapping("/basicSearch")
    public List<Address> searchAddress(@RequestParam String street){
        Map<String,Object> map =new HashMap<>();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(3);
        map.put("idList",list);
        List<Address> lista =mapper.elasticSearchAddressForeach(map);
        return lista;
    }

    @PostMapping("/add")
    public String insertAddress(@RequestBody com.oneslide.mybatis.mybatis.model.Address address){
         int n=autoMapper.insert(address);
         return n==1?"ok":"failed";
    }
}
