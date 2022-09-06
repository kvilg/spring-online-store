package com.example.demo.controllers.repositori;

import com.example.demo.model.Gitar;
import com.example.demo.model.Keyboards;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface KeyboardsRepo extends CrudRepository<Keyboards, Long> {


    @Query(
            value = "SELECT * FROM keyboards u WHERE u.price >= :minPrice and u.price <= :maxPrice ORDER BY u.price ASC",
            nativeQuery = true)
    List<Keyboards> findByPriceUp(@Param("minPrice")Integer minPrice,
                                   @Param("maxPrice")Integer maxPrice);


    @Query(
            value = "SELECT * FROM keyboards u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.type IN :type ORDER BY u.price ASC",
            nativeQuery = true)
    List<Keyboards> findByPriceAndTypeUp(@Param("minPrice")Integer minPrice,
                                          @Param("maxPrice")Integer maxPrice,
                                          @Param("type") Collection<String> type);


    @Query(
            value = "SELECT * FROM keyboards u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.octaves IN :octaves ORDER BY u.price ASC",
            nativeQuery = true)
    List<Keyboards> findByPriceAndSensorsUp(@Param("minPrice")Integer minPrice,
                                             @Param("maxPrice")Integer maxPrice,
                                             @Param("octaves") Collection<String> octaves);

    @Query(
            value = "SELECT * FROM keyboards u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.octaves IN :octaves and u.type IN :type ORDER BY u.price ASC",
            nativeQuery = true)
    List<Keyboards> findByPriceAndSensorsAndTypeUp(@Param("minPrice")Integer minPrice,
                                                    @Param("maxPrice")Integer maxPrice,
                                                    @Param("octaves") Collection<String> octaves,
                                                    @Param("type") Collection<String> type);















    @Query(
            value = "SELECT * FROM keyboards u WHERE u.price >= :minPrice and u.price <= :maxPrice ORDER BY u.price DESC",
            nativeQuery = true)
    List<Keyboards> findByPriceDaun(@Param("minPrice")Integer minPrice,
                                     @Param("maxPrice")Integer maxPrice);


    @Query(
            value = "SELECT * FROM keyboards u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.type IN :type ORDER BY u.price DESC",
            nativeQuery = true)
    List<Keyboards> findByPriceAndTypeDaun(@Param("minPrice")Integer minPrice,
                                            @Param("maxPrice")Integer maxPrice,
                                            @Param("type") Collection<String> type);


    @Query(
            value = "SELECT * FROM keyboards u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.octaves IN :octaves ORDER BY u.price DESC",
            nativeQuery = true)
    List<Keyboards> findByPriceAndSensorsDaun(@Param("minPrice")Integer minPrice,
                                               @Param("maxPrice")Integer maxPrice,
                                               @Param("octaves") Collection<String> wire);

    @Query(
            value = "SELECT * FROM keyboards u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.octaves IN :octaves and u.type IN :type ORDER BY u.price DESC",
            nativeQuery = true)
    List<Keyboards> findByPriceAndSensorsAndTypeDaun(@Param("minPrice")Integer minPrice,
                                                      @Param("maxPrice")Integer maxPrice,
                                                      @Param("octaves") Collection<String> wire,
                                                      @Param("type") Collection<String> type);

    @Query(
            value = "SELECT * FROM keyboards u WHERE u.id_product = :id",
            nativeQuery = true)
    List<Keyboards> findByIdProduct(@Param("id")Integer id);


}
