package bitc.fullstack405.fun_spring.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Support {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Long id; // 후원 fk 키

    @Column
    private int amount; // 후원 금액
}
