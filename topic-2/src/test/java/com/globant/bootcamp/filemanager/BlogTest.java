package com.globant.bootcamp.filemanager;

import java.util.List;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

public class BlogTest {
    
    @Test
    public void shouldPostAnEntry() {
        Post post = mock(Post.class);
        Blog blog = new Blog();
        blog.post(post);
        List<Post> posts = blog.getPosts();
        assertThat(posts, contains(post));
    }
    
    @Test
    public void shouldDeleteExistingPost() {
        Post post = mock(Post.class);
        Blog blog = new Blog();
        blog.post(post);
        blog.remove(post);
        List<Post> posts = blog.getPosts();
        assertThat(posts, empty());
    }
    
    @Test
    public void shouldShowLast10Posts() {
        Blog blog = new Blog();
        blog.post(mock(Post.class));
        blog.post(mock(Post.class));
        blog.post(mock(Post.class));
        blog.post(mock(Post.class));
        blog.post(mock(Post.class));
        blog.post(mock(Post.class));
        blog.post(mock(Post.class));
        blog.post(mock(Post.class));
        blog.post(mock(Post.class));
        blog.post(mock(Post.class));
        List<Post> posts = blog.getPosts();
        assertThat(posts.size(), is(10));
    }
}
