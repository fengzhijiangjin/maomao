package com.wxinnb.maomao.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;


@Entity
@Table(name = "t_details")
@Proxy(lazy = false)
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rollPicId", nullable = false)
    private Integer detailsId;

    private String pic;

    private Integer productId;

    public Integer getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(Integer detailsId) {
        this.detailsId = detailsId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Details{" +
                "detailsId='" + detailsId + '\'' +
                ", pic='" + pic + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}
