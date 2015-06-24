/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates
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
package org.hawkular.btm.client.config.rest.client;

import org.hawkular.btm.api.client.AbstractConfigurationManager;
import org.hawkular.btm.api.model.admin.CollectorConfiguration;

/**
 * This class provides the REST client implementation of the ConfigurationManager
 * API.
 *
 * @author gbrown
 */
public class ConfigurationManagerRESTClient extends AbstractConfigurationManager {

    /* (non-Javadoc)
     * @see org.hawkular.btm.api.client.AbstractConfigurationManager#doGetConfiguration()
     */
    @Override
    protected CollectorConfiguration doGetConfiguration() {
        return null;
    }

}