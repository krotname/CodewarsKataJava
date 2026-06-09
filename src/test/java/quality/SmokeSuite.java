package quality;

import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * Smoke suite runs the kata-style unit surface while skipping integration/property tests.
 */
@Suite
@SelectPackages({
        "coderun",
        "interview",
        "kyu3",
        "kyu4",
        "kyu5",
        "kyu6",
        "kyu7",
        "leetcode",
        "other",
        "transactions"
})
@ExcludeClassNamePatterns({
        ".*InMemoryValidationServiceTest",
        ".*toCamelCaseTest"
})
@ExcludeTags({"integration", "property"})
public final class SmokeSuite {
    private SmokeSuite() {
    }
}
