package bitc.fullstack405.fun_spring.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Long id; // 상품 fk 키

    @Column
    private int goalAmount; // 목표금액

    @Column
    private int currentAmount; // 현재금액

    @Column
    private String category; // 카테고리

    @Column
    private String title; // 제목

    @Column
    private String contents; // 내용

    @Column
    private LocalDateTime startDate; // 시작일

    @Column
    private String endDate; // 종료일

    @Column
    private int perPrice; // 개당 금액
}
