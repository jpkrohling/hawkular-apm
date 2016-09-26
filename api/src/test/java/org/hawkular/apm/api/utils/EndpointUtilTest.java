/*
 * Copyright 2015-2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.apm.api.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.hawkular.apm.api.model.Constants;
import org.junit.Test;

/**
 * @author gbrown
 */
public class EndpointUtilTest {

    /**  */
    private static final String OPERATION = "Op";
    /**  */
    private static final String URI = "/uri";

    @Test
    public void testEndpointUri() {
        assertEquals(URI, EndpointUtil.encodeEndpoint(URI, null));
    }

    @Test
    public void testEndpointUriAndOperation() {
        String result = EndpointUtil.encodeEndpoint(URI, OPERATION);
        String expected = URI + "[" + OPERATION + "]";
        assertEquals(expected, result);
    }

    @Test
    public void testDecodeEndpointURIWithOp() {
        String result = EndpointUtil.encodeEndpoint(URI, OPERATION);
        assertEquals(URI, EndpointUtil.decodeEndpointURI(result));
    }

    @Test
    public void testDecodeEndpointURIWithoutOp() {
        String result = EndpointUtil.encodeEndpoint(URI, null);
        assertEquals(URI, EndpointUtil.decodeEndpointURI(result));
    }

    @Test
    public void testDecodeEndpointOpStripped() {
        String result = EndpointUtil.encodeEndpoint(URI, OPERATION);
        assertEquals(OPERATION, EndpointUtil.decodeEndpointOperation(result,true));
    }

    @Test
    public void testDecodeEndpointOpNotStripped() {
        String result = EndpointUtil.encodeEndpoint(URI, OPERATION);
        assertEquals("["+OPERATION+"]", EndpointUtil.decodeEndpointOperation(result,false));
    }

    @Test
    public void testDecodeEndpointOpNull() {
        String result = EndpointUtil.encodeEndpoint(URI, null);
        assertNull(EndpointUtil.decodeEndpointOperation(result,false));
    }

    @Test
    public void testEncodeClientURI() {
        assertEquals(Constants.URI_CLIENT_PREFIX + URI, EndpointUtil.encodeClientURI(URI));
    }

    @Test
    public void testDecodeClientURI() {
        assertEquals(URI, EndpointUtil.decodeClientURI(Constants.URI_CLIENT_PREFIX + URI));
    }

    @Test
    public void testDecodeNonClientURI() {
        assertEquals(URI, EndpointUtil.decodeClientURI(URI));
    }

}
