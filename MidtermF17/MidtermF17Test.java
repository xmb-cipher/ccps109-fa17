import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;
import java.io.*;

import java.util.zip.Adler32;

/**
 * The test class MidtermF17Test.
 *
 * @author  Ilkka Kokkarinen
 * @version October 11, 2017
 */

public class MidtermF17Test {
    
    private static final int SEED = 7654321;
    private static final int TRIALS = 1000;
    private static final int REPS = 100;
    
    private String createHand(Random rng, int len) {
        String result = "";
        for(int i = 0; i < len; i++) {
            String card = "";
            outer:
            while(true) {
                card = "" + "23456789TJQKA".charAt(rng.nextInt(13));
                card += "cdhs".charAt(rng.nextInt(4));
                for(int j = 0; j < result.length(); j += 2) {
                    if(result.substring(j, j + 2).equals(card)) { continue outer; }
                }
                break;
            }
            result += card;
        }
        return result;
    }
    
    @Test
    public void testAddThree() {
        MidtermF17 mp = new MidtermF17();
        Adler32 check = new Adler32();
        Random rng = new Random(SEED);
        int count = 0;
        for(int i = 1; i < TRIALS; i++) {
            for(int j = 0; j < REPS; j++) {
                int a = rng.nextInt(4*i) - 2*i;
                int b = rng.nextInt(4*i) - 2*i;
                int c = rng.nextInt(4*i) - 2*i;
                int d = rng.nextInt(4*i) - 2*i;
                boolean result = mp.addThree(a, b, c, d);
                if(result) { count++; }
                check.update(result ? i : i - 1);
            }
        }
        assertEquals(315293652L, check.getValue());
        assertEquals(460, count);
    }
    
    @Test
    public void testBeats() {
        MidtermF17 mp = new MidtermF17();
        Adler32 check = new Adler32();
        Random rng = new Random(SEED);
        int count = 0;
        for(int i = 0; i < TRIALS; i++) {
            for(int j = 0; j < REPS; j++) {
                String c1 = createHand(rng, 1);
                String c2 = createHand(rng, 1);
                if(c1.equals(c2)) { continue; }
                for(int k = 0; k < 4; k++) {
                    boolean result = mp.beats(c1, c2, "cdhs".charAt(k));
                    if(result) { count++; }
                    check.update(result ? i : i - 1);
                }
            }
        }
        //System.out.println(check.getValue() + " " + count);
        assertEquals(177947107L, check.getValue());
        assertEquals(121569, count);        
    }
    
    @Test
    public void testWinningCard() {
        MidtermF17 mp = new MidtermF17();
        Adler32 check = new Adler32();
        Random rng = new Random(SEED);
        for(int i = 0; i < TRIALS; i++) {
            for(int j = 0; j < REPS; j++) {
                String trick = createHand(rng, 4);
                for(int k = 0; k < 4; k++) {
                    String result = mp.winningCard(trick, "cdhs".charAt(k));
                    check.update(result.getBytes());
                }
            }
        }
        //System.out.println(check.getValue());
        assertEquals(4084951176L, check.getValue());
    }
    
    @Test
    public void testCountOccurrences() {
        MidtermF17 mp = new MidtermF17();
        Adler32 check = new Adler32();
        Random rng = new Random(SEED);
        int count = 0;
        for(int i = 0; i < TRIALS; i++) {
            for(int j = 0; j < REPS; j++) {
                int number = rng.nextInt(1000000000);
                int pattern = rng.nextInt(100);
                int result = mp.countOccurrences(number, pattern);
                count += result;
                check.update(result * i);
            }
        }
        assertEquals(2078607780L, check.getValue());
        assertEquals(16321, count);
    }
}