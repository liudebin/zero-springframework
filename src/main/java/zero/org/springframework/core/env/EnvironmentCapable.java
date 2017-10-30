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

package zero.org.springframework.core.env;

import zero.org.springframework.core.env.ConfigurableEnvironment;
import zero.org.springframework.core.env.Environment;

/**
 * Interface indicating a component that contains and exposes an {@link Environment} reference.
 * 包含和对外暴露了 一个 Environment
 *
 * <p>All Spring application contexts are EnvironmentCapable, and the interface is used primarily
 * for performing {@code instanceof} checks in framework methods that accept BeanFactory
 * instances that may or may not actually be ApplicationContext instances in order to interact
 * with the environment if indeed it is available.
 * 所有的Spring application contexts 都是 EnvironmentCapable，而且该接口主要用于执行instanceof检查框架方法，接受BeanFactory 实例，
 * 的情况下，可能会或可能不会ApplicationContext实例为了与环境互动的如果它是可用的。
 * <p>As mentioned, {@link org.springframework.context.ApplicationContext ApplicationContext}
 * extends EnvironmentCapable, and thus exposes a {@link #getEnvironment()} method; however,
 * {@link org.springframework.context.ConfigurableApplicationContext ConfigurableApplicationContext}
 * redefines {@link org.springframework.context.ConfigurableApplicationContext#getEnvironment
 * getEnvironment()} and narrows the signature to return a {@link ConfigurableEnvironment}.
 * The effect is that an Environment object is 'read-only' until it is being accessed from
 * a ConfigurableApplicationContext, at which point it too may be configured.
 * 如前所述，environmentcapable ApplicationContext延伸，从而暴露出getenvironment()方法；然而，configurableapplicationcontext重新定义getenvironment()和签名返回configurableenvironment变窄。效果是一个环境的目标是“只读”直到它从configurableapplicationcontext访问，在这一点上，它也可以被配置。
 * 定义获取Environment的方法
 * @author Chris Beams
 * @since 3.1
 * @see Environment
 * @see ConfigurableEnvironment
 * @see org.springframework.context.ConfigurableApplicationContext#getEnvironment()
 */
public interface EnvironmentCapable { // capable =  ~ of sth 有什么什么的能力

	/**
	 * Return the {@link Environment} associated with this component.
	 */
	Environment getEnvironment();

}
