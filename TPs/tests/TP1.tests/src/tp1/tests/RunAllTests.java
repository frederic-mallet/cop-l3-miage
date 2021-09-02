package tp1.tests;

import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

public class RunAllTests extends RunListener {
	public static void main(String[] args) throws Throwable {
		@SuppressWarnings("deprecation")
		AllDefaultPossibilitiesBuilder builder = new AllDefaultPossibilitiesBuilder(false);
		Runner runner = builder.runnerForClass(AllTests.class);
		RunNotifier notifier = new RunNotifier();
		notifier.addListener(new RunAllTests());
		runner.run(notifier);
	}
	@Override
	public void testFailure(Failure failure) throws Exception {
		System.out.println("Fail : " + failure);
	}
	
	@Override
	public void testStarted(Description description) throws Exception {
		System.out.println("Run test " + description.getTestClass().getName() + " " + description.getMethodName());
	}
	@Override
	public void testRunFinished(Result result) throws Exception {
		System.out.println("Test ran in " + result.getRunTime());
		System.out.println("Test count " + result.getRunCount());
		System.out.println("Test ignored " + result.getIgnoreCount());
		System.out.println("Test failed " + result.getFailureCount());
		
		for (Failure f : result.getFailures()) {
			Description d = f.getDescription();
			System.out.println(d.getTestClass().getName() + " " + d.getMethodName() + "failed with " + f.getMessage());
			System.out.println("\t" + f.getTestHeader());
		}
	}
}
