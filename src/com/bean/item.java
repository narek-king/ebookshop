package com.bean;

/**
 * Created by King on 12/4/2015.
 */
public class item {
    private int id;
    private int userID;
    private int bookID;
    private int qty;

    public item(int userID, int bookID, int qty) {
        this.userID = userID;
        this.bookID = bookID;
        this.qty = qty;
    }

    public item(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
