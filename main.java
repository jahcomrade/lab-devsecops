import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. LEAKS: Una llave de AWS (Gitleaks lo detectará)
        String secret = "AKIAIMNO7YFZ5EXAMPLE";
        
        // 2. OWASP A03:2021 (Inyección SQL): Concatenar entrada en un Query
        String id = "101"; // Imagina que esto viene de un usuario
        String query = "SELECT * FROM users WHERE id = " + id; 
        
        System.out.println("Ejecutando: " + query);
    }
}
