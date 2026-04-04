import java.security.MessageDigest;

public class Main {
    public static void main(String[] args) throws Exception {
        // OWASP A02: Cryptographic Failures
        // MD5 es un algoritmo roto y prohibido en estándares de seguridad
        MessageDigest md = MessageDigest.getInstance("MD5");
        
        String password = "mi_password_secreta";
        md.update(password.getBytes());
        byte[] digest = md.digest();
        
        System.out.println("Hash generado con MD5.");
    }
}
