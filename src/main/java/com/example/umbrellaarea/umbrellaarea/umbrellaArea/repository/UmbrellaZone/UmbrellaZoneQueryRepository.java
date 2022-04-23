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
;import static com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.QUmbrella.umbrella;
import static com.example.umbrellaarea.umbrellaarea.umbrellaArea.entity.QUmbrellaZone.umbrellaZone;

@Repository
@RequiredArgsConstructor
public class UmbrellaZoneQueryRepository {

    private final JPAQueryFactory queryFactory;


    public List<MapUmbrellaZoneDto> selectUmbrellaZone () {
        return queryFactory.select(
                new QMapUmbrellaZoneDto(umbrellaZone.name, umbrellaZone.nx,
                umbrellaZone.ny, umbrellaZone.adders, umbrella.count()))
                .from(umbrella)
                .join(umbrella.umbrellaZone, umbrellaZone)
                .groupBy(umbrellaZone.id)
                .fetch();
    }

}
