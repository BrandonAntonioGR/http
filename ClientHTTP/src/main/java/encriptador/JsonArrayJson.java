/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encriptador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonArrayJson {
    // Crear un objeto JSON con un array que contiene otro objeto JSON
    public static String jsonArrayJson(){
        // Crear un objeto JSON con la estructura modificada
        //POST Lead - New record
        // Crear el objeto ObjectMapper de Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        // Crear un objeto JSON principal
        ObjectNode objetoPrincipal = objectMapper.createObjectNode();
        // Agregar propiedades al objeto principal
        objetoPrincipal.put("campaign_id",1801612);
        // Crear un arreglo dentro del objeto principal
        ArrayNode arreglo = objetoPrincipal.putArray("Leads");
        // Crear un objeto JSON dentro del arreglo
        ObjectNode objetoEnArreglo = objectMapper.createObjectNode();
        objetoEnArreglo.put("NUMBER", "3000000001");
        objetoEnArreglo.put("DPD", "-5");
        objetoEnArreglo.put("TIPO_ASIGNACION", "OLD");
        objetoEnArreglo.put("ADEUDO", "1000");
        objetoEnArreglo.put("TEL", "9999999999");
        objetoEnArreglo.put("CLIENT_FULL_NAME", "MANUEL PRUEBA");
        objetoEnArreglo.put("ALGORITMO", "Q");
        // Agregar el objeto al arreglo
        arreglo.add(objetoEnArreglo);
        // Convertir el objeto principal a formato JSON
        String jsonString = objetoPrincipal.toString();
        // Imprimir el JSON resultante
        return jsonString;
    }
}
