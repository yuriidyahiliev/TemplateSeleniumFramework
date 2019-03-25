package core;

import static core.BaseConfig.BASE_CONFIG;

public interface Page {

    default Page navigateTo() {
        return navigateTo();
    }

    Page navigate(final String url);

    default String url() {
        return BASE_CONFIG.url();
    }
}
