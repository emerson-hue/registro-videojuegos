import java.util.Scanner;

record Videojuego(String titulo, String plataforma, double precio) {}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Videojuego[] catalogo = new Videojuego[50];
        int contador = 0;
        int opcion = 0;

        System.out.println("=== Sistema de Registro de Videojuegos ===");

        do {
            System.out.println("\n1. Registrar nuevo videojuego");
            System.out.println("2. Mostrar videojuegos registrados");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    if (contador < catalogo.length) {
                        System.out.print("Título (ej. Minecraft, Call of Duty): ");
                        String titulo = scanner.nextLine();

                        System.out.print("Plataforma (ej. PC, PS5): ");
                        String plataforma = scanner.nextLine();

                        double precio = 0;
                        boolean precioValido = false;

                        while (!precioValido) {
                            System.out.print("Precio ($): ");
                            try {
                                precio = Double.parseDouble(scanner.nextLine());
                                if (precio >= 0) {
                                    precioValido = true;
                                } else {
                                    System.out.println("Error: El precio no puede ser negativo.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Ingresa un monto numérico válido para el precio.");
                            }
                        }

                        catalogo[contador] = new Videojuego(titulo, plataforma, precio);
                        contador++;
                        System.out.println("¡Videojuego registrado con éxito!");
                    } else {
                        System.out.println("El catálogo de juegos está lleno.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Lista de Videojuegos ---");
                    if (contador == 0) {
                        System.out.println("No hay juegos registrados aún.");
                    } else {
                        for (int i = 0; i < contador; i++) {
                            System.out.println((i + 1) + ". " + catalogo[i].titulo() +
                                    " | Plataforma: " + catalogo[i].plataforma() +
                                    " | Precio: $" + catalogo[i].precio());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa... ¡Nos vemos, Emerson!");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo seleccionando 1, 2 o 3.");
            }
        } while (opcion != 3);

        scanner.close();
    }
}