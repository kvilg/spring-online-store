package com.example.demo.controllers.repositori;

import com.example.demo.model.Gitar;
import com.example.demo.model.Headphones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface HeadphonesRepo extends CrudRepository<Headphones,Long> {

    @Query(
            value = "SELECT * FROM headphones u WHERE u.price >= :minPrice and u.price <= :maxPrice ORDER BY u.price ASC",
            nativeQuery = true)
    List<Headphones> findByPriceUp(@Param("minPrice")Integer minPrice,
                              @Param("maxPrice")Integer maxPrice);


    @Query(
            value = "SELECT * FROM headphones u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.type IN :type ORDER BY u.price ASC",
            nativeQuery = true)
    List<Headphones> findByPriceAndTypeUp(@Param("minPrice")Integer minPrice,
                                     @Param("maxPrice")Integer maxPrice,
                                     @Param("type") Collection<String> type);


    @Query(
            value = "SELECT * FROM headphones u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.wire IN :wire ORDER BY u.price ASC",
            nativeQuery = true)
    List<Headphones> findByPriceAndSensorsUp(@Param("minPrice")Integer minPrice,
                                        @Param("maxPrice")Integer maxPrice,
                                        @Param("wire") Collection<String> wire);

    @Query(
            value = "SELECT * FROM headphones u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.wire IN :wire and u.type IN :type ORDER BY u.price ASC",
            nativeQuery = true)
    List<Headphones> findByPriceAndSensorsAndTypeUp(@Param("minPrice")Integer minPrice,
                                               @Param("maxPrice")Integer maxPrice,
                                               @Param("wire") Collection<String> wire,
                                               @Param("type") Collection<String> type);















    @Query(
            value = "SELECT * FROM headphones u WHERE u.price >= :minPrice and u.price <= :maxPrice ORDER BY u.price DESC",
            nativeQuery = true)
    List<Headphones> findByPriceDaun(@Param("minPrice")Integer minPrice,
                                @Param("maxPrice")Integer maxPrice);


    @Query(
            value = "SELECT * FROM headphones u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.type IN :type ORDER BY u.price DESC",
            nativeQuery = true)
    List<Headphones> findByPriceAndTypeDaun(@Param("minPrice")Integer minPrice,
                                       @Param("maxPrice")Integer maxPrice,
                                       @Param("type") Collection<String> type);


    @Query(
            value = "SELECT * FROM headphones u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.wire IN :wire ORDER BY u.price DESC",
            nativeQuery = true)
    List<Headphones> findByPriceAndSensorsDaun(@Param("minPrice")Integer minPrice,
                                          @Param("maxPrice")Integer maxPrice,
                                          @Param("wire") Collection<String> wire);

    @Query(
            value = "SELECT * FROM headphones u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.wire IN :wire and u.type IN :type ORDER BY u.price DESC",
            nativeQuery = true)
    List<Headphones> findByPriceAndSensorsAndTypeDaun(@Param("minPrice")Integer minPrice,
                                                 @Param("maxPrice")Integer maxPrice,
                                                 @Param("wire") Collection<String> wire,
                                                 @Param("type") Collection<String> type);



    @Query(
            value = "SELECT * FROM headphones u WHERE u.id_product = :id",
            nativeQuery = true)
    List<Headphones> findByIdProduct(@Param("id")Integer id);





}
