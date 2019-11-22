package com.wxinnb.maomao.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wxinnb.maomao.domain.support.BaseEntity;
import org.hibernate.annotations.Proxy;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_product")
@Proxy(lazy = false)
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId", nullable = false)
    private Integer productId;

    private String name;

    //最低价格
    private String minPrice;

    //原价
    private String originalPrice;

    private String pic;

    private int numberOrders;

    private int numberGoodReputation;

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getNumberOrders() {
        return numberOrders;
    }

    public void setNumberOrders(int numberOrders) {
        this.numberOrders = numberOrders;
    }

    public int getNumberGoodReputation() {
        return numberGoodReputation;
    }

    public void setNumberGoodReputation(int numberGoodReputation) {
        this.numberGoodReputation = numberGoodReputation;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

//    public List<InfoPics> getInfoPics() {
//        return infoPics;
//    }
//
//    public void setInfoPics(List<InfoPics> infoPics) {
//        this.infoPics = infoPics;
//    }


    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", minPrice='" + minPrice + '\'' +
                ", originalPrice='" + originalPrice + '\'' +
                ", pic='" + pic + '\'' +
                ", numberOrders=" + numberOrders +
                ", numberGoodReputation=" + numberGoodReputation +
                ", state=" + state +
                '}';
    }
}
