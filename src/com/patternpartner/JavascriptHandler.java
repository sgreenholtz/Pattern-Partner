package com.patternpartner; 
 
import javax.script.*;

/**
 * This class helps translate javascript scripts and variables into Java objects.
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/javax/script/package-summary.html">Script API</a>
 * @author Sebastian Greenholtz
 */
public class JavascriptHandler {

  /**
   * Creates a script engine for Javascript
   * @return Javascript ScriptEngine
   */
  public ScriptEngine createScriptEngine() {
    ScriptEngineManager scriptEngineMgr = new ScriptEngineManager();
    ScriptEngine jsEngine = scriptEngineMgr.getEngineByName("JavaScript");
    
    if (jsEngine == null) {
        System.err.println("No script engine found for JavaScript");
        System.exit(1);
    }
    
    return jsEngine;
  }

  /**
   * Covnerts a Javascript int variable into a Java Integer object
   * @param intScript script containing a Javascript integer variable
   */
  public Integer convertInt(String intScript) throws ScriptException {
    ScriptEngine engine = createScriptEngine();
    engine.eval(intScript);
    
    
  }
}
