package Pruebas.PruebasJackSon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.List;
@Data
@JacksonXmlRootElement(localName = "alumnos")
public class Alumnos {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("alumno")
    private List<Alumno> alumnos;

}
