/**
 * 
 */
package Utilities;

/**
 * @author ptkie
 *
 */
public class DBUtility {

	public static String toDBString(String str) {
		if (str != null) {
			return "'" + str + "'";
		}
		return str;
	}
}
