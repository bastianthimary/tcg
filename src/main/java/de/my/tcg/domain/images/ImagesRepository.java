package de.my.tcg.domain.images;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesRepository extends JpaRepository<Images,Long>, JpaSpecificationExecutor<Images> {


    @Query("select i from Images i  where i.large_img is not null and i.id between ?1 and ?2")
    List<Images> getAllNotEmptyImages(Integer v1,Integer v2);


}
