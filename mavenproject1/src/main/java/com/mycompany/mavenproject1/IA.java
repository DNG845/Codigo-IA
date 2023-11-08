package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class IA {
    private final List<String> availableCards = new ArrayList<>();
    private List<String> aiHand = new ArrayList<>();  // Agrega una lista para mantener las cartas de la IA

      public IA() {
        availableCards.add("Carta1");
        availableCards.add("Carta2");
        availableCards.add("Carta3");
        availableCards.add("Carta4");
        availableCards.add("Carta5");
        availableCards.add("Carta6");
        availableCards.add("Carta7");
        availableCards.add("Carta8");
        availableCards.add("Carta9");
        availableCards.add("Carta10");
        availableCards.add("Carta11");
        availableCards.add("Carta12");
        availableCards.add("Carta13");
        availableCards.add("Carta14");
        availableCards.add("Carta15");
        availableCards.add("Carta16");
        availableCards.add("Carta17");
        availableCards.add("Carta18");
        availableCards.add("Carta19");
        availableCards.add("Carta20");
        availableCards.add("Carta21");
        availableCards.add("Carta22");
        availableCards.add("Carta23");
        availableCards.add("Carta24");
        availableCards.add("Carta25");
        availableCards.add("Carta26");
        availableCards.add("Carta27");
        availableCards.add("Carta28");
        availableCards.add("Carta29");
        availableCards.add("Carta30");
         // Inicializa la mano de la IA con 5 cartas al inicio
        aiHand.addAll(availableCards.subList(0, 5));
    }

    public List<String> crearMazoAleatorio(int cardsQuantity) {
        List<String> mazoIA = new ArrayList<>(availableCards);
        Collections.shuffle(mazoIA);
        return mazoIA.subList(0, cardsQuantity);
    }

    public String chooseRandomCard() {
        if (aiHand.isEmpty()) {
            System.out.println("La IA no puede jugar más cartas, todas se han utilizado.");
            return "No Carta";  // Devuelve un valor especial para indicar que no puede jugar más cartas
        }

        Random random = new Random();
        int randomIndex = random.nextInt(aiHand.size());
        return aiHand.remove(randomIndex);  // Elimina la carta de la mano de la IA y la devuelve
    }

    public String chooseCardToPlay() {
        return chooseRandomCard();
    }

    public static void main(String[] args) {
        IA game = new IA();
        String gameMode = "Inteligencia Artificial";

        if (gameMode.equals("Inteligencia Artificial")) {
            List<String> mazoIA = game.crearMazoAleatorio(5);
            System.out.println("Mazo de la Inteligencia Artificial: " + mazoIA);
        }
    }
}
  

