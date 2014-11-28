/*
 * Copyright 2010-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.descriptors.serialization.descriptors;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jet.descriptors.serialization.NameResolver;
import org.jetbrains.jet.descriptors.serialization.ProtoBuf;

import java.util.List;

public interface AnnotationAndConstantLoader<A, C> {
    @NotNull
    List<A> loadClassAnnotations(
            @NotNull ProtoBuf.Class classProto,
            @NotNull NameResolver nameResolver
    );

    @NotNull
    List<A> loadCallableAnnotations(
            @NotNull ProtoContainer container,
            @NotNull ProtoBuf.Callable proto,
            @NotNull NameResolver nameResolver,
            @NotNull AnnotatedCallableKind kind
    );

    @NotNull
    List<A> loadValueParameterAnnotations(
            @NotNull ProtoContainer container,
            @NotNull ProtoBuf.Callable callable,
            @NotNull NameResolver nameResolver,
            @NotNull AnnotatedCallableKind kind,
            @NotNull ProtoBuf.Callable.ValueParameter proto
    );

    @Nullable
    C loadPropertyConstant(
            @NotNull ProtoContainer container,
            @NotNull ProtoBuf.Callable proto,
            @NotNull NameResolver nameResolver,
            @NotNull AnnotatedCallableKind kind
    );
}
