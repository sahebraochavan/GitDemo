package sahebraochavanautomation.TestComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Day44Retry implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		int count=0;
		int maxTry=1;
		if(count<maxTry)
		{
			count++;
			return true;
		}
		return false;
	}

}
