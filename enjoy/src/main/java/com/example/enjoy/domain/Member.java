package com.example.enjoy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class Member extends BaseEntity {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    private UUID uuid;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String principal;

    @Column
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Builder
    public Member(String email, String name, String password,
                  String principal, SocialType socialType) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.principal = principal;
        this.socialType = socialType;
    }
}
