package com.example.assintern;

public class Discussion {

    private String Name,Message,Pending,img;
    private int Photo;


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getPending() {
        return Pending;
    }

    public void setPending(String pending) {
        Pending = pending;
    }
}
