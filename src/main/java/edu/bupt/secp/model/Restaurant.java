package edu.bupt.secp.model;

import javax.persistence.*;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String name;

    private String password;

    @Column(length = 11)
    private String phone;

    private Integer accout;

    private String image_addr;

    public String getImage_addr() {
        return image_addr;
    }

    public void setImage_addr(String image_addr) {
        this.image_addr = image_addr;
    }


    public Integer getAccout(){
        return accout;
    }

    public void setAccout(Integer accout){
        this.accout = accout;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }
}
