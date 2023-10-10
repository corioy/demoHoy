package com.example.demo.trash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionDAO {

    protected Connection conexion = null;
    protected Statement sentencia = null;
    protected ResultSet resultado = null;
    private final String user = "postgres";
    private final String pass = "SECRET";
    private final String database = "test";

    protected void conectarBd() {
        try {
            Class.forName("org.postgresql.Driver");
            String urlDB = "jdbc:postgresql://localhost:5432/" + database +
                    "?useSSL=false";
            conexion = DriverManager.getConnection(urlDB, user, pass);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    protected void consultarBd(String query) {
        try {
            conectarBd();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(query);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    protected void desconectarBd() {
        try{
            if (resultado != null){
                resultado.close();
            }
            if (conexion != null) {
                conexion.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
