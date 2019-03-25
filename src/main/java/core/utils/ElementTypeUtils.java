package core.utils;

import lombok.experimental.UtilityClass;
import one.util.streamex.StreamEx;
import org.openqa.selenium.WebElement;

import java.util.List;

@UtilityClass
public class ElementTypeUtils {

    public static <T> WebElement elementOf(final T element) {
        return (WebElement) element;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<WebElement> listOf(final T element) {
        return (List<WebElement>) element;
    }

    public static <T> StreamEx<WebElement> streamOf(final T element) {
        return StreamEx.of(listOf(element));
    }
}
