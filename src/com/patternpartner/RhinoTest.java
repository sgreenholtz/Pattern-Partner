package com.patternpartner;

import org.mozilla.javascript.*;

/**
 * Simple command line app to test Rhino package
 * @author Sebastian Greenholtz
 */
public class RhinoTest {
    public static void main(String[] args) {
        Context cx = Context.enter();
        try {
            Scriptable scope = cx.initStandardObjects();

            String s = "x = 7;";

            cx.evaluateString(scope, s, "<cmd>", 1, null);

            Object x = scope.get("x", scope);
            if (x == Scriptable.NOT_FOUND) {
                System.out.println("x is not defined.");
            } else {
                Integer intValue = Integer.parseInt(Context.toString(x));
            }

        } finally {
            Context.exit();
        }
    }
}
