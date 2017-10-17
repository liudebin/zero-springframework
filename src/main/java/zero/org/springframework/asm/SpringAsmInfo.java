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

package zero.org.springframework.asm;

/**
 * Utility class exposing constants related to Spring's internal repackaging
 * of the ASM bytecode manipulation library (currently based on version 5.0).
 *
 * <p>See <a href="package-summary.html">package-level javadocs</a> for more
 * information on {@code org.springframework.asm}.
 *
 * @author Chris Beams
 * @since 3.2
 */
public final class SpringAsmInfo {

	/**
	 * The ASM compatibility version for Spring's ASM visitor implementations:
	 * currently {@link org.springframework.asm.Opcodes#ASM5}.
	 */
	public static final int ASM_VERSION = Opcodes.ASM5;

}
