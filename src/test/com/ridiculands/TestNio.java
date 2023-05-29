package com.ridiculands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Collectors;

public class TestNio {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/pywong/Documents/EPAM/rm1");
        for (Path entry : Files.walk(path).collect(Collectors.toList())) {
            BasicFileAttributes bfa = Files.readAttributes(entry, BasicFileAttributes.class);
            System.err.println(entry.getFileName().getFileName() + " " + bfa.creationTime() + " " + bfa.isDirectory() + " " + bfa.isRegularFile());
        }
    }
}
