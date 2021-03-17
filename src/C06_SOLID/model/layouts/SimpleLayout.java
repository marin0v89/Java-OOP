package C06_SOLID.model.layouts;

import C06_SOLID.api.Layout;

public class SimpleLayout implements Layout {
    @Override
    public String getLayout() {
        return "%s - %s - %s";
    }
}
