package core;

import lombok.experimental.UtilityClass;

import static org.joor.Reflect.on;

@UtilityClass
public class PageFactory {

    public static <T extends Page> T open(final Class<T> tClass) {
        return at(tClass);
    }

    public static <T extends Page> T at(final Class<T> pageClass) {
        return on(pageClass).create().get();
    }
}
