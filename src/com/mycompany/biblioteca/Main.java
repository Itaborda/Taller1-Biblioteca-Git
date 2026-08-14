package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        createClient();

    }

    public static void createClient() {
        System.out.println("=== CREAR CLIENTE ===");

        System.out.print("Id: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Nombre: ");
        String name = sc.nextLine();

        System.out.print("Telefono: ");
        String phone = sc.nextLine();

        System.out.print("correo: ");
        String mail = sc.nextLine();

        Client client = new Client(id, name, phone, mail);
        clients.add(client);

        System.out.println("Cliente creado correctamente.");
    }
}