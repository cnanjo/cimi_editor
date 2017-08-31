/*
 * #%L
 * carewebframework
 * %%
 * Copyright (C) 2008 - 2016 Regenstrief Institute, Inc.
 * %%
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
 *
 * This Source Code Form is also subject to the terms of the Health-Related
 * Additional Disclaimer of Warranty and Limitation of Liability available at
 *
 *      http://www.carewebframework.org/licensing/disclaimer.
 *
 * #L%
 */
package org.opencimi.cwf.editor;

import org.carewebframework.shell.plugins.PluginController;
import org.fujion.annotation.EventHandler;
import org.fujion.annotation.WiredComponent;
import org.fujion.component.BaseComponent;
import org.fujion.component.Button;

/**
 * Controller for user header plugin.
 */
public class MainController extends PluginController {

//    @WiredComponent
//    private Button btnTest;

    @Override
    public void afterInitialized(BaseComponent comp) {
        super.afterInitialized(comp);
    }

    /**
     * Event handler for logout link
     */
//    @EventHandler(value = "click", target = "btnTest")
//    private void handleClick() {
//        btnTest.addClass("flavor:btn-success");
//    }
    
}
