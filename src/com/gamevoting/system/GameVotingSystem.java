// CODIGO CON ERRORES PARA LA ACTIVIDAD 1 GIT/GITHUB

package com.gamevoting.system;
import java.util.HashMap;
// ERROR 1: Falta importar java.util.Map y java.util.Scanner.
import java.util.Map;
import java.util.Scanner;

public class GameVotingSystem {
    private static Map<String, Integer> votes = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args) { // ERROR 2: El parametro deberia ser un array de String, no un String simple.
        initializeGames();

        boolean running = false; // ERROR 3: El 'false' provocaria que el bucle while no se ejecute nunca.
        while (running) {
            System.out.println("\nWelcome to the Game Voting System!");
            System.out.println("1. Vote for your favorite game");
            System.out.println("2. Show voting results");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = 0; //ERROR 4: Tipo de dato incorrecto. 
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); 
                continue;
            }

            switch (choice) {
                case 1:
                    voteForGame();
                    // ERROR 5: Falta algo en esta linea. 
                case 2:
                    showResults();
                    break;
                case 3:
                    running = false;
                    break;
                case 4: // ERROR 6: La opción 4 no se contempla en el menu, el mensaje que se muestra se corresponde con un default. 
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void initializeGames() {
        votes.put("F1 2010", 0); 
        votes.put("FIFA 21", 0);
        votes.put("NBA 2K23", 0); 
    }

    private static void voteForGame() { // ERROR 7: Deberia ser static. 
        System.out.println("Available games:");
        for (String game : votes.keySet()) {
            System.out.println(game); //ERROR 8: Aqui falta algo. 
        }
        System.out.print("Enter the name of the game you want to vote for: ");
        String game = scanner.nextLine().trim();
        if (votes.containsKey(game)) {
            votes.put(game, votes.get(game) - 1); // ERROR 9: Se esta decrementando el conteo de votos.
            System.out.println("Thank you for voting!");
        }  { //ERROR 10: Falta 'else'. 
            System.out.println("Game not found. Please try again.");
        }
    }

    private static void showResults() { //ERROR 11: Falta el tipo void. 
        if (votes.isEmpty())  {
            System.out.println("All games have received votes."); //ERROR 12: Mensaje incorrecto si no se han emitido votos.
            return; 
        }
        System.out.println("Current Voting Results:");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + 1); // ERROR 13: Si añado 1 al valor de votos, altero el resultado.
        }
   
    // ERROR 14: Aqui falta algo. 
    }
}
