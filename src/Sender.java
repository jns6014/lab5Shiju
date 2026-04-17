import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Sender {
    public static void main(String[] args) throws Exception {
        String key = "Joe";
        String message = "Hello_Earth";

        // Create HMAC using SHA-256
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(key.getBytes(), "HmacSHA256"));
        String hmac = Base64.getEncoder()
                .encodeToString(mac.doFinal(message.getBytes()));

        // Output what is being "sent"
        System.out.println("=== SENDER ===");
        System.out.println("Message Sent: " + message);
        System.out.println("HMAC Sent: " + hmac);
    }
}