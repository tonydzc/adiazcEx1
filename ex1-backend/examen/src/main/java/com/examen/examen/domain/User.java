package com.examen.examen.domain;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    private String nickname;
    private int status;

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
