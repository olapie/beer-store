package com.olapie.beerstore.infra.postgres.mapper;

import com.olapie.beerstore.domain.model.id.BeerId;
import org.apache.ibatis.annotations.*;
import com.olapie.beerstore.infra.postgres.entity.Beer;

/**
 * @author Eddú Meléndez
 */
@Mapper
public interface BeerMapper {

    @Select("SELECT id, name, price FROM beer WHERE id=#{id}")
    Beer getById(@Param("id") String id);

    @Insert("INSERT INTO beer(name, price) VALUES(#{name}, #{price})")
    Integer insert(Beer beer);

    @Update("UPDATE beer SET name=#{name}, price=#{price} WHERE id=#{id}")
    Integer update(Beer beer);
}