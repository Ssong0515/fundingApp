package bitc.fullstack405.fun_spring.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class FavoriteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    private int favoriteId; // pk

//    @ManyToOne
//    @JoinColumn(name = "user_id") // fk
//    private UserEntity userEntity;
//
//    // 외래키
//    @JoinColumn(name = "project_id") // fk
//    private ProjectEntity projectEntity;
}