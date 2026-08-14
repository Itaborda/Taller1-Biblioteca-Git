package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        createClient();

        System.out.println();

        listClients();

        findClient();

        updateClient();

        deleteClient();

        System.out.println();
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

    public static void listClients() {
        System.out.println("=== LISTAR CLIENTES ===");

        if (clients.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Client client : clients) {
            System.out.println(client);
        }
    }

    public static void findClient() {
        System.out.println("=== BUSCAR CLIENTE ===");

        System.out.print("Ingrese el id del cliente: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Client client : clients) {
            if (client.getId() == id) {
                System.out.println("Cliente encontrado:");
                System.out.println(client);
                return;
            }
        }

        System.out.println("Cliente no encontrado.");
    }

    public static void updateClient() {
        System.out.println("=== ACTUALIZAR CLIENTE ===");

        System.out.print("Ingrese el id del cliente a actualizar: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Client client : clients) {
            if (client.getId() == id) {

                System.out.print("Nuevo nombre: ");
                client.setName(sc.nextLine());

                System.out.print("Nuevo telefono: ");
                client.setPhone(sc.nextLine());

                System.out.print("Nuevo correo: ");
                client.setMail(sc.nextLine());

                System.out.println("Cliente actualizado correctamente.");
                return;
            }
        }

        System.out.println("Cliente no encontrado.");
    }

    public static void deleteClient() {
        System.out.println("=== ELIMINAR CLIENTE ===");

        System.out.print("Ingrese el id del cliente a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Client client : clients) {
            if (client.getId() == id) {
                clients.remove(client);
                System.out.println("Cliente eliminado correctamente.");
                return;
            }
        }

        System.out.println("Cliente no encontrado.");
    }
}