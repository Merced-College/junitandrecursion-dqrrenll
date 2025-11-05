//Darren Hagood
//10-30-2025
//Test class


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RecursionProblemsTest {

    // ---- count8 ----
    @Test
    void count8_singleEight() {
        assertEquals(1, RecursionProblems.count8(8));
    }

    @Test
    void count8_mixture() {
        assertEquals(2, RecursionProblems.count8(818));
    }

    @Test
    void count8_doubleCounts() {
        assertEquals(4, RecursionProblems.count8(8818));
    }

    @Test
    void count8_tripleEights() {
        assertEquals(5, RecursionProblems.count8(888));
    }

    @Test
    void count8_zeroAndNoEights() {
        assertEquals(0, RecursionProblems.count8(0));
        assertEquals(0, RecursionProblems.count8(1234567));
    }

    // ---- countHi ----
    @Test
    void countHi_basic() {
        assertEquals(1, RecursionProblems.countHi("xxhixx"));
    }

    @Test
    void countHi_two() {
        assertEquals(2, RecursionProblems.countHi("xhixhix"));
    }

    @Test
    void countHi_exact() {
        assertEquals(1, RecursionProblems.countHi("hi"));
    }

    @Test
    void countHi_overlappingLikeHihi() {
        assertEquals(2, RecursionProblems.countHi("hihi"));
    }

    @Test
    void countHi_noneOrShort() {
        assertEquals(0, RecursionProblems.countHi("abc"));
        assertEquals(0, RecursionProblems.countHi("h"));
        assertEquals(0, RecursionProblems.countHi(""));
    }

    // ---- countHi2 ----
    @Test
    void countHi2_skipXhi() {
        assertEquals(1, RecursionProblems.countHi2("ahixhi")); // "xhi" skipped, trailing "hi" counted
    }

    @Test
    void countHi2_normalHis() {
        assertEquals(2, RecursionProblems.countHi2("ahibhi")); // both "hi" counted
    }

    @Test
    void countHi2_skipAllXhi() {
        assertEquals(0, RecursionProblems.countHi2("xhixhi"));
    }

    @Test
    void countHi2_edgeAtStart() {
        assertEquals(0, RecursionProblems.countHi2("xhi")); // exactly "xhi" => 0
    }

    @Test
    void countHi2_mixed() {
        assertEquals(2, RecursionProblems.countHi2("hixhihi")); // "hi" (0), "xhi" skip, "hi"(5)
    }

    // ---- strCount ----
    @Test
    void strCount_simple() {
        assertEquals(2, RecursionProblems.strCount("catcowcat", "cat"));
        assertEquals(1, RecursionProblems.strCount("catcowcat", "cow"));
        assertEquals(0, RecursionProblems.strCount("catcowcat", "dog"));
    }

    @Test
    void strCount_nonOverlapping() {
        assertEquals(2, RecursionProblems.strCount("aaaa", "aa")); // non-overlapping: positions (0..1) and (2..3)
    }

    @Test
    void strCount_subLongerThanStr() {
        assertEquals(0, RecursionProblems.strCount("hi", "hii"));
    }

    @Test
    void strCount_emptyOrNull() {
        assertEquals(0, RecursionProblems.strCount("", "a"));
        assertEquals(0, RecursionProblems.strCount("abc", ""));
    }

    @Test
    void strCount_various() {
        assertEquals(3, RecursionProblems.strCount("xxx", "x"));
    }

    // ---- stringClean ----
    @Test
    void stringClean_runs() {
        assertEquals("yza", RecursionProblems.stringClean("yyzzza"));
        assertEquals("abcd", RecursionProblems.stringClean("abbbcdd"));
        assertEquals("Helo", RecursionProblems.stringClean("Hello"));
    }

    @Test
    void stringClean_noChange() {
        assertEquals("abc", RecursionProblems.stringClean("abc"));
    }

    @Test
    void stringClean_allSame() {
        assertEquals("a", RecursionProblems.stringClean("aaaaaaa"));
    }

    @Test
    void stringClean_edgecases() {
        assertNull(RecursionProblems.stringClean(null));
        assertEquals("", RecursionProblems.stringClean(""));
        assertEquals("a", RecursionProblems.stringClean("a"));
    }

    @Test
    void stringClean_mixed() {
        assertEquals("abc", RecursionProblems.stringClean("aabbcc"));
    }
}