package com.example.umbrellaarea.umbrellaarea.umbrellaArea.repository.UmbrellaZone;

import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone.MapUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.dto.UmbrellaZone.QMapUmbrellaZoneDto;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.QUmbrella;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.QUmbrellaZone;
import com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.UmbrellaZone;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
;

@Repository
@RequiredArgsConstructor
public class UmbrellaZoneQueryRepository {

    private final JPAQueryFactory queryFactory;


    public List<MapUmbrellaZoneDto> selectUmbrellaZone () {
        QUmbrellaZone umbrellaZone = QUmbrellaZone.umbrellaZone;
        QUmbrella umbrella = QUmbrella.umbrella;
        return queryFactory.select(
                new QMapUmbrellaZoneDto(umbrellaZone.name, umbrellaZone.nx,
                umbrellaZone.ny, umbrellaZone.adders, umbrella.count()))
                .from(umbrellaZone)
                .join(umbrella.umbrellaZone, umbrellaZone)
                .groupBy(umbrellaZone.id)
                .fetch();
    }

    public List<UmbrellaZone> test () {
        QUmbrellaZone umbrellaZone = QUmbrellaZone.umbrellaZone;
        List<UmbrellaZone> fetch = queryFactory.selectFrom(umbrellaZone).fetch();
        return fetch;
    }

}
