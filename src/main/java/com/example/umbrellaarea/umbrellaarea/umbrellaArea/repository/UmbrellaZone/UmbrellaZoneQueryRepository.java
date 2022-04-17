package com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone.MapUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone.QMapUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.QUmbrellaZone;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UmbrellaZoneQueryRepository {

    private final JPAQueryFactory queryFactory;


    public List<MapUmbrellaZoneDto> selectUmbrellaZone () {
        QUmbrellaZone umbrellaZone = QUmbrellaZone.umbrellaZone;
        queryFactory.select(new QMapUmbrellaZoneDto(umbrellaZone.name,
                umbrellaZone.nx, umbrellaZone.ny, umbrellaZone.adders, null)).fetchOne();
    return null;
    }


}
