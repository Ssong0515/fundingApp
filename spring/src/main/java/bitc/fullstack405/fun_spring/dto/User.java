package bitc.fullstack405.fun_spring.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 유저 fk 키

    @Column
    private String userId; // 아이디

    @Column
    private String userPw; // 비밀번호

    @Column
    private String userEmail; // 이메일

    @Column
    private String userName; // 이름

    @Column
    private String adress; // 주소

}
