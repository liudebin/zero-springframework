/*
 * Copyright 2002-2016 the original author or authors.
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

package zero.org.springframework.beans;

import zero.org.springframework.beans.*;
import zero.org.springframework.beans.TypeConverter;
import zero.org.springframework.core.MethodParameter;
import zero.org.springframework.core.convert.ConversionException;
import zero.org.springframework.core.convert.ConverterNotFoundException;
import zero.org.springframework.lang.Nullable;

import java.lang.reflect.Field;

/**
 * Base implementation of the {@link org.springframework.beans.TypeConverter} interface, using a package-private delegate.
 * Mainly serves as base class for {@link org.springframework.beans.BeanWrapperImpl}.
 *
 * @author Juergen Hoeller
 * @since 3.2
 * @see SimpleTypeConverter
 */
public abstract class TypeConverterSupport extends PropertyEditorRegistrySupport implements TypeConverter {

	TypeConverterDelegate typeConverterDelegate;


	@Override
	public <T> T convertIfNecessary(@Nullable Object value, @Nullable Class<T> requiredType) throws TypeMismatchException {
		return doConvert(value, requiredType, null, null);
	}

	@Override
	public <T> T convertIfNecessary(@Nullable Object value, @Nullable Class<T> requiredType, @Nullable MethodParameter methodParam)
			throws TypeMismatchException {

		return doConvert(value, requiredType, methodParam, null);
	}

	@Override
	public <T> T convertIfNecessary(@Nullable Object value, @Nullable Class<T> requiredType, @Nullable Field field)
			throws TypeMismatchException {

		return doConvert(value, requiredType, null, field);
	}

	@Nullable
	private <T> T doConvert(@Nullable Object value,@Nullable Class<T> requiredType,
			@Nullable MethodParameter methodParam, @Nullable Field field) throws TypeMismatchException {

		try {
			if (field != null) {
				return this.typeConverterDelegate.convertIfNecessary(value, requiredType, field);
			}
			else {
				return this.typeConverterDelegate.convertIfNecessary(value, requiredType, methodParam);
			}
		}
		catch (ConverterNotFoundException | IllegalStateException ex) {
			throw new ConversionNotSupportedException(value, requiredType, ex);
		}
		catch (ConversionException | IllegalArgumentException ex) {
			throw new TypeMismatchException(value, requiredType, ex);
		}
	}

}
