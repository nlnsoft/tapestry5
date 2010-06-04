// Copyright 2010 The Apache Software Foundation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.tapestry5.func;

class LazyMapper2<T, X, Y> implements LazyFunction<Y>
{
    private final Mapper2<T, X, Y> mapper;

    private final Flow<T> left;

    private final Flow<X> right;

    @SuppressWarnings("unchecked")
    public LazyMapper2(Mapper2<T, X, Y> mapper, Flow<T> left, Flow<? extends X> right)
    {
        this.mapper = mapper;
        this.left = left;
        this.right = (Flow<X>) right;
    }

    public LazyContinuation<Y> next()
    {
        if (left.isEmpty() || right.isEmpty())
            return null;

        LazyValue<Y> nextValue = new LazyMapped2Value<T, X, Y>(left, right, mapper);

        return new LazyContinuation<Y>(nextValue, new LazyMapper2<T, X, Y>(mapper, left.rest(), right.rest()));
    }
}
