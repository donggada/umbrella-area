package com.example.umbrellaarea.umbrellaarea.Repository;

import com.example.umbrellaarea.umbrellaarea.Entity.Umbrella;
import com.example.umbrellaarea.umbrellaarea.Entity.UmbrellaArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

public interface UmbrellaRepository extends JpaRepository<Umbrella,Long> {

    Long countByUmbrellaArea(UmbrellaArea umbrellaArea);
    Long countByUmbrellaAreaAndState(UmbrellaArea umbrellaArea,Boolean state);
    List<Umbrella> findByUmbrellaArea_IdAndStateOrderByDate(Long id,Boolean state);


    @Transactional
    @Modifying
    @Query(value = "update umbrella set state=:state where id=:id",nativeQuery = true)
    int order(@Param("id") Long id,@Param("state") boolean state);

    List<Umbrella> findByUmbrellaArea_Id(Long id);
}