/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package zero.org.springframework.beans.factory.xml;

import zero.org.springframework.beans.factory.BeanDefinitionStoreException;
import zero.org.springframework.beans.factory.config.BeanDefinition;
import zero.org.springframework.beans.factory.parsing.ProblemReporter;
import zero.org.springframework.beans.factory.parsing.ReaderContext;
import zero.org.springframework.beans.factory.parsing.ReaderEventListener;
import zero.org.springframework.beans.factory.parsing.SourceExtractor;
import zero.org.springframework.beans.factory.support.BeanDefinitionRegistry;
import zero.org.springframework.beans.factory.xml.*;
import zero.org.springframework.core.env.Environment;
import zero.org.springframework.core.io.Resource;
import zero.org.springframework.core.io.ResourceLoader;
import zero.org.springframework.lang.Nullable;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.io.StringReader;

/**
 * Extension of {@link ReaderContext},
 * specific to use with an {@link org.springframework.beans.factory.xml.XmlBeanDefinitionReader}. Provides access to the
 * {@link NamespaceHandlerResolver} configured in the {@link org.springframework.beans.factory.xml.XmlBeanDefinitionReader}.
 *
 * @author Rob Harrop
 * @author Juergen Hoeller
 * @since 2.0
 */
public class XmlReaderContext extends ReaderContext {

	private final XmlBeanDefinitionReader reader;

	private final NamespaceHandlerResolver namespaceHandlerResolver;


	/**
	 * Construct a new {@code XmlReaderContext}.
	 * @param resource the XML bean definition resource
	 * @param problemReporter the problem reporter in use
	 * @param eventListener the event listener in use
	 * @param sourceExtractor the source extractor in use
	 * @param reader the XML bean definition reader in use
	 * @param namespaceHandlerResolver the XML namespace resolver
	 */
	public XmlReaderContext(
            Resource resource, ProblemReporter problemReporter,
            ReaderEventListener eventListener, SourceExtractor sourceExtractor,
            XmlBeanDefinitionReader reader, NamespaceHandlerResolver namespaceHandlerResolver) {

		super(resource, problemReporter, eventListener, sourceExtractor);
		this.reader = reader;
		this.namespaceHandlerResolver = namespaceHandlerResolver;
	}


	/**
	 * Return the XML bean definition reader in use.
	 */
	public final XmlBeanDefinitionReader getReader() {
		return this.reader;
	}

	/**
	 * Return the bean definition registry to use.
	 * @see org.springframework.beans.factory.xml.XmlBeanDefinitionReader#XmlBeanDefinitionReader(BeanDefinitionRegistry)
	 */
	public final BeanDefinitionRegistry getRegistry() {
		return this.reader.getRegistry();
	}

	/**
	 * Return the resource loader to use, if any.
	 * <p>This will be non-null in regular scenarios,
	 * also allowing access to the resource class loader.
	 * @see org.springframework.beans.factory.xml.XmlBeanDefinitionReader#setResourceLoader
	 * @see ResourceLoader#getClassLoader()
	 */
	@Nullable
	public final ResourceLoader getResourceLoader() {
		return this.reader.getResourceLoader();
	}

	/**
	 * Return the bean class loader to use, if any.
	 * <p>Note that this will be null in regular scenarios,
	 * as an indication to lazily resolve bean classes.
	 * @see org.springframework.beans.factory.xml.XmlBeanDefinitionReader#setBeanClassLoader
	 */
	@Nullable
	public final ClassLoader getBeanClassLoader() {
		return this.reader.getBeanClassLoader();
	}

	/**
	 * Return the environment to use.
	 * @see org.springframework.beans.factory.xml.XmlBeanDefinitionReader#setEnvironment
	 */
	public final Environment getEnvironment() {
		return this.reader.getEnvironment();
	}

	/**
	 * Return the namespace resolver.
	 * @see org.springframework.beans.factory.xml.XmlBeanDefinitionReader#setNamespaceHandlerResolver
	 */
	public final NamespaceHandlerResolver getNamespaceHandlerResolver() {
		return this.namespaceHandlerResolver;
	}


	// Convenience methods to delegate to

	/**
	 * Call the bean name generator for the given bean definition.
	 * @see org.springframework.beans.factory.xml.XmlBeanDefinitionReader#getBeanNameGenerator()
	 * @see org.springframework.beans.factory.support.BeanNameGenerator#generateBeanName
	 */
	public String generateBeanName(BeanDefinition beanDefinition) {
		return this.reader.getBeanNameGenerator().generateBeanName(beanDefinition, getRegistry());
	}

	/**
	 * Call the bean name generator for the given bean definition
	 * and register the bean definition under the generated name.
	 * @see org.springframework.beans.factory.xml.XmlBeanDefinitionReader#getBeanNameGenerator()
	 * @see org.springframework.beans.factory.support.BeanNameGenerator#generateBeanName
	 * @see BeanDefinitionRegistry#registerBeanDefinition
	 */
	public String registerWithGeneratedName(BeanDefinition beanDefinition) {
		String generatedName = generateBeanName(beanDefinition);
		getRegistry().registerBeanDefinition(generatedName, beanDefinition);
		return generatedName;
	}

	/**
	 * Read an XML document from the given String.
	 * @see #getReader()
	 */
	public Document readDocumentFromString(String documentContent) {
		InputSource is = new InputSource(new StringReader(documentContent));
		try {
			return this.reader.doLoadDocument(is, getResource());
		}
		catch (Exception ex) {
			throw new BeanDefinitionStoreException("Failed to read XML document", ex);
		}
	}

}
