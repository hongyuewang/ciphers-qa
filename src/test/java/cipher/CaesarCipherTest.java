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
    }
}
