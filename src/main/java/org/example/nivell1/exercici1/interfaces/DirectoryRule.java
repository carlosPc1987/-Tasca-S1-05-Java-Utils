package org.example.nivell1.exercici1.interfaces;



import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;

import java.io.File;


public interface DirectoryRule {
    void validate(File directory) throws InvalidDirectoryException;
}

