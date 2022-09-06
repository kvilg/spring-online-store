package com.example.demo.controllers.repositori;

import com.example.demo.model.Img;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ImgRepo extends CrudRepository<Img,Long> {

    @Query(
            value = "SELECT * FROM img u WHERE u.main_img = :main_img and u.id_product = :id_product",
            nativeQuery = true)
    List<Img> findAllByMain_imgAndId_product(@Param("main_img")Integer main_img,
                          @Param("id_product")Integer id_product);

}
