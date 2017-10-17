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

package zero.org.springframework.lang;

import java.lang.annotation.*;

/**
 * A common Spring annotation to declare that parameters and return values
 * are to be considered as non-nullable by default for a given package,
 * along with their underlying fields.
 *
 * <p>Should be used at package level in association with {@link org.springframework.lang.Nullable}
 * annotations at parameter and return value level.
 *
 * <p>Leverages JSR-305 meta-annotations to indicate its semantics to
 * common tools with JSR-305 support.
 *
 * @author Sebastien Deleuze
 * @author Juergen Hoeller
 * @since 5.0
 * @see org.springframework.lang.Nullable
// * @see javax.annotation.Nonnull
 */
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Nonnull
//@TypeQualifierDefault({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER, ElementType.FIELD})
public @interface NonNullApi {
}
