package org.example.nivell1.exercici5.module;

import java.io.Serializable;
import java.util.List;

public class DirectoryInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String path;
    private List<String> files;

    public DirectoryInfo(String path, List<String> files) {
        this.path = path;
        this.files = files;
    }

    public String getPath() {
        return path;
    }

    public List<String> getFiles() {
        return files;
    }

    @Override
    public String toString() {
        return "Directori: " + path + "\nArxius:\n" + String.join("\n", files);
    }
}
