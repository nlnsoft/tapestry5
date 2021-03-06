// Copyright 2011 The Apache Software Foundation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.apache.tapestry5.annotations;

import org.apache.tapestry5.ioc.annotations.AnnotationUseContext;
import org.apache.tapestry5.ioc.annotations.UseWith;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Identifies a page that should only be accessed from clients on the whitelist. This is used for
 * some built-in pages ({@link org.apache.tapestry5.corelib.pages.PageCatalog} and {@link org.apache.tapestry5.corelib.pages.ServiceStatus}),
 * but can also be used in application pages.
 * <p/>
 * Tapestry does its best to make a request to a whitelist-only page that is accessed from a client not on the whitelist
 * appear to behave as if the page does not exist at all.
 *
 * @see org.apache.tapestry5.MetaDataConstants#WHITELIST_ONLY_PAGE
 * @see org.apache.tapestry5.services.security.ClientWhitelist
 * @since 5.3
 */
@Target(TYPE)
@Retention(RUNTIME)
@Documented
@UseWith(AnnotationUseContext.PAGE)
public @interface WhitelistAccessOnly
{
}
