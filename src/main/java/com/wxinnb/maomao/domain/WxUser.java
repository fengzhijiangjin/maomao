package com.wxinnb.maomao.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "tb_wxUser")
@Proxy(lazy = false)
public class WxUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String openId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "WxUser{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                '}';
    }
}
