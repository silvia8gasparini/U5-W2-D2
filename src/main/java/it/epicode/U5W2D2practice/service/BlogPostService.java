package it.epicode.U5W2D2practice.service;

import it.epicode.U5W2D2practice.exception.BlogPostNotFoundException;
import it.epicode.U5W2D2practice.model.BlogPost;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlogPostService {

    private List<BlogPost> blogPosts = new ArrayList<>();
    private int nextId = 1;

    public BlogPost saveBlogPost(BlogPost blogPost) {
        blogPost.setId(nextId++);
        blogPost.setCover("https://picsum.photos/200/300");
        blogPost.setTempoDiLettura(calcolaTempoDiLettura(blogPost.getContenuto()));
        blogPosts.add(blogPost);
        return blogPost;
    }

    public BlogPost getBlogPost(int id) throws BlogPostNotFoundException {
        return blogPosts.stream().filter(post -> post.getId() == id).findFirst().orElseThrow(() -> new BlogPostNotFoundException("Post con id " + id + " non trovato"));
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPosts;
    }

    public BlogPost updateBlogPost(int id, BlogPost blogPost) throws BlogPostNotFoundException {
        BlogPost postToUpdate = getBlogPost(id);

        postToUpdate.setTitolo(blogPost.getTitolo());
        postToUpdate.setCategoria(blogPost.getCategoria());
        postToUpdate.setContenuto(blogPost.getContenuto());
        postToUpdate.setTempoDiLettura(calcolaTempoDiLettura(blogPost.getContenuto()));

        return postToUpdate;
    }

    public void deleteBlogPost(int id) throws BlogPostNotFoundException {
        BlogPost toRemove = getBlogPost(id);
        blogPosts.remove(toRemove);
    }

    private int calcolaTempoDiLettura(String contenuto) {
        if (contenuto == null || contenuto.isBlank()) {
            return 1;
        }

        int conteggioParole = 0;
        Scanner scanner = new Scanner(contenuto);

        while (scanner.hasNext()) {
            scanner.next();
            conteggioParole++;
        }
        scanner.close();
        return Math.max(1, conteggioParole / 200);
    }
}
