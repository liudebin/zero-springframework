package org.springframework.util;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ClassUtilsTest {


    @Test
    public void testOverrideThreadContextClassLoader() throws Exception {
        ClassLoader result = ClassUtils.overrideThreadContextClassLoader(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testForName() throws Exception {
        Class<?> result = ClassUtils.forName("javax.inject.Provider", DefaultListableBeanFactory.class.getClassLoader());
        Assert.assertEquals(null, result);
    }

    @Test
    public void testResolveClassName() throws Exception {
        Class<?> result = ClassUtils.resolveClassName("className", null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testResolvePrimitiveClassName() throws Exception {
        Class<?> result = ClassUtils.resolvePrimitiveClassName("name");
        Assert.assertEquals(null, result);
    }

    @Test
    public void testIsPresent() throws Exception {
        boolean result = ClassUtils.isPresent("className", null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetUserClass() throws Exception {
        Class<?> result = ClassUtils.getUserClass(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetUserClass2() throws Exception {
        Class<?> result = ClassUtils.getUserClass(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testIsCacheSafe() throws Exception {
        boolean result = ClassUtils.isCacheSafe(null, null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetShortName() throws Exception {
        String result = ClassUtils.getShortName("className");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGetShortName2() throws Exception {
//        String result = ClassUtils.getShortName(null);
//        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGetShortNameAsProperty() throws Exception {
        String result = ClassUtils.getShortNameAsProperty(null);
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGetClassFileName() throws Exception {
        String result = ClassUtils.getClassFileName(null);
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGetPackageName() throws Exception {
//        String result = ClassUtils.getPackageName(null);
//        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGetPackageName2() throws Exception {
        String result = ClassUtils.getPackageName("fqClassName");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGetQualifiedName() throws Exception {
        String result = ClassUtils.getQualifiedName(null);
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGetQualifiedMethodName() throws Exception {
        String result = ClassUtils.getQualifiedMethodName(null);
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGetQualifiedMethodName2() throws Exception {
        String result = ClassUtils.getQualifiedMethodName(null, null);
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testGetDescriptiveType() throws Exception {
        String result = ClassUtils.getDescriptiveType(null);
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testMatchesTypeName() throws Exception {
        boolean result = ClassUtils.matchesTypeName(null, "typeName");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testHasConstructor() throws Exception {
        boolean result = ClassUtils.hasConstructor(null, null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetConstructorIfAvailable() throws Exception {
//        Constructor<T> result = ClassUtils.getConstructorIfAvailable(null, null);
//        Assert.assertEquals(null, result);
    }

    @Test
    public void testHasMethod() throws Exception {
        boolean result = ClassUtils.hasMethod(null, "methodName", null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetMethod() throws Exception {
        Method result = ClassUtils.getMethod(null, "methodName", null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetMethodIfAvailable() throws Exception {
        Method result = ClassUtils.getMethodIfAvailable(null, "methodName", null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetMethodCountForName() throws Exception {
        int result = ClassUtils.getMethodCountForName(null, "methodName");
        Assert.assertEquals(0, result);
    }

    @Test
    public void testHasAtLeastOneMethodWithName() throws Exception {
        boolean result = ClassUtils.hasAtLeastOneMethodWithName(null, "methodName");
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetMostSpecificMethod() throws Exception {
        Method result = ClassUtils.getMostSpecificMethod(null, null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testIsUserLevelMethod() throws Exception {
        boolean result = ClassUtils.isUserLevelMethod(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testGetStaticMethod() throws Exception {
        Method result = ClassUtils.getStaticMethod(null, "methodName", null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testIsPrimitiveWrapper() throws Exception {
        boolean result = ClassUtils.isPrimitiveWrapper(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsPrimitiveOrWrapper() throws Exception {
        boolean result = ClassUtils.isPrimitiveOrWrapper(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsPrimitiveArray() throws Exception {
        boolean result = ClassUtils.isPrimitiveArray(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsPrimitiveWrapperArray() throws Exception {
        boolean result = ClassUtils.isPrimitiveWrapperArray(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testResolvePrimitiveIfNecessary() throws Exception {
        Class<?> result = ClassUtils.resolvePrimitiveIfNecessary(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testIsAssignable() throws Exception {
        boolean result = ClassUtils.isAssignable(null, null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsAssignableValue() throws Exception {
        boolean result = ClassUtils.isAssignableValue(null, null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testConvertResourcePathToClassName() throws Exception {
        String result = ClassUtils.convertResourcePathToClassName("resourcePath");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testConvertClassNameToResourcePath() throws Exception {
        String result = ClassUtils.convertClassNameToResourcePath("className");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testAddResourcePathToPackagePath() throws Exception {
        String result = ClassUtils.addResourcePathToPackagePath(null, "resourceName");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testClassPackageAsResourcePath() throws Exception {
        String result = ClassUtils.classPackageAsResourcePath(null);
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testClassNamesToString() throws Exception {
//        String result = ClassUtils.classNamesToString(null);
//        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testClassNamesToString2() throws Exception {
        String result = ClassUtils.classNamesToString(Arrays.<Class<?>>asList(null));
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }

    @Test
    public void testToClassArray() throws Exception {
        Class<?>[] result = ClassUtils.toClassArray(Arrays.<Class<?>>asList(null));
        Assert.assertArrayEquals(new Class<?>[]{null}, result);
    }

    @Test
    public void testGetAllInterfaces() throws Exception {
        Class<?>[] result = ClassUtils.getAllInterfaces(null);
        Assert.assertArrayEquals(new Class<?>[]{null}, result);
    }

    @Test
    public void testGetAllInterfacesForClass() throws Exception {
        Class<?>[] result = ClassUtils.getAllInterfacesForClass(null);
        Assert.assertArrayEquals(new Class<?>[]{null}, result);
    }

    @Test
    public void testGetAllInterfacesForClass2() throws Exception {
        Class<?>[] result = ClassUtils.getAllInterfacesForClass(null, null);
        Assert.assertArrayEquals(new Class<?>[]{null}, result);
    }

    @Test
    public void testGetAllInterfacesAsSet() throws Exception {
        Set<Class<?>> result = ClassUtils.getAllInterfacesAsSet(null);
        Assert.assertEquals(new HashSet<Class<?>>(Arrays.asList(null)), result);
    }

    @Test
    public void testGetAllInterfacesForClassAsSet() throws Exception {
        Set<Class<?>> result = ClassUtils.getAllInterfacesForClassAsSet(null);
        Assert.assertEquals(new HashSet<Class<?>>(Arrays.asList(null)), result);
    }

    @Test
    public void testGetAllInterfacesForClassAsSet2() throws Exception {
        Set<Class<?>> result = ClassUtils.getAllInterfacesForClassAsSet(null, null);
        Assert.assertEquals(new HashSet<Class<?>>(Arrays.asList(null)), result);
    }

    @Test
    public void testCreateCompositeInterface() throws Exception {
        Class<?> result = ClassUtils.createCompositeInterface(new Class<?>[]{null}, null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testDetermineCommonAncestor() throws Exception {
        Class<?> result = ClassUtils.determineCommonAncestor(null, null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testIsVisible() throws Exception {
        boolean result = ClassUtils.isVisible(null, null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsCglibProxy() throws Exception {
        boolean result = ClassUtils.isCglibProxy(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsCglibProxyClass() throws Exception {
        boolean result = ClassUtils.isCglibProxyClass(null);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsCglibProxyClassName() throws Exception {
        boolean result = ClassUtils.isCglibProxyClassName("className");
        Assert.assertEquals(true, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme