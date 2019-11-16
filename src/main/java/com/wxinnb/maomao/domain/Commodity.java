package com.wxinnb.maomao.domain;


import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_commodity")
@Proxy(lazy = false)
public class Commodity {
    //商品编号
    @Id
    private String coNum;

    //名字
    private String coName;

    public String getCoName() {
        return coName;
    }

    public void setCoName(String coName) {
        this.coName = coName;
    }

    //商品价格
    private String price;
    //团购价格
    private String groupPrice;
    //简介
    private String intro;
    //功效
    private String effect;

    @Override
    public String toString() {
        return "Commodity{" +
                "coNum='" + coNum + '\'' +
                ", coName='" + coName + '\'' +
                ", price='" + price + '\'' +
                ", groupPrice='" + groupPrice + '\'' +
                ", intro='" + intro + '\'' +
                ", effect='" + effect + '\'' +
                '}';
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getCoNum() {
        return coNum;
    }

    public void setCoNum(String coNum) {
        this.coNum = coNum;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(String groupPrice) {
        this.groupPrice = groupPrice;
    }
}
