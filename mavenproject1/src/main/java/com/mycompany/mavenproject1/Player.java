package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private final List<String> deck;
    private final List<String> playerHand;
    private final List<String> aiHand;
    private final IA aiPlayer;

    public Player() {
        deck = buildDeck();
        playerHand = new ArrayList<>();
        aiHand = new ArrayList<>();
        aiPlayer = new IA();

        inicializarManos();
    }

    private List<String> buildDeck() {
        List<String> deck = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            deck.add("Carta" + i);
        }
        return deck;
    }

    // Método para inicializar las manos del jugador y la IA
    private void inicializarManos() {
        List<String> mazoJugador = new ArrayList<>(deck.subList(0, 5));
        List<String> mazoIA = new ArrayList<>(deck.subList(5, 10));

        playerHand.addAll(mazoJugador);
        aiHand.addAll(mazoIA);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Tu turno");
            System.out.println("Mano del jugador: " + playerHand);

            System.out.print("Jugar una carta (escribe el nombre de la carta): ");
            String playerChoice = scanner.nextLine();
            playCard(playerChoice, playerHand);

            if (getHand(playerHand).isEmpty()) {
                System.out.println("Has perdido!");
                break;  // Terminar el juego si el jugador se queda sin cartas
            }

            System.out.println("Turno de la IA");
            String aiChoice = aiPlayer.chooseCardToPlay();
            playCard(aiChoice, aiHand);

            if (getHand(aiHand).isEmpty()) {
                System.out.println("Has ganado");
                break;  // Terminar el juego si la IA se queda sin cartas
            }

            // Mostrar manos después de cada turno
            System.out.println("Mano del jugador: " + getHand(playerHand));
            System.out.println("Mano de la IA: " + getHand(aiHand));
        }
    }

    private String getHand(List<String> hand) {
        return hand.toString();
    }

    private void playCard(String card, List<String> hand) {
        if (hand.contains(card)) {
            System.out.println("Jugaste la carta: " + card);
            hand.remove(card);
        } else {
            System.out.println("No puedes jugar esa carta, no está en tu mano.");
        }
    }

    public static void main(String[] args) {
        Player game = new Player();
        game.startGame();
    }
}


