package it.epicode.U5W2D2practice.exception;

public class BlogPostNotFoundException extends Exception {
    public BlogPostNotFoundException(String message) {
        super(message);
    }
}
