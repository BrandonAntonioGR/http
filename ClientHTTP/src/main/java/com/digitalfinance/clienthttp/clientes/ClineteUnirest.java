/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digitalfinance.clienthttp.clientes;

import com.mashape.unirest.http.HttpResponse; 
import com.mashape.unirest.http.Unirest; 
import com.mashape.unirest.http.exceptions.UnirestException; 
import encriptador.encriptadorSha256;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import org.json.JSONObject;
// URL de la API a la que se hará la solicitud POST 
public class ClineteUnirest {
    public static void PostOkHttp() throws UnirestException{ 
        encriptadorSha256 Sha256=new encriptadorSha256(); 
        
        String AuthUsername = "CCCWebServicesTestMode";
        String userId="2077";
        String userSecret="API4finance#Ccc).23";
        String user="API-4FINANCE-2077";
        String Client_id="2077";
        String RequestDateTime = fechaActual();
        //encriptando 
        String datajson="{\"string\": \"Ping\"}";
        String SecretHash=Sha256.sha256(userSecret); 
        String token1=datajson;
        String token2=Sha256.sha256(Client_id+":"+user+":"+SecretHash);
        String AuthToken=Sha256.sha256(token1+":"+token2+":"+RequestDateTime);
        String apiUrl = "https://api.ccc.uno/ws/Ping"; 
        //Unirest 
        try{ 
            // Se crea un String con los datos que deseas enviar en la 
            //solicitud POST 
            String requestBody = 
                    "AuthUsername = "+AuthUsername+"\r\n"
                    + "AuthToken = {{"+AuthToken+"}}\r\n"
                    + "RequestDateTime = {{"+RequestDateTime+"}}\r\n"
                    + "Data = "+datajson; 
            //Unirest.setTimeouts(10000, 10000); // 10 segundos para 
            //conexión y lectura respectivamente 
            Unirest.setTimeouts(0, 0);// (tiempo de espera para establecer 
            //la conexión, tiempo de espera para la lectura de datos desde la conexión) 
            // Realizar la solicitud POST utilizando Unirest 
            HttpResponse<String> response =  
                Unirest.post(apiUrl) 
                        .header("Content-Type", "text/plain")// Establecer 
            //el tipo de contenido del cuerpo de la solicitud 
                        .body(requestBody).asString();// Establecer el 
            //cuerpo de la solicitud como el objeto JSON creado anteriormente 
            // Obtener la respuesta 
            int statusCode = response.getStatus(); 
            //obtiene el cuerpo de la respuesta 
            String responseBody = response.getBody(); 
            // Imprimir la respuesta en la consola 
            System.out.println("Código de estado: " + statusCode); 
            System.out.println("Cuerpo de la respuesta: " + responseBody); 
            // Imprimir la respuesta en la consola 
            System.out.println("Código de estado: " + statusCode); 
            System.out.println("Cuerpo de la respuesta: " + responseBody); 
            System.out.println("userSecret :" + userSecret); 
            System.out.println("SecretHash :" + SecretHash); 
            System.out.println("user :" + user); 
            System.out.println("userId :" + userId); 
            System.out.println("Json :" + datajson); 
            System.out.println("User :" + user);
            System.out.println("Token 1 :" + token1);
            System.out.println("Token 2 :" + token2);
            System.out.println("AuthToken :" + AuthToken);
//            System.out.println("requestBodyok :" + requestBodyok);
//            System.out.println("request :" + request);
        }catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
    public static String fechaActual(){
        // Definir el formato de la fecha
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Obtener la fecha y hora actual
        LocalDateTime fechaYHoraActual = LocalDateTime.now();
        // Convertir LocalDateTime a Date
        Date fechaComoDate = java.sql.Timestamp.valueOf(fechaYHoraActual);
        // Formatear la fecha y hora actual
        String requestDateTime = formato.format(fechaComoDate);
        return requestDateTime;
    }
    public static String objetoJson(){
        JSONObject jsonObject = new JSONObject();
        // Agregar datos al JSONObject
        jsonObject.put("string", "Ping");
        // Convertir JSONObject a String
        String jsonString = jsonObject.toString();
        return jsonString;
    }
}
