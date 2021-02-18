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

    List<Umbrella> findByUmbrellaArea_Id(Long id);
    //update test
    @Transactional
    @Modifying
    @Query(value = "update umbrella set state=:date where id=:id",nativeQuery = true)
    Integer timetest(Long id,boolean date);

    @Query(value = "Select * from umbrella where state=:state order by date", nativeQuery = true)
    List<Umbrella> findByStateAndOrderByDate(boolean state);
    @Transactional
    @Modifying
    @Query(value = "update umbrella set state=:state where id=:id",nativeQuery = true)
    int order(Long id,boolean state);
}