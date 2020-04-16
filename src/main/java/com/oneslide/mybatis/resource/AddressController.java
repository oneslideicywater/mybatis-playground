package com.oneslide.mybatis.resource;

import com.oneslide.mybatis.mapper.AddressMapper;
import com.oneslide.mybatis.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    AddressMapper mapper;

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
}
