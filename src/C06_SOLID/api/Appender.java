package C06_SOLID.api;

import C06_SOLID.enums.ReportLevel;

public interface Appender {
    void appendMessage(String dateTime,ReportLevel reportLevel,String message);

    void setReportLevel(ReportLevel reportLevel);

}
