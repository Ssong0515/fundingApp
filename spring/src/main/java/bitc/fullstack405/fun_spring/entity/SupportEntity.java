package bitc.fullstack405.fun_spring.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class SupportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "support_id")
    private int supportId; // pk

    @Column(nullable = false)
    private int amount; // 후원 금액

//    @ManyToOne
//    @JoinColumn(name = "user_id") // fk
//    private UserEntity userEntity;

    // 외래키
//    @JoinColumn(name = "project_id") // fk
//    private ProjectEntity projectEntity;
}