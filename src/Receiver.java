import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class Receiver {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Simulate receiving message + HMAC
        System.out.print("Enter received message: ");
        String message = sc.nextLine();
        System.out.print("Enter received HMAC: ");
        String receivedHmac = sc.nextLine();
        String key = "Joe";

        // Generate HMAC again
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(key.getBytes(), "HmacSHA256"));
        String generatedHmac = Base64.getEncoder()
                .encodeToString(mac.doFinal(message.getBytes()));

        // Output everything
        System.out.println("\n=== RECEIVER ===");
        System.out.println("Received Message: " + message);
        System.out.println("Received HMAC: " + receivedHmac);
        System.out.println("Generated HMAC: " + generatedHmac);

        // CORRECT comparison
        if (generatedHmac.equals(receivedHmac)) {
            System.out.println("VALID MESSAGE");
        } else {
            System.out.println("TAMPERED MESSAGE");
        }
    }
}