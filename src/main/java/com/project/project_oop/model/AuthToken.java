package com.project.project_oop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "token",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "token")
        },
        indexes = {
                @Index(name = "token_index", columnList = "token")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthToken extends BaseModel{

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @Column(name = "token")
        private String token;

        @Column(name = "revoked")
        private Long revoked;

        @Column(name = "expired")
        private Long expired;

}
