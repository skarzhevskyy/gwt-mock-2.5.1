package com.doctusoft.app1.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;

public class MockSampleView extends Composite {

    final Button button1;
    
    final TextBox field1;
    
    final Label errorLabel;
    
    MockSampleView() {
        FlowPanel content = new FlowPanel() {};
        
        content.add(button1 = new Button("Click Test"));
        content.add(field1 = new TextBox());
        content.add(errorLabel = new Label());
        
        button1.ensureDebugId("button1");
        field1.ensureDebugId("field1");
        
        field1.setText("Not Clicked");

        button1.addClickHandler(new ClickHandler() {
            
            public void onClick(ClickEvent event) {
                field1.setText("Button1 Clicked");        
            }
        });
        
        this.initWidget(content);

    }

    
}