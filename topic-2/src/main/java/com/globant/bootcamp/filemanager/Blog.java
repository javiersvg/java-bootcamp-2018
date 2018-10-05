package com.globant.bootcamp.filemanager;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    private List<Post> posts = new ArrayList<>();
    
    void post(Post post) {
        this.posts.add(post);
    }
    
    List<Post> getPosts() {
        return this.posts;
    }
    
    void remove(Post post) {
        this.posts.remove(post);
    }
}
