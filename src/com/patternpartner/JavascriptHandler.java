package com.patternpartner;

import org.mozilla.javascript.*;

/**
 * This class helps translate javascript scripts and variables into Java objects using Rhino package
 * @see <a href="https://developer.mozilla.org/en-US/docs/Mozilla/Projects/Rhino">Rhino</a>
 * @author Sebastian Greenholtz
 */
public class JavascriptHandler {
    private Scriptable scope;

    /**
     * Creates a Context and Scope variable and sets it to
     * scope instance
     */
    public JavascriptHandler() {
        scope = Context.enter().initStandardObjects();
    }

    public Scriptable getScope() {
        return scope;
    }

    /**
     * Takes a String representing a number value in javascript and returns an
     * Integer with that value
     * @param script Javascript value to parse
     * @return Integer of required value
     */
    public static Integer parseJsToInteger(String script) {
        Context cx = Context.enter();
        Integer intValue = -1;
        try {
            Scriptable scope = cx.initStandardObjects();
            cx.evaluateString(scope, script, "<cmd>", 1, null);
            Object x = scope.get("x", scope);
            if (x == Scriptable.NOT_FOUND) {
                System.out.println("x is not defined.");
            } else {
                intValue = Integer.parseInt(Context.toString(x));
            }
        } finally {
            Context.exit();
        }
        return intValue;
    }
}