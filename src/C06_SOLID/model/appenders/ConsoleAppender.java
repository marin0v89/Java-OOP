package C06_SOLID.model.appenders;

import C06_SOLID.api.Layout;

public class ConsoleAppender extends BaseAppender{
    public ConsoleAppender(Layout layout){
        super(layout);
    }
    @Override
    public void append(String message) {
        System.out.println(message);
    }
}
