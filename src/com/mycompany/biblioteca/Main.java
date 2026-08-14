package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Loan> loans = new ArrayList<>();

    public static void main(String[] args) {
        createClient();

        System.out.println();

        listClients();

        findClient();

        updateClient();

        deleteClient();

        createBook();


        System.out.println();
        listBooks();

        System.out.println();
        findBook();

        System.out.println();
        updateBook();

        System.out.println();
        deleteBook();

        System.out.println();
        listLoans();

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

    public static void createBook() {
        System.out.println("=== CREAR LIBRO ===");

        System.out.print("Código: ");
        String code = sc.nextLine();

        System.out.print("Título: ");
        String title = sc.nextLine();

        System.out.print("Año de publicación: ");
        String publicationYear = sc.nextLine();

        System.out.print("Autor: ");
        String author = sc.nextLine();

        System.out.print("Disponible (si/no): ");
        boolean available = Boolean.parseBoolean(sc.nextLine());

        Book book = new Book(code, title, publicationYear, author, available);
        books.add(book);

        System.out.println("Libro creado correctamente.");
    }

    public static void listBooks() {
        System.out.println("=== LISTAR LIBROS ===");

        if (books.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void findBook() {
        System.out.println("=== BUSCAR LIBRO ===");

        System.out.print("Ingrese el código del libro: ");
        String code = sc.nextLine();

        for (Book book : books) {
            if (book.getCode().equalsIgnoreCase(code)) {
                System.out.println("Libro encontrado:");
                System.out.println(book);
                return;
            }
        }

        System.out.println("Libro no encontrado.");
    }

    public static void updateBook() {
        System.out.println("=== ACTUALIZAR LIBRO ===");

        System.out.print("Ingrese el código del libro a actualizar: ");
        String code = sc.nextLine();

        for (Book book : books) {
            if (book.getCode().equalsIgnoreCase(code)) {

                System.out.print("Nuevo título: ");
                book.setTitle(sc.nextLine());

                System.out.print("Nuevo año de publicación: ");
                book.setPublicationYear(sc.nextLine());

                System.out.print("Nuevo autor: ");
                book.setAuthor(sc.nextLine());

                System.out.print("¿Está disponible? (si/no): ");
                book.setAvailable(sc.nextLine().equalsIgnoreCase("si"));

                System.out.println("Libro actualizado correctamente.");
                return;
            }
        }

        System.out.println("Libro no encontrado.");
    }

    public static void deleteBook() {
        System.out.println("=== ELIMINAR LIBRO ===");

        System.out.print("Ingrese el código del libro a eliminar: ");
        String code = sc.nextLine();

        for (Book book : books) {
            if (book.getCode().equalsIgnoreCase(code)) {
                books.remove(book);
                System.out.println("Libro eliminado correctamente.");
                return;
            }
        }

        System.out.println("Libro no encontrado.");
    }

    public static void createLoan() {
        System.out.println("=== REGISTRAR PRESTAMO ===");

        System.out.print("Id del préstamo: ");
        String idloan = sc.nextLine();

        System.out.print("Id del cliente: ");
        int clientId = Integer.parseInt(sc.nextLine());

        Client selectedClient = null;

        for (Client client : clients) {
            if (client.getId() == clientId) {
                selectedClient = client;
                break;
            }
        }

        if (selectedClient == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Código del libro: ");
        String bookCode = sc.nextLine();

        Book selectedBook = null;

        for (Book book : books) {
            if (book.getCode().equalsIgnoreCase(bookCode)) {
                selectedBook = book;
                break;
            }
        }

        if (selectedBook == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        if (!selectedBook.isAvailable()) {
            System.out.println("El libro no está disponible.");
            return;
        }

        LocalDate date = LocalDate.now();
        String state = "activo";

        Loan loan = new Loan(
                idloan,
                selectedClient,
                selectedBook,
                date,
                state
        );

        loans.add(loan);
        selectedBook.setAvailable(false);

        System.out.println("Prestamo registrado correctamente.");
    }

    public static void returnLoan() {
        System.out.println("=== DEVOLVER PRESTAMO ===");

        System.out.print("Id del préstamo: ");
        String idloan = sc.nextLine();

        for (Loan loan : loans) {

            if (loan.getIdloan().equalsIgnoreCase(idloan)) {

                if (!loan.getState().equalsIgnoreCase("activo")) {
                    System.out.println("El préstamo ya fue devuelto.");
                    return;
                }

                loan.setState("devuelto");
                loan.getBook().setAvailable(true);

                System.out.println("Préstamo devuelto correctamente.");
                return;
            }
        }

        System.out.println("Préstamo no encontrado.");
    }

    public static void listLoans() {
        System.out.println("=== LISTAR PRESTAMOS ===");

        if (loans.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }

        for (Loan loan : loans) {
            System.out.println("Id del préstamo: " + loan.getIdloan());
            System.out.println("Cliente: " + loan.getClient());
            System.out.println("Libro: " + loan.getBook());
            System.out.println("Fecha: " + loan.getDate());
            System.out.println("Estado: " + loan.getState());
            System.out.println("----------------------------");
        }
    }
}