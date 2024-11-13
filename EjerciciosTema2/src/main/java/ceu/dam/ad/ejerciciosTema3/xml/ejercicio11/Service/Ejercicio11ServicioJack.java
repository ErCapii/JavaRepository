package ceu.dam.ad.ejerciciosTema3.xml.ejercicio11.Service;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio11.Ejercicio11Service;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio11.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio11.modelo.Libros;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejercicio11ServicioJack implements Ejercicio11Service {
    @Override
    public void escribirJsonLibros(String pathFile, List<Libro> lista) throws XMLExportException {
        JsonMapper jsonMapper = new JsonMapper();
        File jsonFile = new File(pathFile);
        try {

            jsonMapper.writeValue(jsonFile, lista);

        } catch (Exception e) {
            throw new XMLExportException("Error al escribir el fichero json", e);
        }
    }

    @Override
    public List<Libro> leerJsonLibros(String pathFile) throws XMLExportException {
        File jsonFile = new File(pathFile);
        JsonMapper jsonMapper = new JsonMapper();
        try {
            Libro[] libros = jsonMapper.readValue(jsonFile, Libro[].class);
            return Arrays.asList(libros);
        } catch (Exception e) {
            throw new XMLExportException("Error al leer el fichero json", e);
        }
    }

    @Override
    public void escribirYamlLibros(String pathFile, List<Libro> lista) throws XMLExportException {
        File yamlFile = new File(pathFile);
        YAMLMapper yamlMapper = new YAMLMapper();
        try {
            yamlMapper.writeValue(yamlFile, lista);
        } catch (Exception e) {
            throw new XMLExportException("Error al escribir el fichero yaml", e);
        }
    }

    @Override
    public List<Libro> leerYamlLibros(String pathFile) throws XMLExportException {
        File yamlFile = new File(pathFile);
        YAMLMapper yamlMapper = new YAMLMapper();
        try {
            Libro[] libros = yamlMapper.readValue(yamlFile, Libro[].class);
            return Arrays.asList(libros);
        } catch (Exception e) {
            throw new XMLExportException("Error al leer el fichero yaml", e);
        }
    }
}
