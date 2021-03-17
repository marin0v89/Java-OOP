package C06_SOLID.model.appenders;

import C06_SOLID.api.Appender;
import C06_SOLID.api.Layout;
import C06_SOLID.enums.ReportLevel;

public abstract class BaseAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private int messagesAppendedCount;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
        this.messagesAppendedCount = 0;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public void appendMessage(String dateTime, ReportLevel reportLevel, String message) {
        if (reportLevel.ordinal()>=this.reportLevel.ordinal()){
            String result = String.format(this.layout.getLayout(),dateTime,reportLevel,message);
            this.append(result);
            this.messagesAppendedCount++;
        }
    }
    protected abstract void append(String result);

    @Override
    public String toString() {
        return String.format("Appender type: %s, C06_SOLID.api.Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel.name(),
                this.messagesAppendedCount);
    }
}
