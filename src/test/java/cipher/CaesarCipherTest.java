package cipher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CaesarCipherTest {

    @Test
    public void encryptForward() {
        String messageAlphabetOnly = "Hello world";
        String messageDigitsAndSymbols = "The year we live in, 2022, is not a leap year.";
        assertEquals( "mjqqt btwqi", CaesarCipher.encrypt(messageAlphabetOnly, 5));
        assertEquals( "dro iokb go vsfo sx, 2022, sc xyd k vokz iokb.", CaesarCipher.encrypt(messageDigitsAndSymbols, 10));
        assertEquals("hello world", CaesarCipher.encrypt(messageAlphabetOnly, 26));
        assertEquals("hello world", CaesarCipher.encrypt(messageAlphabetOnly, 0));
    }

    @Test
    public void encryptBackward() {
        String messageAlphabetOnly = "Goodbye";
        String messageDigitsAndSymbols = "123456789@! ;/";
        assertEquals("bjjywtz", CaesarCipher.encrypt(messageAlphabetOnly, -5));
        assertEquals("123456789@! ;/", CaesarCipher.encrypt(messageDigitsAndSymbols, -18));
        assertEquals("goodbye", CaesarCipher.encrypt(messageAlphabetOnly, -26));
    }

    @Test
    public void decryptForward() {
        String cipherAlphabetOnly = "Mjqqt btwqi";
        String cipherDigitsAndSymbols = "dro iokb go vsfo sx, 2022, sc xyd k vokz iokb.";
        assertEquals("hello world", CaesarCipher.decrypt(cipherAlphabetOnly, 5));
        assertEquals("the year we live in, 2022, is not a leap year.", CaesarCipher.decrypt(cipherDigitsAndSymbols, 10));
        assertEquals("mjqqt btwqi", CaesarCipher.decrypt(cipherAlphabetOnly, 26));
        assertEquals("mjqqt btwqi", CaesarCipher.decrypt(cipherAlphabetOnly, 0));
    }

    @Test
    public void decryptBackward() {
        String cipherAlphabetOnly = "Bjjywtz";
        String cipherDigitsAndSymbols = "123456789@! ;/";

        assertEquals("goodbye", CaesarCipher.decrypt(cipherAlphabetOnly, -5));
        assertEquals("123456789@! ;/", CaesarCipher.decrypt(cipherDigitsAndSymbols, -18));
        assertEquals("bjjywtz", CaesarCipher.encrypt(cipherAlphabetOnly, -26));
    }
}
