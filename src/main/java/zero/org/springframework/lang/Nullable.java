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

import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;
import java.lang.annotation.*;

/**
 * A common Spring annotation to declare that the annotated parameter,
 * return value or field could be {@code null} under some circumstances.
 *
 * <p>Should be used at parameters and return values level in association
 * with {@link NonNullApi} package-level annotations.
 *
 * <p>Leverages JSR-305 meta-annotations to indicate its semantics to
 * common tools with JSR-305 support.
 *
 * @author Sebastien Deleuze
 * @author Juergen Hoeller
 * @since 5.0
 * @see NonNullApi
// * @see javax.annotation.Nullable
 */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Nonnull(when = When.MAYBE)
@TypeQualifierNickname
public @interface Nullable {
}
