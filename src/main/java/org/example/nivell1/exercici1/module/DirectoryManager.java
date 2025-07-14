package org.example.nivell1.exercici1.module;

import org.example.nivell1.exercici1.exceptions.InvalidDirectoryException;
import org.example.nivell1.exercici1.interfaces.SortStrategy;

import java.io.File;
import java.util.Arrays;
import java.util.List;


    public class DirectoryManager {
        private final SortStrategy sorter;
        private final DirectoryValidator validator;

        public DirectoryManager(SortStrategy sorter) {
            this.sorter = sorter;
            this.validator = new DirectoryValidator(
                    List.of(new DirectoryExistsRule(), new IsDirectoryRule(), new IsNotEmptyRule())
            );
        }

        public void listSortedDirectory(String path) throws InvalidDirectoryException {
            validator.validate(path); //

            File directory = new File(path);
            List<String> files = Arrays.asList(directory.list());
            List<String> sortedFiles = sorter.sort(files);

            sortedFiles.forEach(System.out::println);
        }
    }

