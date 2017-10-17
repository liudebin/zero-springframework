/*
 * Copyright 2002-2014 the original author or authors.
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

package zero.org.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * Container annotation that aggregates several {@link org.springframework.context.annotation.PropertySource} annotations.
 *
 * <p>Can be used natively, declaring several nested {@link org.springframework.context.annotation.PropertySource} annotations.
 * Can also be used in conjunction with Java 8's support for <em>repeatable annotations</em>,
 * where {@link org.springframework.context.annotation.PropertySource} can simply be declared several times on the same
 * {@linkplain ElementType#TYPE type}, implicitly generating this container annotation.
 *
 * @author Phillip Webb
 * @since 4.0
 * @see org.springframework.context.annotation.PropertySource
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PropertySources {

	PropertySource[] value();

}
