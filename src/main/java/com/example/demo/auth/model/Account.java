package com.example.demo.auth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * <pre>
 * Database에 저장된 데이터와 Mapping 되는 Object인 Account class 구현
 * </pre>
 *
 * @author HyunsuKim
 * @since 2023. 2. 8.
 * @version
 */
/*
 * NoArgsConstructor - 파라미터가 없는 기본 생성자를 생성
 * Entity - 해당 class를 특정 Table과 매핑하겠다는 의미
 * Table - 해당 Object와 매핑될 테이블 정보를 명시
 * Data - lombok을 활용하여 getter, setter 자동 생성
 */
@NoArgsConstructor
@Entity
@Data
@Table ( name = "account" )
public class Account
{
    // Id - 기본키(primary key)로 사용할 Value 값에 설정
    @Id
    private String userid;

    // Column - Object의 필드를 테이블의 컬럼과 매핑
    // nullable - null값 허용 여부를 정의
    @Column ( nullable = false )
    private String username;
    @Column ( nullable = false )
    private String password;
    @Column ( nullable = false )
    private String dept;
    @Column ( nullable = false )
    private Boolean isActive;

    // 실제 테이블의 컬럼에는 없으나 Object에서 별도로 필요한 값일 경우 명시
    @Transient
    private String confirmPassword;

    // @JoinColumn을 사용하여 특정 컬럼값과 일치하는 레코드만 join
    // Account <=> Role 테이블을 OneToMany 형태로 join. (사용자의 Role(권한) 정보를 join하여 가져옴)
    // fetch = FetchType.LAZY -> 지연 로딩
    // inverseJoinColumns -> FK가 여러개 있을 때 사용
    @OneToMany ( fetch = FetchType.LAZY )
    @JoinColumn ( name = "user_id", referencedColumnName = "roleid" )
    private Role roles;

}
