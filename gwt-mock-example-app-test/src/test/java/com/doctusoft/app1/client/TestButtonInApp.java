/*
 * Pyx4j framework
 * Copyright (C) 2008-2015 pyx4j.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Created on Jun 6, 2016
 * @author vlads
 */
package com.doctusoft.app1.client;

import org.junit.Assert;
import org.junit.Test;

import com.google.gwt.dom.client.ButtonElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;

public class TestButtonInApp {

    @Test
    public void testButtonClick() {
        MockSample app = new MockSample();
        app.onModuleLoad();
        
        ButtonElement button1 = (ButtonElement) Document.get().getElementById("gwt-debug-button1");
        button1.click();
        
        InputElement field1 = (InputElement) Document.get().getElementById("gwt-debug-field1");
        
        Assert.assertEquals("Button1 Clicked", field1.getValue());
    }
}
