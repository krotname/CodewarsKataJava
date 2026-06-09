package quality;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * Property suite keeps invariant checks isolated from the default and smoke matrix.
 * It currently groups the curated set of jqwik-focused suites and can be expanded
 * to additional property-oriented classes when needed.
 */
@Suite
@SelectPackages({"kyu6", "kyu7"})
@IncludeClassNamePatterns(".*(toCamelCaseTest|SumOddNumbersPropertyTest|ValidatePinPropertyTest)")
@IncludeTags("property")
public final class PropertySuite {
    private PropertySuite() {
    }
}
