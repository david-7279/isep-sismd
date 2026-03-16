package main.java.assignments.concurrent_content_interaction_system.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Content {

    // Contadores thread-safe
    private final AtomicInteger views;
    private final AtomicInteger likes;
    private final AtomicInteger reactions;

    // Construtor inicializa contadores a zero
    public Content() {
        this.views = new AtomicInteger(0);
        this.likes = new AtomicInteger(0);
        this.reactions = new AtomicInteger(0);
    }

    // Incrementa visualizações
    public void view() {
        views.incrementAndGet();
    }

    // Incrementa likes
    public void like() {
        likes.incrementAndGet();
    }

    // Remove like sem permitir valores negativos (CAS loop)
    public void unLike() {

        while (true) {

            int current = likes.get();

            if (current == 0) {
                throw new IllegalArgumentException("Likes cannot be negative");
            }

            // tenta atualizar atomicamente
            if (likes.compareAndSet(current, current - 1)) {
                return;
            }
        }
    }

    // Incrementa reações
    public void react() {
        reactions.incrementAndGet();
    }

    // Remove reação
    public void removeReaction() {
        reactions.decrementAndGet();
    }

    // Getters (expor apenas valores)
    public int getViews() {
        return views.get();
    }

    public int getLikes() {
        return likes.get();
    }

    public int getReactions() {
        return reactions.get();
    }
}
