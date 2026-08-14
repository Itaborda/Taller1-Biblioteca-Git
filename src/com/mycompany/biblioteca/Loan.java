package com.mycompany.biblioteca;

import java.time.LocalDate;

public class Loan {

    private String idloan;
    private Client client;
    private Book book;
    private LocalDate date;
    private String state;


    public Loan(String idloan, Client client, Book book, LocalDate date, String state) {
        this.idloan = idloan;
        this.client = client;
        this.book = book;
        this.date = date;
        this.state = state;
    }

    public String getIdloan() {
        return idloan;
    }

    public void setIdloan(String idloan) {
        this.idloan = idloan;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}


