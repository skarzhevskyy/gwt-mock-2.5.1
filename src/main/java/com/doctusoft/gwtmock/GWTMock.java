package com.doctusoft.gwtmock;

import java.util.NoSuchElementException;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.core.shared.GWT.CustomGWTCreateSupplier;
import com.google.gwt.dom.client.DOMImpl;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Main API entry point for unit tests to configure and control the Mock library.
 */
public class GWTMock {

    /**
     * Resister custom factory for mock objects created by GWT.create();
     * Will take priority over predefined factory in Mock library.
     *  
     * @param customSupplier
     */
    public static void addCustomGWTCreateSupplier(CustomGWTCreateSupplier customSupplier) {
        GWT.addCustomSupplier(customSupplier);
    }
    
    /**
     * Resister implementation of object created with GWT.create();
     * 
     * @param classLiteral
     * @param classLiteralImplementation
     */
    public static void registerGWTCreateImplementation(Class<?> classLiteral, Class<?> classLiteralImplementation) {
        GWT.registerGWTCreateImplementation(classLiteral, classLiteralImplementation);
    }
    
    /**
     * Remove all elements created in DOM and initialization done in Mock.
     * Called to be able to start new test.
     * Usually called in your tests setUp() or tearDown() ;
     */
    public static void reset() {
        // Implementation notes: There are no internal Mock events fired. All calls are made explicitly from this function.
        RootPanel.get().clear();
        com.doctusoft.gwtmock.Document.reset();
        DOMImpl.mockReset();
        GWT.cleanCustomSuppliers();
    }
    
    /**
     * Use this method to simulate typing into an element, which will set its value.
     * Simulates browser behavior as in Selenium's sendKeys().
     * The new value will be available in calls to element.getValue(). But it will not trigger ValueChange events until focus lost.
     *
     * @param value characters to send to the element
     */
    public static void type(InputElement element, String value) {
        element.focus();
        element.setAttribute(InputElement.MOCK_TYPED_VALUE, value);
        element.setValue(value);
    }
    
    /**
     * Select all options that display text matching the argument.
     * Simulates browser user input behavior on ListBox element.
     * 
     * Will trigger ChangeEvent event. 
     *
     * @param text The visible text to match against
     * @throws NoSuchElementException If no matching option elements are found
     */
    public static void selectByVisibleText(Element element, String text) {
        SelectElement selectElement = (SelectElement)element;
        selectElement.focus();
        for (int i = 0; i < selectElement.getOptions().getLength(); i++) {
          if (text.equals(selectElement.getOptions().getItem(i).getText()))  {
              selectElement.setSelectedIndex(i);
              selectElement.fireEvent(ChangeEvent.getType());
              return;
          }
        }
        throw new NoSuchElementException("Cannot locate option with text: " + text);
    }
}
