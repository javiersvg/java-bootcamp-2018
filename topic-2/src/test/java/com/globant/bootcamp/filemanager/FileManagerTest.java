package com.globant.bootcamp.filemanager;

import java.util.Deque;

import org.junit.Test;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FileManagerTest {
    
    @Test
    public void shouldRetrunEmptyListWenRunTheFirstTime() {
        FileManager fileManager = new FileManager();
        assertThat(fileManager.getRecentOpenFiles(), empty());
    }
    
    @Test
    public void shouldAddOpenFileToList() {
        FileManager fileManager = new FileManager();
        fileManager.openFile("/myFile");
        Deque<String> recentOpenFiles = fileManager.getRecentOpenFiles();
        assertThat(recentOpenFiles.getFirst(), is("/myFile"));
    }
    
    @Test
    public void shouldBumpExistingFiletoTheTop() {
        FileManager fileManager = new FileManager();
        fileManager.openFile("/myFirstFile");
        fileManager.openFile("/mySecondFile");
        fileManager.openFile("/myFirstFile");
        Deque<String> recentOpenFiles = fileManager.getRecentOpenFiles();
        assertThat(recentOpenFiles.getFirst(), is("/myFirstFile"));
        assertThat(recentOpenFiles.size(), is(2));
    }
    
    @Test
    public void shouldOnlyAddUpTo13Elements() {
        FileManager fileManager = new FileManager();
        fileManager.openFile("/myFile1");
        fileManager.openFile("/myFile2");
        fileManager.openFile("/myFile3");
        fileManager.openFile("/myFile4");
        fileManager.openFile("/myFile5");
        fileManager.openFile("/myFile6");
        fileManager.openFile("/myFile7");
        fileManager.openFile("/myFile8");
        fileManager.openFile("/myFile9");
        fileManager.openFile("/myFile10");
        fileManager.openFile("/myFile11");
        fileManager.openFile("/myFile12");
        fileManager.openFile("/myFile13");
        fileManager.openFile("/myFile14");
        Deque<String> recentOpenFiles = fileManager.getRecentOpenFiles();
        assertThat(recentOpenFiles.getFirst(), is("/myFile14"));
        assertThat(recentOpenFiles.size(), is(13));
    }
}
