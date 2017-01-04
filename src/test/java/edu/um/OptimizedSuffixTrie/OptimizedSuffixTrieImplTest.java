package edu.um.OptimizedSuffixTrie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * {@link edu.um.NotOptimizedSuffixTrie.SuffixTrieImplTest SuffixTrieImplTest} tests still apply for
 * the optimized OptimizedSuffixTrieImpl, so they will be recycled.
 */
public class OptimizedSuffixTrieImplTest {

    private OptimizedSuffixTrieImpl suffixTrie;
    private final String WORD_TEST = "hahaa";

    @Before
    public void setUp() throws Exception {
        suffixTrie = new OptimizedSuffixTrieImpl(WORD_TEST);
    }

    @Test
    public void substring_correctSubstringFirstPart() {
        final String substring = "ha";
        assertTrue(substring + " is a substring of " + WORD_TEST,
                suffixTrie.substring(substring));
    }

    @Test
    public void substring_correctSubstringLastPart() {
        final String substring = "aa";
        assertTrue(substring + " is a substring of " + WORD_TEST,
                suffixTrie.substring(substring));
    }

    @Test
    public void substring_correctSubstringMiddlePart() {
        final String substring = "aha";
        assertTrue(substring + " is a substring of " + WORD_TEST,
                suffixTrie.substring(substring));
    }

    @Test
    public void substring_incorrectSubstringPattern() {
        final String substring = "aah";
        assertFalse(substring + " is not a substring of " + WORD_TEST,
                suffixTrie.substring(substring));
    }

    @Test
    public void substring_incorrectSubstring_givenStringIsLonger() {
        final String substring = "hahaaa";
        assertFalse(substring + " is not a substring of " + WORD_TEST,
                suffixTrie.substring(substring));
    }

    @Test
    public void substring_incorrectSubstring_letterNotInAlphabet() {
        final String substring = "hacaa";
        assertFalse(substring + " is not a substring of " + WORD_TEST,
                suffixTrie.substring(substring));
    }

    @Test
    public void suffix_correctSuffix_removeFirstLetter() {
        final String suffix = "ahaa";
        assertTrue(suffix + " is a suffix of " + WORD_TEST,
                suffixTrie.suffix(suffix));
    }

    @Test
    public void suffix_correctSuffix_lastTwoLetters() {
        final String suffix = "aa";
        assertTrue(suffix + " is a suffix of " + WORD_TEST,
                suffixTrie.suffix(suffix));
    }

    @Test
    public void suffix_incorrectSuffix_letterNotInAlphabet() {
        final String suffix = "aca";
        assertFalse(suffix + " is not a suffix of " + WORD_TEST,
                suffixTrie.suffix(suffix));
    }

    @Test
    public void suffix_incorrectSuffix_firstFourLetters() {
        final String suffix = "haha";
        assertFalse(suffix + " is not a suffix of " + WORD_TEST,
                suffixTrie.suffix(suffix));
    }

    @Test
    public void count_substringAppearsTwice() {
        final String substring = "ha";
        assertTrue(suffixTrie.count(substring) == 2);
    }

    @Test
    public void count_substringAppearsOne() {
        final String substring = "ah";
        assertTrue(suffixTrie.count(substring) == 1);
    }

    @Test
    public void count_substringAppearNoWhere() {
        final String substring = "aah";
        assertTrue(suffixTrie.count(substring) == 0);
    }
}