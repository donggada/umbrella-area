package com.example.umbrellaarea.umbrellaarea.umbrellaArea.Entity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @CreatedBy
    @Column(updatable = false)
    private Long regId;

    @LastModifiedDate
    private LocalDateTime chgDate;

    @LastModifiedBy
    private Long chgId;
}
