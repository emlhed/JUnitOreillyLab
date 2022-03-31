import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

class StringTest {

    private String str;

    @BeforeAll
    static void beforAll() {
        System.out.println("intizial database connect");
    }

    @AfterAll
    static void AfterAll(TestInfo test) {
        System.out.println("database disconnect" + test.getDisplayName());
    }
    // fail("not yest implemented");

    @ParameterizedTest
    @ValueSource(strings = { "ABCD", "ABC", "A", "DEF"})
    void lenghtGreaterthenZero(String str)  {
        assertTrue(str.length()>0);
    }

    @ParameterizedTest (name = "{0} lenght is {1}")
    @CsvSource(value = { "abcd, ABCD", "abc, ABC", "'',''", "abs, ABS"})
    void tryCVS (String word, String capWord)  {
        assertEquals(capWord, word.toUpperCase());
    }

    @ParameterizedTest(name = "{0} length is {1}")
    @CsvSource(value = { "abcd, 4", "abc, 3", "'',0 ", "abcdef, 6"})
    void tryCVSLength (String word, int expectLength)  {
        assertEquals(expectLength, word.length());
    }

    @Test
    @DisplayName("when null ttrow expgt")
    void length_exept(){
        String stri = null;

        //int expectedLength = stri.length();
        assertThrows(NullPointerException.class,
                ()-> {
                    stri.length();
                }
        );
    }

    @Test
    void toUpperCase(){
        //String uppercase = "ABCD";
        String str = "abcd";
        String result = str.toUpperCase();
        assertEquals("ABCD", result);
        // fail("not yest implemented");
    }


    @Test
    void not_equals(){
        String str = "abcdef";
        boolean result = str.contains("jfk");
        // assertEquals(false, result);
        assertFalse(result);

    }

    @Test
    void not_equals_inline(){
        // assertEquals(false, result);
        assertFalse("abcdef".contains("jfk"));

    }

    // @Test
    @Disabled
    @RepeatedTest(10)
    void not_equals_inline_repeat(){
        // assertEquals(false, result);
        assertFalse("abcdef".contains("jfk"));

    }

    @Test
    void split_basic(){
        String letters = "abc def ghj";
        String[] actualRes = letters.split(" ");
        String[] expeResult = {"abc", "def", "ghj"};

        assertArrayEquals(expeResult,actualRes);
    }

    @Disabled
    @Test
    void preformTest(){
        assertTimeout(Duration.ofSeconds(5), ()-> {
            for (int i = 0; i <= 1000000; i++){
                int j = i;
                System.out.println(j);
            }
        });
    }

    @BeforeEach
    void beforEc(TestInfo info){
        System.out.println("Initialize Test Data for each test " + info.getDisplayName());
    }

    @AfterEach
    void afetreach (){
        System.out.println("clean up test Data for ");
    }



    @Nested
    @DisplayName("tomt test")
    class EmptyStringTest{
        @BeforeEach
        void setTtoEmpty(){
            str = "";
        }

        @Test
        void lengthIsZero(){
            assertEquals(0, str.length());
        }

        @Test
        void upperCaseIsEmpty(){
        assertEquals("", str.toUpperCase());
    }
    }

    @Nested
    @DisplayName("Longer text test")
    class LongStringTest{
        @BeforeEach
        void setToLong(){
            str = "jag heter emelie";
        }

        @Test
        void lengthIs16(){
            int totallenght = str.length();
            assertTrue(totallenght > 10);
        }

        @Test
        void upperCaseIsEmpty(){
            assertEquals("JAG HETER EMELIE", str.toUpperCase());
        }
    }
}
