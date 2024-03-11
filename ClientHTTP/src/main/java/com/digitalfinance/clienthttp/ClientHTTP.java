/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.digitalfinance.clienthttp;

//import com.digitalfinance.clienthttp.clientes.ClienteOKhttp;
import com.digitalfinance.clienthttp.clientes.PostNewRecord;
import com.mashape.unirest.http.exceptions.UnirestException;
import encriptador.JsonArrayJson;
import java.io.IOException;

public class ClientHTTP {
    public static void main(String[] args) throws IOException, UnirestException {
        //Post Test - Ping
        //ClienteOKhttp.PostOkHttp(); 
        PostNewRecord.PostOkHttp();
    }
}
