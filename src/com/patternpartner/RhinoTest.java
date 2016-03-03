package com.patternpartner;

import org.mozilla.javascript.*;
import java.util.*;
import javax.script.*;

/**
 * Simple command line app to test Rhino package
 * @author Sebastian Greenholtz
 */
public class RhinoTest {

    ArrayList<String> lineClass = new ArrayList<>();
    ArrayList<String> lines = new ArrayList<>();

    public RhinoTest() {
        lines.add("one");
        lines.add("two");
        lines.add("three");
        lines.add("four");
        lines.add("five");

        lineClass.add("");
        lineClass.add("");
        lineClass.add("");
        lineClass.add("");
        lineClass.add("");
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public ArrayList<String> getLineClass() {
        return lineClass;
    }

    /**
     * Rhino script testing
     * @param args
     */
    /*public static void main(String[] args) {
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
    }*/

    /**
     * Javax.script testing
     */
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager scriptEngineMgr = new ScriptEngineManager();
        ScriptEngine jsEngine = scriptEngineMgr.getEngineByName("JavaScript");

        if (jsEngine == null) {
            System.err.println("No script engine found for JavaScript");
            System.exit(1);
        }

        jsEngine.eval("function ");
    }

}
