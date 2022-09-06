package com.example.demo.controllers.repositori;


import com.example.demo.model.Gitar;
import com.example.demo.model.StudioEquipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface StudioEquipmentRepo extends CrudRepository<StudioEquipment, Long> {



    @Query(
            value = "SELECT * FROM studio_equipment u WHERE u.price >= :minPrice and u.price <= :maxPrice ORDER BY u.price ASC",
            nativeQuery = true)
    List<StudioEquipment> findByPriceUp(@Param("minPrice")Integer minPrice,
                                   @Param("maxPrice")Integer maxPrice);


    @Query(
            value = "SELECT * FROM studio_equipment u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.out_line IN :type ORDER BY u.price ASC",
            nativeQuery = true)
    List<StudioEquipment> findByPriceAndTypeUp(@Param("minPrice")Integer minPrice,
                                          @Param("maxPrice")Integer maxPrice,
                                          @Param("type") Collection<String> type);


    @Query(
            value = "SELECT * FROM studio_equipment u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.in_line IN :model ORDER BY u.price ASC",
            nativeQuery = true)
    List<StudioEquipment> findByPriceAndSensorsUp(@Param("minPrice")Integer minPrice,
                                             @Param("maxPrice")Integer maxPrice,
                                             @Param("model") Collection<String> model);

    @Query(
            value = "SELECT * FROM studio_equipment u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.in_line IN :model and u.out_line IN :type ORDER BY u.price ASC",
            nativeQuery = true)
    List<StudioEquipment> findByPriceAndSensorsAndTypeUp(@Param("minPrice")Integer minPrice,
                                                    @Param("maxPrice")Integer maxPrice,
                                                    @Param("model") Collection<String> model,
                                                    @Param("type") Collection<String> type);















    @Query(
            value = "SELECT * FROM studio_equipment u WHERE u.price >= :minPrice and u.price <= :maxPrice ORDER BY u.price DESC",
            nativeQuery = true)
    List<StudioEquipment> findByPriceDaun(@Param("minPrice")Integer minPrice,
                                     @Param("maxPrice")Integer maxPrice);


    @Query(
            value = "SELECT * FROM studio_equipment u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.out_line IN :type ORDER BY u.price DESC",
            nativeQuery = true)
    List<StudioEquipment> findByPriceAndTypeDaun(@Param("minPrice")Integer minPrice,
                                            @Param("maxPrice")Integer maxPrice,
                                            @Param("type") Collection<String> type);


    @Query(
            value = "SELECT * FROM studio_equipment u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.in_line IN :model ORDER BY u.price DESC",
            nativeQuery = true)
    List<StudioEquipment> findByPriceAndSensorsDaun(@Param("minPrice")Integer minPrice,
                                               @Param("maxPrice")Integer maxPrice,
                                               @Param("model") Collection<String> model);

    @Query(
            value = "SELECT * FROM studio_equipment u WHERE u.price >= :minPrice and u.price <= :maxPrice and u.in_line IN :model and u.out_line IN :type ORDER BY u.price DESC",
            nativeQuery = true)
    List<StudioEquipment> findByPriceAndSensorsAndTypeDaun(@Param("minPrice")Integer minPrice,
                                                      @Param("maxPrice")Integer maxPrice,
                                                      @Param("model") Collection<String> model,
                                                      @Param("type") Collection<String> type);

    @Query(
            value = "SELECT * FROM studio_equipment u WHERE u.id_product = :id",
            nativeQuery = true)
    List<StudioEquipment> findByIdProduct(@Param("id")Integer id);


}
