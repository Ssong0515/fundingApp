package bitc.fullstack405.fun_spring.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int projectId; // 프로젝트 pk

    @Column(name = "goal_amount", nullable = false)
    private int goalAmount; // 목표 금액

    @Column(name = "current_amount", nullable = false)
    @ColumnDefault("0") // 기본값 0 설정, 엔티티를 save할 때 null 값은 배제하고 insert 쿼리를 날리도록 함
    private int currentAmount;  // 현재금액

    @Column(length = 20, nullable = false)
    private String category; // 카테고리

    @Column(length = 50, nullable = false)
    private String title; // 제목

    @Column(length = 1000, nullable = false)
    private String contents; // 내용

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate; // 시작일

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate; // 종료일

    @Column(name = "per_price", nullable = false)
    private int perPrice; // 개당 금액

    // fk
//    @ManyToOne
//    @JoinColumn(name = "user_id") // 외래키 컬럼 이름
//    @ToString.Exclude
//    private UserEntity userEntity;
}