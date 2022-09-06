package com.example.demo.controllers.repositori;

import com.example.demo.model.Gitar;
import com.example.demo.model.Percussion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface PercussionRepo extends CrudRepository<Percussion, Long> {


    @Query(
            value = "SELECT * FROM percussion u WHERE u.price >= :minPrice and u.price <= :maxPrice ORDER BY u.price ASC",
            nativeQuery = true)
    List<Percussion> findByPriceUp(@Param("minPrice")Integer minPrice,
                              @Param("maxPrice")Integer maxPrice);


    @Query(
            value = "SELECT * FROM percussion u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.type IN :type ORDER BY u.price ASC",
            nativeQuery = true)
    List<Percussion> findByPriceAndTypeUp(@Param("minPrice")Integer minPrice,
                                     @Param("maxPrice")Integer maxPrice,
                                     @Param("type") Collection<String> type);


    @Query(
            value = "SELECT * FROM percussion u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.model IN :model ORDER BY u.price ASC",
            nativeQuery = true)
    List<Percussion> findByPriceAndSensorsUp(@Param("minPrice")Integer minPrice,
                                        @Param("maxPrice")Integer maxPrice,
                                        @Param("model") Collection<String> model);

    @Query(
            value = "SELECT * FROM percussion u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.model IN :model and u.type IN :type ORDER BY u.price ASC",
            nativeQuery = true)
    List<Percussion> findByPriceAndSensorsAndTypeUp(@Param("minPrice")Integer minPrice,
                                               @Param("maxPrice")Integer maxPrice,
                                               @Param("model") Collection<String> model,
                                               @Param("type") Collection<String> type);















    @Query(
            value = "SELECT * FROM percussion u WHERE u.price >= :minPrice and u.price <= :maxPrice ORDER BY u.price DESC",
            nativeQuery = true)
    List<Percussion> findByPriceDaun(@Param("minPrice")Integer minPrice,
                                @Param("maxPrice")Integer maxPrice);


    @Query(
            value = "SELECT * FROM percussion u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.type IN :type ORDER BY u.price DESC",
            nativeQuery = true)
    List<Percussion> findByPriceAndTypeDaun(@Param("minPrice")Integer minPrice,
                                       @Param("maxPrice")Integer maxPrice,
                                       @Param("type") Collection<String> type);


    @Query(
            value = "SELECT * FROM percussion u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.model IN :model ORDER BY u.price DESC",
            nativeQuery = true)
    List<Percussion> findByPriceAndSensorsDaun(@Param("minPrice")Integer minPrice,
                                          @Param("maxPrice")Integer maxPrice,
                                          @Param("model") Collection<String> model);

    @Query(
            value = "SELECT * FROM percussion u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.model IN :model and u.type IN :type ORDER BY u.price DESC",
            nativeQuery = true)
    List<Percussion> findByPriceAndSensorsAndTypeDaun(@Param("minPrice")Integer minPrice,
                                                 @Param("maxPrice")Integer maxPrice,
                                                 @Param("model") Collection<String> model,
                                                 @Param("type") Collection<String> type);

    @Query(
            value = "SELECT * FROM percussion u WHERE u.id_product = :id",
            nativeQuery = true)
    List<Percussion> findByIdProduct(@Param("id")Integer id);


}
