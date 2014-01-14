package org.devtoolkit.regex;

import java.applet.Applet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Simple java applet to enable evaluating java regular expressions from browser
 * context.
 * 
 * @author Gurgen Nersesyan
 * 
 */
public class RegexInterpreter extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Pattern pattern;
	private String _lastError;

	/**
	 * 
	 * @return returns java version
	 */
	public String javaVersion() {
		return System.getProperty("java.version");
	}

	/**
	 * Compiles the regular expression and returns Pattern object
	 * 
	 * @param regex
	 *            regular expression to compile
	 * @param flags
	 *            flags
	 * @see lastError()
	 * 
	 * @return Pattern if compilation was successful, null otherwise
	 */
	public Pattern compile(String regex, int flags) {
		_lastError = null;
		try {
			pattern = Pattern.compile(regex, flags);
			return pattern;
		} catch (Exception e) {
			_lastError = e.getMessage();
		}
		return null;
	}

	/**
	 * Creates and returns instance of Matcher for current pattern.
	 * 
	 * @param input
	 * @return
	 */
	public Matcher matcher(String input) {
		return pattern != null ? pattern.matcher(input) : null;
	}

	/**
	 * 
	 * @return last error occurred during compile.
	 */
	public String lastError() {
		return _lastError;
	}
}
