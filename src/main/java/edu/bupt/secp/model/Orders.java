package edu.bupt.secp.model;

import javax.persistence.*;

@Entity
public class Orders {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeaulist() {
        return meaulist;
    }

    public void setMeaulist(String meaulist) {
        this.meaulist = meaulist;
    }

    public Float getBill() {
        return bill;
    }

    public void setBill(Float bill) {
        this.bill = bill;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String meaulist;

    @Column(nullable = false)
    private Float bill;

    @Column(nullable = false)
    private boolean status;
}
