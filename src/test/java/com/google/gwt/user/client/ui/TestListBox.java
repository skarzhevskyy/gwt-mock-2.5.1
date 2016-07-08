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
 * Created on Jul 8, 2016
 * @author vlads
 */
package com.google.gwt.user.client.ui;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.doctusoft.gwtmock.GWTMock;

public class TestListBox {

    @Before
    public void setup() {
        GWTMock.reset();
    }
    
    @Test
    public void tesListBox() {
        ListBox lb = new ListBox();
        lb.ensureDebugId("listBox1");
        RootPanel.get().add(lb);

        lb.addItem("item0");
        lb.addItem("item1");
        lb.addItem("item2");
        lb.addItem("item3" , "3");

        Assert.assertEquals("getItemCount", 4, lb.getItemCount());
        
        Assert.assertEquals("getItemText", "item0", lb.getItemText(0));
        Assert.assertEquals("getValue", "item0", lb.getValue(0));
        
        Assert.assertEquals("getItemText", "item1", lb.getItemText(1));
        Assert.assertEquals("getValue", "item1", lb.getValue(1));
        
        Assert.assertEquals("getItemText", "item3", lb.getItemText(3));
        Assert.assertEquals("getValue", "3", lb.getValue(3));

        Assert.assertEquals("getSelectedIndex", 0, lb.getSelectedIndex());
        lb.setSelectedIndex(2);
        Assert.assertEquals("getSelectedIndex", 2, lb.getSelectedIndex());
        //Assert.assertTrue("isItemSelected", lb.isItemSelected(2));

    }
}
