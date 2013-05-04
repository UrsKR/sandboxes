package com.github.signed.sandboxes.maven.surefire;

import com.github.signed.sandboxes.maven.BuildArtifact;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ArtifactToPropertiesWriter {
    private final File outputFile;

    public ArtifactToPropertiesWriter(File outputFile) {
        this.outputFile = outputFile;
    }

    public void write(Iterable<BuildArtifact> artifacts) {
        try {
            Properties properties = readProperties();
            populateProperties(artifacts, properties);
            writeProperties(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Properties readProperties() throws IOException {
        Properties properties = new Properties();
        if (outputFile().isFile()) {
            populateFromFile(properties);
        }
        return properties;
    }

    private Properties populateFromFile(Properties properties) throws IOException {
        FileReader reader = null;

        try {
            reader = new FileReader(outputFile());
            properties.load(reader);
        } finally {
            if (null != reader) {
                reader.close();
            }
        }
        return properties;
    }

    private void populateProperties(Iterable<BuildArtifact> artifacts, Properties properties) {
        for (BuildArtifact artifact : artifacts) {
            String key = "maven.artifact" + (null == artifact.classifier() ? "" : "." + artifact.classifier());
            properties.put(key, artifact.location().getAbsolutePath());
        }
    }

    private void writeProperties(Properties properties) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(outputFile());
            properties.store(writer, "Create by the artifact-validation-maven-plugin");
        } finally {
            if (null != writer) {
                writer.close();
            }
        }
    }

    private File outputFile() {
        return outputFile;
    }
}
