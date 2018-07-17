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

package org.springframework.beans.factory.parsing;

import org.springframework.lang.Nullable;

import java.util.Stack;

/**
 * 分析过程
 * Simple {@link Stack}-based structure for tracking the logical position during
 * a parsing process. {@link Entry entries} are added to the stack at
 * each point during the parse phase in a reader-specific manner.
 * 简单的基于堆栈的结构，用于在解析过程中跟踪逻辑位置。
 * 在解析阶段，条目以特定于读取器的方式添加到堆栈的每个点。
 *
 * <p>Calling {@link #toString()} will render a tree-style view of the current logical
 * position in the parse phase. This representation is intended for use in
 * error messages.
 *
 *
 * 调用toString()将呈现解析阶段当前逻辑位置的树式视图。此表示形式用于错误消息中。
 *
 * @author Rob Harrop
 * @since 2.0
 */
public final class ParseState {

	/**
	 * Tab character used when rendering the tree-style representation.
	 */
	private static final char TAB = '\t';

	/**
	 * Internal {@link Stack} storage.
	 */
	private final Stack<Entry> state;


	/**
	 * Create a new {@code ParseState} with an empty {@link Stack}.
	 */
	public ParseState() {
		this.state = new Stack<>();
	}

	/**
	 * Create a new {@code ParseState} whose {@link Stack} is a {@link Object#clone clone}
	 * of that of the passed in {@code ParseState}.
	 */
	@SuppressWarnings("unchecked")
	private ParseState(ParseState other) {
		this.state = (Stack<Entry>) other.state.clone();
	}


	/**
	 * Add a new {@link Entry} to the {@link Stack}.
	 */
	public void push(Entry entry) {
		this.state.push(entry);
	}

	/**
	 * Remove an {@link Entry} from the {@link Stack}.
	 */
	public void pop() {
		this.state.pop();
	}

	/**
	 * Return the {@link Entry} currently at the top of the {@link Stack} or
	 * {@code null} if the {@link Stack} is empty.
	 */
	@Nullable
	public Entry peek() {
		return this.state.empty() ? null : this.state.peek();
	}

	/**
	 * Create a new instance of {@link ParseState} which is an independent snapshot
	 * of this instance.
	 */
	public ParseState snapshot() {
		return new ParseState(this);
	}


	/**
	 * Returns a tree-style representation of the current {@code ParseState}.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < this.state.size(); x++) {
			if (x > 0) {
				sb.append('\n');
				for (int y = 0; y < x; y++) {
					sb.append(TAB);
				}
				sb.append("-> ");
			}
			sb.append(this.state.get(x));
		}
		return sb.toString();
	}


	/**
	 * Marker interface for entries into the {@link ParseState}.
	 */
	public interface Entry {

	}

}
