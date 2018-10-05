package com.globant.bootcamp.filemanager;

import java.util.Deque;
import java.util.LinkedList;

public class FileManager {
    
    private Deque<String> files = new LinkedList<>();
    
    Deque<String> getRecentOpenFiles() {
        return this.files;
    }
    
    void openFile(String fileName) {
        if(this.files.size() >= 13) {
            this.files.removeLast();
        }
        this.files.remove(fileName);
        this.files.addFirst(fileName);
    }
}
