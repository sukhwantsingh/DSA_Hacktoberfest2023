import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MD5EncodingDecoding {
    public static void main(String[] args) {
        String originalString = "Hello, World!";

        try {
            // Encode the original string to an MD5 hash
            String md5Hash = encodeToMD5(originalString);
            System.out.println("MD5 Hash: " + md5Hash);

            // Decode the MD5 hash back to the original string
            String decodedString = decodeFromMD5(md5Hash);
            System.out.println("Decoded String: " + decodedString);

            // Verify if the decoded string matches the original string
            if (originalString.equals(decodedString)) {
                System.out.println("Decoded string matches the original string.");
            } else {
                System.out.println("Decoded string does not match the original string.");
            }
        } catch (NoSuchAlgorithmException e) {
            System.err.println("MD5 algorithm is not available.");
            e.printStackTrace();
        }
    }

    // Function to encode a string into an MD5 hash
    public static String encodeToMD5(String originalString) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(originalString.getBytes());

        // Convert the byte array to a hexadecimal string
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }

    // Function to decode an MD5 hash back to the original string (not possible with MD5 alone)
    public static String decodeFromMD5(String md5Hash) {
        // MD5 is a one-way hash function, so decoding is not possible
        return "Decoding not possible for MD5 hash";
    }
}
