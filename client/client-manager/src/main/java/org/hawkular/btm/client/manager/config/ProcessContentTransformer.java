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
package org.hawkular.btm.client.manager.config;

import org.hawkular.btm.api.model.admin.Direction;
import org.hawkular.btm.api.model.admin.InstrumentAction;
import org.hawkular.btm.api.model.admin.ProcessContent;

/**
 * This class transforms the ProcessContent action type.
 *
 * @author gbrown
 */
public class ProcessContentTransformer implements InstrumentActionTransformer {

    /* (non-Javadoc)
     * @see org.hawkular.btm.client.manager.config.InstrumentActionTransformer#getActionType()
     */
    @Override
    public Class<? extends InstrumentAction> getActionType() {
        return ProcessContent.class;
    }

    /* (non-Javadoc)
     * @see org.hawkular.btm.client.manager.config.InstrumentActionTransformer#convertToRuleAction(
     *                      org.hawkular.btm.api.model.admin.InstrumentAction)
     */
    @Override
    public String convertToRuleAction(InstrumentAction action) {
        ProcessContent pcAction = (ProcessContent) action;
        StringBuilder builder = new StringBuilder();

        builder.append("collector().");

        if (pcAction.getDirection() == Direction.Request) {
            builder.append("processRequest(");
        } else {
            builder.append("processResponse(");
        }

        if (pcAction.getHeadersExpression() == null) {
            builder.append("null");
        } else {
            builder.append(pcAction.getHeadersExpression());
        }

        builder.append(',');

        if (pcAction.getValueExpressions().isEmpty()) {
            builder.append("null");
        } else {
            builder.append("createArrayBuilder()");

            for (String expr : pcAction.getValueExpressions()) {
                builder.append(".add(");
                builder.append(expr);
                builder.append(')');
            }

            builder.append(".get()");
        }

        builder.append(")");

        return builder.toString();
    }

}