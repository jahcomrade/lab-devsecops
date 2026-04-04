package com.vulnerable.app;

import java.sql.*;
import java.security.MessageDigest;
import java.io.*;

public class VulnerableController {

    // 1. OWASP A03: Inyección SQL pura PRUEBA DE PULL REQUEST
    public void getUser(String userId) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "admin", "p4ssw0rd123");
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM users WHERE id = '" + userId + "'";
        stmt.executeQuery(query);
    }

    // 2. OWASP A02: Criptografía Débil
    public String hashPassword(String pass) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pass.getBytes());
        return new String(md.digest());
    }

    // 3. OWASP A07: Identificación y Autenticación Fallida (Hardcoded Credentials)
    private static final String AWS_KEY = "AKIAQAAAAAAABBBBBBBB";
    private static final String SECRET = "wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";

    // 4. Deserialización Insegura
    public Object deserialize(byte[] data) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
        return ois.readObject();
    }
}
