package effectivejava.item5;

import java.util.function.Supplier;

public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Supplier<? extends Lexicon> dictionaryFactory) {
        this.dictionary = dictionaryFactory.get();
    }
}
