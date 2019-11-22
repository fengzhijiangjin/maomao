package com.wxinnb.maomao.domain;


import com.wxinnb.maomao.domain.support.BaseEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "t_rollPic")
@Proxy(lazy = false)
public class RollPic extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rollPicId", nullable = false)
    private Integer rollPicId;

    private String pic;

    private Integer productId;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getRollPicId() {
        return rollPicId;
    }

    public void setRollPicId(Integer rollPicId) {
        this.rollPicId = rollPicId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "RollPic{" +
                "rollPicId=" + rollPicId +
                ", pic='" + pic + '\'' +
                ", productId=" + productId +
                '}';
    }
}
