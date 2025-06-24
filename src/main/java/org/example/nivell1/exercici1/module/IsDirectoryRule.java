package org.example.nivell1.exercici1.module;

import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici1.interfaces.DirectoryRule;

import java.io.File;

public class IsDirectoryRule implements DirectoryRule {
    @Override
    public void validate(File directory) throws InvalidDirectoryException {
        if (!directory.isDirectory()) {
            throw new InvalidDirectoryException("The provided path is not a valid directory.");
        }
    }
}
