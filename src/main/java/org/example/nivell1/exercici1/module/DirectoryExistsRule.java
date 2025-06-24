package org.example.nivell1.exercici1.module;

import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici1.interfaces.DirectoryRule;

import java.io.File;

public class DirectoryExistsRule implements DirectoryRule {
    @Override
    public void validate(File directory) throws InvalidDirectoryException {
        if (!directory.exists()) {
            throw new InvalidDirectoryException("The provided path does not exist.");
        }
    }
}

