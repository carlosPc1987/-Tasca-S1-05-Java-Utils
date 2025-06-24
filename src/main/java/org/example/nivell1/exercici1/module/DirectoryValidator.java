package org.example.nivell1.exercici1.module;



import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici1.interfaces.DirectoryRule;

import java.io.File;
import java.util.List;

public class DirectoryValidator {
    private final List<DirectoryRule> rules;

    public DirectoryValidator(List<DirectoryRule> rules) {
        this.rules = rules;
    }

    public void validate(String path) throws InvalidDirectoryException {
        File directory = new File(path);
        for (DirectoryRule rule : rules) {
            rule.validate(directory);
        }
    }
}