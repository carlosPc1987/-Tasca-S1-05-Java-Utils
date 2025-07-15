package org.example.nivell1.exercici5.module;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class DirectoryManager {

    private ConfigManager config;

    public DirectoryManager(String configFilePath) {
        this.config = new ConfigManager(configFilePath);
    }

    public void listTreeRecursively(File dir, int depth, Writer writer) throws IOException {
        if (dir == null || !dir.isDirectory()) throw new IllegalArgumentException("Directorio inválido: " + dir);

        String indent = "  ".repeat(depth);
        writer.write(indent + "[DIR] " + dir.getName() + "\n");

        File[] items = dir.listFiles();
        if (items == null || items.length == 0) {
            writer.write(indent + "  (empty)\n");
            return;
        }

        Arrays.stream(items).forEach(item -> {
            try {
                String nextIndent = "  ".repeat(depth + 1);
                if (item.isDirectory()) {
                    listTreeRecursively(item, depth + 1, writer);
                } else {
                    writer.write(nextIndent + "[FILE] " + item.getName() + "\n");
                }
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });
    }

    public void serializeDirectory(DirectoryInfo info, String filePath) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(info);
        }
    }

    public DirectoryInfo deserializeDirectory(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (DirectoryInfo) in.readObject();
        }
    }
    public DirectoryInfo getDirectoryInfo(String path) {
        File dir = new File(path);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new IllegalArgumentException("Ruta inválida: " + path);
        }

        File[] files = dir.listFiles();
        List<String> fileNames = files == null ? List.of() :
                Arrays.stream(files)
                        .filter(File::isFile)
                        .map(File::getName)
                        .toList();

        return new DirectoryInfo(dir.getAbsolutePath(), fileNames);
    }
}