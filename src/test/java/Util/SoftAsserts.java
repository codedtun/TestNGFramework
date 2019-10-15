package Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

public class SoftAsserts {

//    private static Map> verificationFailuresMap = new HashMap>();
//
//    public static void assertTrue(boolean condition) {
//        Assert.assertTrue(condition);
//    }
//
//    public static void assertFalse(boolean condition) {
//        Assert.assertFalse(condition);
//    }
//
//    public static void assertEquals(Object actual, Object expected) {
//        Assert.assertEquals(actual, expected);
//    }
//
//    public static void verifyTrue(boolean condition) {
//        try {
//            assertTrue(condition);
//        } catch(Throwable e) {
//            addVerificationFailure(e);
//        }
//    }
//
//    public static void verifyFalse(boolean condition) {
//        try {
//            assertFalse(condition);
//        } catch(Throwable e) {
//            addVerificationFailure(e);
//        }
//    }
//
//    public static void verifyEquals(Object actual, Object expected) {
//        try {
//            assertEquals(actual, expected);
//        } catch(Throwable e) {
//            addVerificationFailure(e);
//        }
//    }
//
//    public static List getVerificationFailures() {
//        List verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
//        return verificationFailures == null ? new ArrayList() : verificationFailures;
//    }
//
//    private static void addVerificationFailure(Throwable e) {
//        List verificationFailures = getVerificationFailures();
//        verificationFailuresMap.put(Reporter.getCurrentTestResult(), verificationFailures);
//        verificationFailures.add(e);
//    }

}