package org.example.nivell1.exercici5.module;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private Properties properties;

    public ConfigManager(String configFilePath) {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(configFilePath)) {
            properties.load(input);
            System.out.println(" Configuración cargada correctamente");
        } catch (IOException e) {
            System.out.println(" Error cargando configuración: " + e.getMessage());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
