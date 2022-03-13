package trangbui.selenium.common;

public class MyDebug {
    /**
     * Find classname which call Log method
     * @return
     */
    public static String getCallerClassName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String callerClassName = null;
        for (int i=1; i<stackTraceElements.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElements[i];
            if (!stackTraceElement.getClassName().equals(MyDebug.class.getName())&& stackTraceElement.getClassName().indexOf("java.lang.Thread")!=0) {
                if (callerClassName==null) {
                    callerClassName = stackTraceElement.getClassName();
                } else if (!callerClassName.equals(stackTraceElement.getClassName())) {
                    return stackTraceElement.getClassName();
                }
            }
        }
        return null;
    }
}
