package quality;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * Integration suite groups stateful transaction validation scenarios.
 */
@Suite
@SelectPackages("transactions")
@IncludeClassNamePatterns(".*InMemoryValidationServiceTest")
public final class IntegrationSuite {
    private IntegrationSuite() {
    }
}
