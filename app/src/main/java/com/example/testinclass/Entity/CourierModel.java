package com.example.testinclass.Entity;


import com.example.testinclass.Enums.CourierStatus;
import com.example.testinclass.Enums.PaymentStatus;

import java.util.Date;

public class CourierModel {

    private Integer id;

//    sender veriabel
    private String senderFulname;
    private String senderPhn;
    private String senderAddress;
    private String senderBranch;

//    resiver Address
    private String resiverFulname;
    private String resiverPhn;
    private String sresiverAddress;
    private String resiverBranch;


    //    shipment information
    private String contentType;
    private String contentName;



    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public CourierStatus getCourierStatus() {
        return courierStatus;
    }

    public void setCourierStatus(CourierStatus courierStatus) {
        this.courierStatus = courierStatus;
    }

    private String contentWeight;
    private String totalPrice;
//    payment Mehtod
    private String paymentMethos;

    private Date createDate;

    private Date availeAbleDate;



    private PaymentStatus paymentStatus;

    private CourierStatus courierStatus;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenderFulname() {
        return senderFulname;
    }

    public void setSenderFulname(String senderFulname) {
        this.senderFulname = senderFulname;
    }

    public String getSenderPhn() {
        return senderPhn;
    }

    public void setSenderPhn(String senderPhn) {
        this.senderPhn = senderPhn;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderBranch() {
        return senderBranch;
    }

    public void setSenderBranch(String senderBranch) {
        this.senderBranch = senderBranch;
    }

    public String getResiverFulname() {
        return resiverFulname;
    }

    public void setResiverFulname(String resiverFulname) {
        this.resiverFulname = resiverFulname;
    }

    public String getResiverPhn() {
        return resiverPhn;
    }

    public void setResiverPhn(String resiverPhn) {
        this.resiverPhn = resiverPhn;
    }

    public String getSresiverAddress() {
        return sresiverAddress;
    }

    public void setSresiverAddress(String sresiverAddress) {
        this.sresiverAddress = sresiverAddress;
    }

    public String getResiverBranch() {
        return resiverBranch;
    }

    public void setResiverBranch(String resiverBranch) {
        this.resiverBranch = resiverBranch;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentWeight() {
        return contentWeight;
    }

    public void setContentWeight(String contentWeight) {
        this.contentWeight = contentWeight;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethos() {
        return paymentMethos;
    }

    public void setPaymentMethos(String paymentMethos) {
        this.paymentMethos = paymentMethos;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getAvaileAbleDate() {
        return availeAbleDate;
    }

    public void setAvaileAbleDate(Date availeAbleDate) {
        this.availeAbleDate = availeAbleDate;
    }

    @Override
    public String toString() {
        return "CourierModel{" +
                "id=" + id +
                ", senderFulname='" + senderFulname + '\'' +
                ", senderPhn='" + senderPhn + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", senderBranch='" + senderBranch + '\'' +
                ", resiverFulname='" + resiverFulname + '\'' +
                ", resiverPhn='" + resiverPhn + '\'' +
                ", sresiverAddress='" + sresiverAddress + '\'' +
                ", resiverBranch='" + resiverBranch + '\'' +
                ", contentType='" + contentType + '\'' +
                ", contentName='" + contentName + '\'' +
                ", contentWeight='" + contentWeight + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", paymentMethos='" + paymentMethos + '\'' +
                ", createDate=" + createDate +
                ", availeAbleDate=" + availeAbleDate +
                ", paymentStatus=" + paymentStatus +
                ", courierStatus=" + courierStatus +
                '}';
    }
}
