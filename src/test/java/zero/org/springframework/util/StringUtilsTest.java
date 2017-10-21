package zero.org.springframework.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class StringUtilsTest {

    @Test
    public void testIsEmpty() throws Exception {
        boolean result = StringUtils.isEmpty(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testHasLength() throws Exception {
        boolean result = StringUtils.hasLength(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testHasLength2() throws Exception {
        boolean result = StringUtils.hasLength("str");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testHasText() throws Exception {
        boolean result = StringUtils.hasText(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testHasText2() throws Exception {
        boolean result = StringUtils.hasText("str");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testContainsWhitespace() throws Exception {
        boolean result = StringUtils.containsWhitespace(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testContainsWhitespace2() throws Exception {
        boolean result = StringUtils.containsWhitespace("str");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testTrimWhitespace() throws Exception {
        String result = StringUtils.trimWhitespace("str");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testTrimAllWhitespace() throws Exception {
        String result = StringUtils.trimAllWhitespace("str");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testTrimLeadingWhitespace() throws Exception {
        String result = StringUtils.trimLeadingWhitespace("str");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testTrimTrailingWhitespace() throws Exception {
        String result = StringUtils.trimTrailingWhitespace("str");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testTrimLeadingCharacter() throws Exception {
        String result = StringUtils.trimLeadingCharacter("str", 'a');
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testTrimTrailingCharacter() throws Exception {
        String result = StringUtils.trimTrailingCharacter("str", 'a');
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testStartsWithIgnoreCase() throws Exception {
        boolean result = StringUtils.startsWithIgnoreCase("str", "prefix");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testEndsWithIgnoreCase() throws Exception {
        boolean result = StringUtils.endsWithIgnoreCase("str", "suffix");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testSubstringMatch() throws Exception {
        boolean result = StringUtils.substringMatch(null, 0, null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testCountOccurrencesOf() throws Exception {
        int result = StringUtils.countOccurrencesOf("str", "sub");
        Assert.assertEquals(0, result);
    }

    @Test
    public void testReplace() throws Exception {
//        String result = StringUtils.replace("inString", "oldPattern", "newPattern");
        String result = StringUtils.replace("1234223", "2", "***");
        Assert.assertEquals("1***34******3", result);
    }

    @Test
    public void testDelete() throws Exception {
        String result = StringUtils.delete("inString", "pattern");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testDeleteAny() throws Exception {
        String result = StringUtils.deleteAny("inString", "charsToDelete");
        Assert.assertEquals("inSing", result);
    }

    @Test
    public void testQuote() throws Exception {
        String result = StringUtils.quote("str");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testQuoteIfString() throws Exception {
        Object result = StringUtils.quoteIfString(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testUnqualify() throws Exception {
        String result = StringUtils.unqualify("qualifiedName");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testUnqualify2() throws Exception {
        String result = StringUtils.unqualify("qualifiedName", 'a');
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testCapitalize() throws Exception {
        String result = StringUtils.capitalize("str");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testUncapitalize() throws Exception {
        String result = StringUtils.uncapitalize("str");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGetFilename() throws Exception {
        String result = StringUtils.getFilename("path");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGetFilenameExtension() throws Exception {
        String result = StringUtils.getFilenameExtension("path");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testStripFilenameExtension() throws Exception {
        String result = StringUtils.stripFilenameExtension("path");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testApplyRelativePath() throws Exception {
        String result = StringUtils.applyRelativePath("path", "relativePath");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testCleanPath() throws Exception {
        String result = StringUtils.cleanPath("path");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testPathEquals() throws Exception {
        boolean result = StringUtils.pathEquals("path1", "path2");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testUriDecode() throws Exception {
        String result = StringUtils.uriDecode("source", null);
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testParseLocaleString() throws Exception {
        Locale result = StringUtils.parseLocaleString("localeString");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testToLanguageTag() throws Exception {
        String result = StringUtils.toLanguageTag(null);
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testParseTimeZoneString() throws Exception {
        TimeZone result = StringUtils.parseTimeZoneString("timeZoneString");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testAddStringToArray() throws Exception {
        String[] result = StringUtils.addStringToArray(new String[]{"array"}, "str");
        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

    @Test
    public void testConcatenateStringArrays() throws Exception {
        String[] result = StringUtils.concatenateStringArrays(new String[]{"array1"}, new String[]{"array2"});
        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

    @Test
    public void testMergeStringArrays() throws Exception {
        String[] result = StringUtils.mergeStringArrays(new String[]{"array1"}, new String[]{"array2"});
        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

    @Test
    public void testSortStringArray() throws Exception {
        String[] result = StringUtils.sortStringArray(new String[]{"array"});
        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

    @Test
    public void testToStringArray() throws Exception {
        String[] result = StringUtils.toStringArray(Arrays.<String>asList("String"));
        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

//    @Test
//    public void testToStringArray2() throws Exception {
//        String[] result = StringUtils.toStringArray(null);
//        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
//    }

    @Test
    public void testTrimArrayElements() throws Exception {
        String[] result = StringUtils.trimArrayElements(new String[]{"array"});
        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

    @Test
    public void testRemoveDuplicateStrings() throws Exception {
        String[] result = StringUtils.removeDuplicateStrings(new String[]{"array"});
        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

    @Test
    public void testSplit() throws Exception {
        String[] result = StringUtils.split("toSplit", "delimiter");
        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

    @Test
    public void testSplitArrayElementsIntoProperties() throws Exception {
        Properties result = StringUtils.splitArrayElementsIntoProperties(new String[]{"array"}, "delimiter");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testSplitArrayElementsIntoProperties2() throws Exception {
        Properties result = StringUtils.splitArrayElementsIntoProperties(new String[]{"array"}, "delimiter", "charsToDelete");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testTokenizeToStringArray() throws Exception {
        String[] result = StringUtils.tokenizeToStringArray("str", "delimiters");
        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

    @Test
    public void testTokenizeToStringArray2() throws Exception {
        String[] result = StringUtils.tokenizeToStringArray("str", "delimiters", true, true);
        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

    @Test
    public void testDelimitedListToStringArray() throws Exception {
        String[] result = StringUtils.delimitedListToStringArray("str", "delimiter");
        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

    @Test
    public void testDelimitedListToStringArray2() throws Exception {
//        String[] result = StringUtils.delimitedListToStringArray("str", "", "charsToDelete");
//        String[] result = StringUtils.delimitedListToStringArray("str", "", "charsToDelete");
        String[] result = StringUtils.delimitedListToStringArray("str1str", "1", "");
        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

    @Test
    public void testCommaDelimitedListToStringArray() throws Exception {
        String[] result = StringUtils.commaDelimitedListToStringArray("str");
        Assert.assertArrayEquals(new String[]{"replaceMeWithExpectedResult"}, result);
    }

    @Test
    public void testCommaDelimitedListToSet() throws Exception {
        Set<String> result = StringUtils.commaDelimitedListToSet("str");
        Assert.assertEquals(new HashSet<String>(Arrays.asList("String")), result);
    }

//    @Test
//    public void testCollectionToDelimitedString() throws Exception {
//        String result = StringUtils.collectionToDelimitedString(Arrays.<?>asList(null), "delim", "prefix", "suffix");
//        Assert.assertEquals("replaceMeWithExpectedResult", result);
//    }
//
//    @Test
//    public void testCollectionToDelimitedString2() throws Exception {
//        String result = StringUtils.collectionToDelimitedString(Arrays.<?>asList(null), "delim");
//        Assert.assertEquals("replaceMeWithExpectedResult", result);
//    }
//
//    @Test
//    public void testCollectionToCommaDelimitedString() throws Exception {
//        String result = StringUtils.collectionToCommaDelimitedString(Arrays.<?>asList(null));
//        Assert.assertEquals("replaceMeWithExpectedResult", result);
//    }

    @Test
    public void testArrayToDelimitedString() throws Exception {
        String result = StringUtils.arrayToDelimitedString(new Object[]{null}, "delim");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testArrayToCommaDelimitedString() throws Exception {
        String result = StringUtils.arrayToCommaDelimitedString(new Object[]{null});
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme