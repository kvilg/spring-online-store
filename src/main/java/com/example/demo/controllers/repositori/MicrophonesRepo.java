package com.example.demo.controllers.repositori;

import com.example.demo.model.Gitar;
import com.example.demo.model.Microphones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface MicrophonesRepo extends CrudRepository<Microphones, Long> {




    @Query(
            value = "SELECT * FROM microphones u WHERE u.price >= :minPrice and u.price <= :maxPrice ORDER BY u.price ASC",
            nativeQuery = true)
    List<Microphones> findByPriceUp(@Param("minPrice")Integer minPrice,
                              @Param("maxPrice")Integer maxPrice);


    @Query(
            value = "SELECT * FROM microphones u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.type IN :type ORDER BY u.price ASC",
            nativeQuery = true)
    List<Microphones> findByPriceAndTypeUp(@Param("minPrice")Integer minPrice,
                                     @Param("maxPrice")Integer maxPrice,
                                     @Param("type") Collection<String> type);


    @Query(
            value = "SELECT * FROM microphones u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.orientation IN :orientation ORDER BY u.price ASC",
            nativeQuery = true)
    List<Microphones> findByPriceAndSensorsUp(@Param("minPrice")Integer minPrice,
                                        @Param("maxPrice")Integer maxPrice,
                                        @Param("orientation") Collection<String> orientation);

    @Query(
            value = "SELECT * FROM microphones u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.orientation IN :orientation and u.type IN :type ORDER BY u.price ASC",
            nativeQuery = true)
    List<Microphones> findByPriceAndSensorsAndTypeUp(@Param("minPrice")Integer minPrice,
                                               @Param("maxPrice")Integer maxPrice,
                                               @Param("orientation") Collection<String> orientation,
                                               @Param("type") Collection<String> type);















    @Query(
            value = "SELECT * FROM microphones u WHERE u.price >= :minPrice and u.price <= :maxPrice ORDER BY u.price DESC",
            nativeQuery = true)
    List<Microphones> findByPriceDaun(@Param("minPrice")Integer minPrice,
                                @Param("maxPrice")Integer maxPrice);


    @Query(
            value = "SELECT * FROM microphones u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.type IN :type ORDER BY u.price DESC",
            nativeQuery = true)
    List<Microphones> findByPriceAndTypeDaun(@Param("minPrice")Integer minPrice,
                                       @Param("maxPrice")Integer maxPrice,
                                       @Param("type") Collection<String> type);


    @Query(
            value = "SELECT * FROM microphones u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.orientation IN :orientation ORDER BY u.price DESC",
            nativeQuery = true)
    List<Microphones> findByPriceAndSensorsDaun(@Param("minPrice")Integer minPrice,
                                          @Param("maxPrice")Integer maxPrice,
                                          @Param("orientation") Collection<String> orientation);

    @Query(
            value = "SELECT * FROM microphones u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.orientation IN :orientation and u.type IN :type ORDER BY u.price DESC",
            nativeQuery = true)
    List<Microphones> findByPriceAndSensorsAndTypeDaun(@Param("minPrice")Integer minPrice,
                                                 @Param("maxPrice")Integer maxPrice,
                                                 @Param("orientation") Collection<String> orientation,
                                                 @Param("type") Collection<String> type);


    @Query(
            value = "SELECT * FROM microphones u WHERE u.id_product = :id",
            nativeQuery = true)
    List<Microphones> findByIdProduct(@Param("id")Integer id);


}
