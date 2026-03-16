package main.java.assignments.concurrent_content_interaction_system.thread;

import main.java.assignments.concurrent_content_interaction_system.model.Content;
import main.java.assignments.concurrent_content_interaction_system.service.InteractionService;

import java.util.concurrent.ThreadLocalRandom;

public class UserInteraction extends Thread {

    private final Content content;
    private final InteractionService interactionService;

    public UserInteraction(Content content, InteractionService interactionService) {
        this.content = content;
        this.interactionService = interactionService;
    }

    private void chooseRandomInteraction() {

        int action = ThreadLocalRandom.current().nextInt(5);

        switch (action) {
            case 0:
                performView();
                break;
            case 1:
                performLike();
                break;
            case 2:
                performUnlike();
                break;
            case 3:
                performReaction();
                break;
            case 4:
                performRemoveReaction();
                break;
        }
    }

    private void performView() {
        interactionService.addView(content);

        // imprimir apenas ocasionalmente
        if (ThreadLocalRandom.current().nextInt(20) == 0) {
            System.out.println(getName() + " viewed content");
        }
    }

    private void performLike() {
        interactionService.addLike(content);
        System.out.println(getName() + " liked content");
    }

    private void performUnlike() {
        try {
            interactionService.removeLike(content);
            System.out.println(getName() + " removed like");
        } catch (Exception ignored) {
            // acontece quando likes = 0
        }
    }

    private void performReaction() {
        interactionService.addReaction(content);

        if (ThreadLocalRandom.current().nextInt(10) == 0) {
            System.out.println(getName() + " reacted to content");
        }
    }

    private void performRemoveReaction() {
        interactionService.removeReaction(content);
        System.out.println(getName() + " removed reaction");
    }

    @Override
    public void run() {

        while (!isInterrupted()) {
            try {

                chooseRandomInteraction();

                Thread.sleep(100);

            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted");
                break;
            }
        }
    }
}