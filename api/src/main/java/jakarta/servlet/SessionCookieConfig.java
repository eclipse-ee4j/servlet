/*
 * Copyright (c) 2017, 2020 Oracle and/or its affiliates and others.
 * All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package jakarta.servlet;

import jakarta.servlet.http.Cookie.SameSite;

/**
 * Class that may be used to configure various properties of cookies used for session tracking purposes.
 *
 * <p>
 * An instance of this class is acquired by a call to {@link ServletContext#getSessionCookieConfig}.
 *
 * @since Servlet 3.0
 */
public interface SessionCookieConfig {

    /**
     * Sets the name that will be assigned to any session tracking cookies created on behalf of the application
     * represented by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired.
     *
     * <p>
     * NOTE: Changing the name of session tracking cookies may break other tiers (for example, a load balancing
     * frontend) that assume the cookie name to be equal to the default <tt>JSESSIONID</tt>, and therefore should only
     * be done cautiously.
     *
     * @param name the cookie name to use
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was
     *                               acquired has already been initialized
     */
    public void setName(String name);

    /**
     * Gets the name that will be assigned to any session tracking cookies created on behalf of the application
     * represented by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired.
     *
     * <p>
     * By default, <tt>JSESSIONID</tt> will be used as the cookie name.
     *
     * @return the cookie name set via {@link #setName}, or <tt>null</tt> if {@link #setName} was never called
     *
     * @see jakarta.servlet.http.Cookie#getName()
     */
    public String getName();

    /**
     * Sets the domain name that will be assigned to any session tracking cookies created on behalf of the application
     * represented by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired.
     *
     * @param domain the cookie domain to use
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was
     *                               acquired has already been initialized
     *
     * @see jakarta.servlet.http.Cookie#setDomain(String)
     */
    public void setDomain(String domain);

    /**
     * Gets the domain name that will be assigned to any session tracking cookies created on behalf of the application
     * represented by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired.
     *
     * @return the cookie domain set via {@link #setDomain}, or <tt>null</tt> if {@link #setDomain} was never called
     *
     * @see jakarta.servlet.http.Cookie#getDomain()
     */
    public String getDomain();

    /**
     * Sets the path that will be assigned to any session tracking cookies created on behalf of the application
     * represented by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired.
     *
     * @param path the cookie path to use
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was
     *                               acquired has already been initialized
     *
     * @see jakarta.servlet.http.Cookie#setPath(String)
     */
    public void setPath(String path);

    /**
     * Gets the path that will be assigned to any session tracking cookies created on behalf of the application
     * represented by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired.
     *
     * <p>
     * By default, the context path of the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was
     * acquired will be used.
     *
     * @return the cookie path set via {@link #setPath}, or <tt>null</tt> if {@link #setPath} was never called
     *
     * @see jakarta.servlet.http.Cookie#getPath()
     */
    public String getPath();

    /**
     * Sets the comment that will be assigned to any session tracking cookies created on behalf of the application
     * represented by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired.
     *
     * <p>
     * As a side effect of this call, the session tracking cookies will be marked with a <code>Version</code> attribute
     * equal to <code>1</code>.
     * 
     * @param comment the cookie comment to use
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was
     *                               acquired has already been initialized
     *
     * @see jakarta.servlet.http.Cookie#setComment(String)
     * @see jakarta.servlet.http.Cookie#getVersion
     */
    public void setComment(String comment);

    /**
     * Gets the comment that will be assigned to any session tracking cookies created on behalf of the application
     * represented by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired.
     *
     * @return the cookie comment set via {@link #setComment}, or <tt>null</tt> if {@link #setComment} was never called
     *
     * @see jakarta.servlet.http.Cookie#getComment()
     */
    public String getComment();

    /**
     * Marks or unmarks the session tracking cookies created on behalf of the application represented by the
     * <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired as <i>HttpOnly</i>.
     *
     * <p>
     * A cookie is marked as <tt>HttpOnly</tt> by adding the <tt>HttpOnly</tt> attribute to it. <i>HttpOnly</i> cookies
     * are not supposed to be exposed to client-side scripting code, and may therefore help mitigate certain kinds of
     * cross-site scripting attacks.
     *
     * @param httpOnly true if the session tracking cookies created on behalf of the application represented by the
     *                 <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired shall be marked
     *                 as <i>HttpOnly</i>, false otherwise
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was
     *                               acquired has already been initialized
     *
     * @see jakarta.servlet.http.Cookie#setHttpOnly(boolean)
     */
    public void setHttpOnly(boolean httpOnly);

    /**
     * Checks if the session tracking cookies created on behalf of the application represented by the
     * <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired will be marked as
     * <i>HttpOnly</i>.
     *
     * @return true if the session tracking cookies created on behalf of the application represented by the
     *         <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired will be marked as
     *         <i>HttpOnly</i>, false otherwise
     *
     * @see jakarta.servlet.http.Cookie#isHttpOnly()
     */
    public boolean isHttpOnly();

    /**
     * Marks or unmarks the session tracking cookies created on behalf of the application represented by the
     * <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired as <i>secure</i>.
     *
     * <p>
     * One use case for marking a session tracking cookie as <tt>secure</tt>, even though the request that initiated the
     * session came over HTTP, is to support a topology where the web container is front-ended by an SSL offloading load
     * balancer. In this case, the traffic between the client and the load balancer will be over HTTPS, whereas the
     * traffic between the load balancer and the web container will be over HTTP.
     *
     * @param secure true if the session tracking cookies created on behalf of the application represented by the
     *               <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired shall be marked
     *               as <i>secure</i> even if the request that initiated the corresponding session is using plain HTTP
     *               instead of HTTPS, and false if they shall be marked as <i>secure</i> only if the request that
     *               initiated the corresponding session was also secure
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was
     *                               acquired has already been initialized
     *
     * @see jakarta.servlet.http.Cookie#setSecure(boolean)
     * @see ServletRequest#isSecure()
     */
    public void setSecure(boolean secure);

    /**
     * Checks if the session tracking cookies created on behalf of the application represented by the
     * <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired will be marked as <i>secure</i>
     * even if the request that initiated the corresponding session is using plain HTTP instead of HTTPS.
     *
     * @return true if the session tracking cookies created on behalf of the application represented by the
     *         <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired will be marked as
     *         <i>secure</i> even if the request that initiated the corresponding session is using plain HTTP instead of
     *         HTTPS, and false if they will be marked as <i>secure</i> only if the request that initiated the
     *         corresponding session was also secure
     *
     * @see jakarta.servlet.http.Cookie#getSecure()
     * @see ServletRequest#isSecure()
     */
    public boolean isSecure();

    /**
     * Sets the lifetime (in seconds) for the session tracking cookies created on behalf of the application represented
     * by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired.
     *
     * @param maxAge the lifetime (in seconds) of the session tracking cookies created on behalf of the application
     *               represented by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was
     *               acquired.
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was
     *                               acquired has already been initialized
     *
     * @see jakarta.servlet.http.Cookie#setMaxAge
     */
    public void setMaxAge(int maxAge);

    /**
     * Gets the lifetime (in seconds) of the session tracking cookies created on behalf of the application represented
     * by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired.
     *
     * <p>
     * By default, <tt>-1</tt> is returned.
     *
     * @return the lifetime (in seconds) of the session tracking cookies created on behalf of the application
     *         represented by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired, or
     *         <tt>-1</tt> (the default)
     *
     * @see jakarta.servlet.http.Cookie#getMaxAge
     */
    public int getMaxAge();

    /**
     * Sets the SameSite attribute for the session tracking cookies created on behalf of the application represented
     * by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired.
     * When <code>sameSite</code> is not <code>null</code>, this cookie will have its <code>SameSite</code>
     * attribute set with the provided value. When <code>sameSite</code> is <code>null</code>, the container may
     * use a context specific default for the cookie's <code>SameSite</code> attribute or it may not be set.
     *
     * @param sameSite the <i>SameSite</i> attribute of the session tracking cookies created on behalf of the
     *                 application represented by the <tt>ServletContext</tt> from which this
     *                 <tt>SessionCookieConfig</tt> was acquired. May be null to imply that the SameSite attribute
     *                 should be set to a context specific default value, or should not be set if there is no context
     *                 default.
     *
     * @throws IllegalStateException if the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was
     *                               acquired has already been initialized
     *
     * @see jakarta.servlet.http.Cookie#setSameSite(SameSite)
     *
     * @since Servlet 5.0
     */
    void setSameSite(SameSite sameSite);

    /**
     * Gets the SameSite attribute of the session tracking cookies created on behalf of the application represented
     * by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired.
     *
     * <p>
     * By default, null is returned implying that the SameSite attribute should be set to a context specific default
     * value, or should not be set if there is no context default.
     *
     * @return the SameSite attribute of the session tracking cookies created on behalf of the application represented
     *         by the <tt>ServletContext</tt> from which this <tt>SessionCookieConfig</tt> was acquired. May be null if
     *         the attribute should be a container provided context default or not set if there is no context default.
     *
     * @see jakarta.servlet.http.Cookie#getSameSite
     *
     * @since Servlet 5.0
     */
    SameSite getSameSite();
}
