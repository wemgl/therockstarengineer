package com.therockstarengineer.desktop.models;

import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.concurrent.ThreadLocalRandom.current;
import static java.util.stream.IntStream.concat;
import static java.util.stream.IntStream.range;

/**
 * Generates a strong output consisting of any combination of letters (upper and lowercase),
 * numbers, and special characters. The output assumes only ASCII encoding.
 *
 * @see <a href="http://www.asciichart.com">Decimal ASCII Chart</a>
 */
public final class Password {
    private static final int DEFAULT_PASSWORD_LENGTH = 16;

    /**
     * Enumerates the set of options available for creating a strong password.
     */
    public enum Option {
        /**
         * The ASCII lowercase characters from a-z.
         */
        LOWERCASE_LETTERS(range(97, 122).toArray()),

        /**
         * The ASCII uppercase characters from A-Z.
         */
        UPPERCASE_LETTERS(range(65, 90).toArray()),

        /**
         * The ASCII digits from 0-9.
         */
        DIGITS(range(48, 57).toArray()),

        /**
         * Various special characters from different ranges of the ASCII encoding.
         */
        SPECIAL_CHARACTERS(concat(range(33, 47), range(58, 64)).toArray());

        final int[] characters;

        Option(int[] characters) {
            this.characters = characters;
        }
    }

    /**
     * Generates a strong password consisting of characters from the available options.
     *
     * @param options All options the password can fulfill. A password may not have a
     *                value from the given option.
     * @return A strong password consisting of characters specified by the options.
     */
    public String generate(Set<Option> options) {
        var characters = options.stream()
                                .flatMapToInt(option -> stream(option.characters))
                                .toArray();
        var password = new StringBuilder(DEFAULT_PASSWORD_LENGTH);
        while (password.length() < DEFAULT_PASSWORD_LENGTH) {
            password.append(nextCharacter(characters));
        }
        return password.toString();
    }

    private char nextCharacter(int[] characters) {
        var digit = current().nextInt(characters.length);
        return (char) characters[digit];
    }
}
