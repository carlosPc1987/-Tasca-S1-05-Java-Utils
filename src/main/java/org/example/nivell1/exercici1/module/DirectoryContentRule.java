package org.example.nivell1.exercici1.module;

import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici1.interfaces.DirectoryRule;

import java.io.File;

public class DirectoryContentRule implements DirectoryRule {
    @Override
    public void validate(File directory) throws InvalidDirectoryException {
        if (directory.list() == null) {
            throw new InvalidDirectoryException("The directory is empty or inaccessible.");
        }
    }
}

