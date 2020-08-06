package org.dicio.component.standard.word;

public abstract class StringWord extends BaseWord {

    /**
     * A word in a sentence with the indices of all possible subsequent words. Use
     * {@link DiacriticsSensitiveWord} for diacritics-sensitive matching and
     * {@link DiacriticsInsensitiveWord} for diacritics-insensitive matching.
     *
     * @param minimumSkippedWordsToEnd the minimum number of subsequent words that have to be
     *                                 skipped to reach the end of the sentence. Used in case the
     *                                 end of input is reached on this word. Capturing groups count
     *                                 as if two words were skipped.
     * @param nextIndices the indices of all possible subsequent words in the owning sentence; it
     *                    must always contain a value; use the length of the word array to represent
     */
    public StringWord(int minimumSkippedWordsToEnd, int... nextIndices) {
        super(minimumSkippedWordsToEnd, nextIndices);
    }

    /**
     * Whether this StringWord matches the provided input word.
     * @param inputWord the input word in string format
     * @param inputWordCollationKey the collation key of the input word, needed for
     *                              diacritics-insensitive matching, built with
     *                              {@link DiacriticsInsensitiveWord#getCollationKey(String)}
     * @return whether the input words matches this word or not
     */
    public abstract boolean matches(String inputWord, byte[] inputWordCollationKey);
}
