package main.java.assignments.concurrent_content_interaction_system.service;

import main.java.assignments.concurrent_content_interaction_system.model.Content;

import java.util.Objects;

public class InteractionService {

    public InteractionService() {
    }

    public void addView(Content content) {
        validate(content);
        content.view();
    }

    public void addLike(Content content) {
        validate(content);
        content.like();
    }

    public void removeLike(Content content) {
        validate(content);
        content.unLike();
    }

    public void addReaction(Content content) {
        validate(content);
        content.react();
    }

    public void removeReaction(Content content) {
        validate(content);
        content.removeReaction();
    }

    private void validate(Content content) {
        Objects.requireNonNull(content, "Content cannot be null");
    }
}
