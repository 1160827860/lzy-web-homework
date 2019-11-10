package com.darksouls.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class task {

    private String order_title;
    @JsonFormat(pattern = "yyyy-MM-DD")
    private java.sql.Date order_release_time;
    @JsonFormat(pattern = "yyyy-MM-DD")
    private java.sql.Date order_delivery_time;
    private String order_language;
    private String order_type;
    private Integer order_price;
    private String order_status;
    private String order_introduce;
    private MultipartFile doc;
    private MultipartFile attachment;
    private String order_doc;
    private String order_attachment;
    public MultipartFile getDoc() {
        return doc;
    }

    public void setDoc(MultipartFile doc) {
        this.doc = doc;
    }

    public MultipartFile getAttachment() {
        return attachment;
    }

    public void setAttachment(MultipartFile attachment) {
        this.attachment = attachment;
    }

    private String order_note;
    private int order_flag;

    public void setOrder_release_time(java.sql.Date order_release_time) {
        this.order_release_time = order_release_time;
    }

    public void setOrder_delivery_time(java.sql.Date order_delivery_time) {
        this.order_delivery_time = order_delivery_time;
    }
    public String getOrder_title() {
        return order_title;
    }

    public void setOrder_title(String order_title) {
        this.order_title = order_title;
    }

    public Date getOrder_release_time() {
        return order_release_time;
    }



    public Date getOrder_delivery_time() {
        return order_delivery_time;
    }


    public String getOrder_language() {
        return order_language;
    }

    public void setOrder_language(String order_language) {
        this.order_language = order_language;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public Integer getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Integer order_price) {
        this.order_price = order_price;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOrder_doc() {
        return order_doc;
    }

    public void setOrder_doc(String order_doc) {
        this.order_doc = order_doc;
    }

    public String getOrder_attachment() {
        return order_attachment;
    }

    public void setOrder_attachment(String order_attachment) {
        this.order_attachment = order_attachment;
    }

    public String getOrder_introduce() {
        return order_introduce;
    }

    public void setOrder_introduce(String order_introduce) {
        this.order_introduce = order_introduce;
    }

    public String getOrder_note() {
        return order_note;
    }

    public void setOrder_note(String order_note) {
        this.order_note = order_note;
    }

    public int getOrder_flag() {
        return order_flag;
    }

    public void setOrder_flag(int order_flag) {
        this.order_flag = order_flag;
    }

    public boolean isDocEmpty(){
        if(!doc.equals(null)){
            return false;
        }
        return true;
    }
    public boolean isPathEmpty(){
        if(!attachment.equals(null)){
            return false;
        }
        return true;
    }
}
