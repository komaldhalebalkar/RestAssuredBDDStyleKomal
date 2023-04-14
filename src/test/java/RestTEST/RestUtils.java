package RestTEST;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
public static String getName()
{
	String name=RandomStringUtils.randomAlphabetic(3);
	return ("komal"+name);
	}
public static String getJob()
{
	String job=RandomStringUtils.randomAlphabetic(3);
	return ("tester"+job);
	}
}
