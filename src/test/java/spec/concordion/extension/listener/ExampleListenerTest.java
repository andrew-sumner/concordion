package spec.concordion.extension.listener;

import java.util.List;

import org.concordion.api.BeforeSpecification;
import org.concordion.api.extension.Extension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import spec.concordion.extension.AbstractExtensionTestCase;
import test.concordion.extension.ExampleTestExtension;

@RunWith(ConcordionRunner.class)
public class ExampleListenerTest extends AbstractExtensionTestCase {

	@Extension
	public ExampleTestExtension extension = new ExampleTestExtension();

    @BeforeSpecification
    public void beforeSpec() {
        extension.withStream(getLogStream());
    }
	
    public double sqrt(double num) {
        return Math.sqrt(num);
    }
    
    public List<String> getEventLogExcludingCheck() {
        List<String> eventLog = getEventLog();
        eventLog.remove("Before example 'check-results'");
        return eventLog;
    }
}
