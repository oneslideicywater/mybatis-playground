package com.oneslide.mybatis.mapper;

import com.oneslide.mybatis.model.Address;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface AddressMapper {

    @Insert("insert into address(street,details,userId) values(#{street},#{details},#{userId}) ")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(Address address);



    List<Address> elasticSearchAddress(Map<String,Object> map);
    List<Address> elasticSearchAddressChoose(Map<String,Object> map);
    List<Address> elasticSearchAddressWhere(Map<String,Object> map);
    List<Address> elasticSearchAddressForeach(Map<String,Object> map);
}
