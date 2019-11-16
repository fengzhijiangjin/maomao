package com.wxinnb.maomao.domain;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;


@Entity
@Table(name = "t_productListPics")
@Proxy(lazy = false)
public class ProductListPics {

    @Id
    private String id;

    private String pic;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="name")
    private ProductList productList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public ProductList getProductList() {
        return productList;
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "ProductListPics{" +
                "id='" + id + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
