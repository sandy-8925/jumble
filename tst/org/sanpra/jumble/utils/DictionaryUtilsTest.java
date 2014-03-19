package org.sanpra.jumble.utils;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test class for DictionaryUtils
 */
public class DictionaryUtilsTest {

    @Test
    public void testIsValidWordReturnsFalseForNullInput() {
        assertFalse(DictionaryUtils.isValidWord(null));
    }

    @Test
    public void testIsValidWordReturnsFalseForBlankInput() {
        assertFalse(DictionaryUtils.isValidWord(""));
    }

    @Test
    public void testIsValidWordReturnsTrueForDictionaryWord() {
        assertTrue(DictionaryUtils.isValidWord("abandon"));
    }

    @Test
    public void testIsValidWordReturnsFalseForNonDictionaryWord() {
        assertFalse(DictionaryUtils.isValidWord("glamdring"));
    }
}
