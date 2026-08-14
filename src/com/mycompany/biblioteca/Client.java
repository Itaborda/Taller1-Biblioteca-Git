package com.mycompany.biblioteca;

public class Client extends Person{
    private String mail;

    public Client(int id, String name, String phone, String mail) {
        super(id, name, phone);
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                ", phone='" + getPhone() + "'" +
                ", mail='" + mail + "'" +
                "}";
    }

}
