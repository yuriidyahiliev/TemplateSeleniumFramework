package core;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.BiFunction;
import java.util.function.Function;

@RequiredArgsConstructor
public enum UiCondition {

    visible(ExpectedConditions::visibilityOfElementLocated),
    present(ExpectedConditions::presenceOfElementLocated),
    enabled((Function<By, ExpectedCondition<?>>) ExpectedConditions::elementToBeClickable),
    allVisible(ExpectedConditions::visibilityOfAllElementsLocatedBy),
    allPresent(ExpectedConditions::presenceOfAllElementsLocatedBy),
    valueToBe((BiFunction<By, String, ExpectedCondition<?>>) ExpectedConditions::textToBe);

    private final BiFunction<?, ?, ExpectedCondition<?>> type;

    <T, V> UiCondition(final Function<T, ExpectedCondition<?>> type) {
        this((T arg1, V arg2) -> type.apply(arg1));
    }

    @SuppressWarnings("unchecked")
    public <T, V, R> BiFunction<T, V, R> getType() {
        return (BiFunction<T, V, R>) type;
    }
}
