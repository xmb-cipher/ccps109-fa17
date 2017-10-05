import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.zip.Adler32;

public class TestMoreStringProblems {
    
    private MoreStringProblems msp = new MoreStringProblems();
    private static final int SEED = 12345;
    private static final int RUNS = 100000;
 
    private char randomChar(Random rng) {
        return (char)(rng.nextInt(200) + 97);
    }
    
    private String buildString(Random rng, int len) {
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < len; j++) {
            sb.append(randomChar(rng));
        }
        return sb.toString();
    }
    
    @Test
    public void testUniqueCharacters() {
        java.util.Random rng = new java.util.Random(SEED);
        Adler32 check = new Adler32();
        for(int i = 0; i < RUNS; i++) {
            int len = rng.nextInt(100) + (2 << rng.nextInt(5));
            String s = buildString(rng, len);
            String res = msp.uniqueCharacters(s);
            check.update(res.getBytes());
        }    
        assertEquals(464461313L, check.getValue());
    }
    
    private static final int CORUNS = 200;
    
    @Test
    public void testCountOccurrences() {
        java.util.Random rng = new java.util.Random(SEED);
        Adler32 check = new Adler32();
        for(int i = 0; i < RUNS; i++) {
            int len = rng.nextInt(100) + (2 << rng.nextInt(5));
            String text = buildString(rng, len);
            len = rng.nextInt(5) + 1;
            String pattern = buildString(rng, len);
            int count = msp.countOccurrences(text, pattern);
            check.update(count ^ i);
        }
        assertEquals(4183849501L, check.getValue());
    }
    
    @Test
    public void testCyclicLeftShift() {
        Random rng = new Random(SEED);
        for(int i = 0; i < CORUNS; i++) {
            String pattern = "";
            for(int j = 1; j <= i + 2; j++) {
                pattern += randomChar(rng);
            }
            for(int j = 0; j * j < 1_000_000_000; j++) {
                String rotated = msp.cyclicLeftShift(pattern, j);
                assertEquals(pattern.length(), rotated.length());
                for(int k = 0; k < rotated.length(); k++) {
                    assertEquals(
                        rotated.charAt(k),
                        pattern.charAt((k + j ) % pattern.length())
                    );   
                }
            }
        }
    }
    
    private static final int PIRUNS = 100000;
    @Test
    public void testParseInt() {
        Random rng = new Random(SEED);
        for(int i = 0; i < PIRUNS; i++) {
            String s = "";
            for(int k = 0; k < 1 || (k < 9 && rng.nextInt(100) > 20); k++) {
                s += (char)('0' + rng.nextInt(10));
            }
            while(s.length() > 1 && s.charAt(0) == '0') {
                s = s.substring(1); // remove 0 digits from the beginning
            }
            if(rng.nextBoolean() && !s.equals("0")) {
                s = "-" + s;
            }
            // Gold testing: compare result to that of existing function known correct.
            assertEquals(msp.parseInt(s), Integer.parseInt(s));
        }
    }
}