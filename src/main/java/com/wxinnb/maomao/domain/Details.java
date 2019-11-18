package com.wxinnb.maomao.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;


@Entity
@Table(name = "t_details")
@Proxy(lazy = false)
public class Details {

    @Id
    private String detailsId;

    private String pic;

    private String productId;

    public String getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(String detailsId) {
        this.detailsId = detailsId;
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
        return "Details{" +
                "detailsId='" + detailsId + '\'' +
                ", pic='" + pic + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}
