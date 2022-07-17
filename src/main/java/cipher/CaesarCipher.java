package cipher;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Fork(value = 1)
@Warmup(iterations = 3)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class CaesarCipher {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String message, int shiftKey) {
        message = message.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < message.length(); i++) {
            int charPosition = ALPHABET.indexOf(message.charAt(i));

            if (charPosition == -1) {
                cipherText += message.charAt(i);
                continue;
            }
            int keyVal = (shiftKey + charPosition) % 26;
            if (keyVal < 0) {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            cipherText += replaceVal;
        }
        return cipherText;
    }

    public static String decrypt(String cipherText, int shiftKey) {
        cipherText = cipherText.toLowerCase();
        String message = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));

            if (charPosition == -1) {
                message += cipherText.charAt(i);
                continue;
            }
            int keyVal = (charPosition - shiftKey) % 26;
            if (keyVal < 0) {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            message += replaceVal;
        }
        return message;
    }

//    @Benchmark
//    public void testEncrypt(){
//        encrypt("Hello Everyone", 2);
//    }
//
//    @Benchmark
//    public void testDecrypt(){
//
//        decrypt("Hello Everyone", 2);
//
//    }


}
