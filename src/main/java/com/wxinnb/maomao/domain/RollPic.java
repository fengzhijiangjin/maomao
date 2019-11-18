package com.wxinnb.maomao.domain;


import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_rollPic")
@Proxy(lazy = false)
public class RollPic {
    @Id
    private String rollPicId;

    private String pic;

    private String productId;

    public String getRollPicId() {
        return rollPicId;
    }

    public void setRollPicId(String rollPicId) {
        this.rollPicId = rollPicId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "RollPic{" +
                "rollPicId='" + rollPicId + '\'' +
                ", pic='" + pic + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}
