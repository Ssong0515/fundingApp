package bitc.fullstack405.fun_spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Data
@EqualsAndHashCode //equals, hashCode 자동 생성
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId; // 회원 pk

    @Column(name = "user_pw", length = 45, nullable = false)
    private String userPw; // 비밀번호

    @Column(length = 30, nullable = false)
    private String name; // 이름

    @Column(length = 45, nullable = false, unique = true)
    private String email; // 이메일

    @Column(length = 300, nullable = false)
    private String address; // 주소

    // 양방향일 경우 @ToString.Exclude 양쪽 다 꼭 넣기
    // user 부분은 다 cascade = CascadeType.ALL 이거 넣기(회원 수정되면 다른 거도 수정되어야 하니까)
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @ToString.Exclude
//    private List<ProjectEntity> projectEntityList = new ArrayList<>();
}