package com.example.demo.controllers.repositori;

import com.example.demo.model.Gitar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface GitarRepo extends CrudRepository<Gitar, Long> {



    @Query(
            value = "SELECT * FROM gitar u WHERE u.price >= :minPrice and u.price <= :maxPrice ORDER BY u.price ASC",
            nativeQuery = true)
    List<Gitar> findByPriceUp(@Param("minPrice")Integer minPrice,
                              @Param("maxPrice")Integer maxPrice);


    @Query(
            value = "SELECT * FROM gitar u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.type IN :type ORDER BY u.price ASC",
            nativeQuery = true)
    List<Gitar> findByPriceAndTypeUp(@Param("minPrice")Integer minPrice,
                                     @Param("maxPrice")Integer maxPrice,
                                     @Param("type") Collection<String> type);


    @Query(
            value = "SELECT * FROM gitar u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.sensors IN :sensors ORDER BY u.price ASC",
            nativeQuery = true)
    List<Gitar> findByPriceAndSensorsUp(@Param("minPrice")Integer minPrice,
                                        @Param("maxPrice")Integer maxPrice,
                                        @Param("sensors") Collection<String> sensors);

    @Query(
            value = "SELECT * FROM gitar u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.sensors IN :sensors and u.type IN :type ORDER BY u.price ASC",
            nativeQuery = true)
    List<Gitar> findByPriceAndSensorsAndTypeUp(@Param("minPrice")Integer minPrice,
                                               @Param("maxPrice")Integer maxPrice,
                                               @Param("sensors") Collection<String> sensors,
                                               @Param("type") Collection<String> type);















    @Query(
            value = "SELECT * FROM gitar u WHERE u.price >= :minPrice and u.price <= :maxPrice ORDER BY u.price DESC",
            nativeQuery = true)
    List<Gitar> findByPriceDaun(@Param("minPrice")Integer minPrice,
                              @Param("maxPrice")Integer maxPrice);


    @Query(
            value = "SELECT * FROM gitar u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.type IN :type ORDER BY u.price DESC",
            nativeQuery = true)
    List<Gitar> findByPriceAndTypeDaun(@Param("minPrice")Integer minPrice,
                                     @Param("maxPrice")Integer maxPrice,
                                     @Param("type") Collection<String> type);


    @Query(
            value = "SELECT * FROM gitar u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.sensors IN :sensors ORDER BY u.price DESC",
            nativeQuery = true)
    List<Gitar> findByPriceAndSensorsDaun(@Param("minPrice")Integer minPrice,
                                        @Param("maxPrice")Integer maxPrice,
                                        @Param("sensors") Collection<String> sensors);

    @Query(
            value = "SELECT * FROM gitar u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.sensors IN :sensors and u.type IN :type ORDER BY u.price DESC",
            nativeQuery = true)
    List<Gitar> findByPriceAndSensorsAndTypeDaun(@Param("minPrice")Integer minPrice,
                                               @Param("maxPrice")Integer maxPrice,
                                               @Param("sensors") Collection<String> sensors,
                                               @Param("type") Collection<String> type);



    @Query(
            value = "SELECT * FROM gitar u WHERE u.id_product = :id",
            nativeQuery = true)
    List<Gitar> findByIdProduct(@Param("id")Integer id);



}
