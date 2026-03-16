package main.java.assignments.concurrent_content_interaction_system;

import main.java.assignments.concurrent_content_interaction_system.model.Content;
import main.java.assignments.concurrent_content_interaction_system.service.InteractionService;
import main.java.assignments.concurrent_content_interaction_system.thread.UserInteraction;

public class Main {
    public static void main(String[] args) {

        // Conteúdo partilhado por todas as threads
        Content content = new Content();

        // Service responsável pelas interações
        InteractionService interactionService = new InteractionService();

        int numberOfUsers = 20;

        UserInteraction[] users = new UserInteraction[numberOfUsers];

        // Criar threads
        for (int i = 0; i < numberOfUsers; i++) {
            users[i] = new UserInteraction(content, interactionService);
            users[i].setName("User- " + (i + 1));
        }

        // Iniciar threads
        for (UserInteraction user : users) {
            user.start();
        }

        try {

            // deixar o sistema correr 10 segundos
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // parar threads
        for (UserInteraction user : users) {
            user.interrupt();
        }

        // esperar que terminem
        for (UserInteraction user : users) {
            try {
                user.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // métricas finais
        System.out.println("\n===== FINAL METRICS =====");
        System.out.println("Views: " + content.getViews());
        System.out.println("Likes: " + content.getLikes());
        System.out.println("Reactions: " + content.getReactions());
    }
}
