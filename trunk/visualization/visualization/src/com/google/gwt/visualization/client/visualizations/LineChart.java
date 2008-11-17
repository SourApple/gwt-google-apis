/*
 * Copyright 2008 Google Inc.
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
 */
package com.google.gwt.visualization.client.visualizations;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.CommonChartOptions;
import com.google.gwt.visualization.client.Selectable;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.SelectionHelper;
import com.google.gwt.visualization.client.VisualizationWidget;
import com.google.gwt.visualization.client.events.SelectHandler;

/**
 * Visualization that plots the data points on a coordinate plane and 
 * draws a line between the points.  May be loaded by calling:
 * <code>
 * google.load("visualization", "1", {packages:["linechart"]});
 * </code>
 * 
 * 
 * @see <a
 *      href="http://code.google.com/apis/visualization/documentation/gallery/linechart.html">
 *      Line Chart Visualization Reference</a>
 */
public class LineChart extends Visualization<LineChart.Options> 
    implements Selectable {
  /**
   * Options for drawing the chart.
   * 
   */
  public static class Options extends CommonChartOptions {
    public static Options create() {
      return JavaScriptObject.createObject().cast();
    }

    protected Options() {
    }
    
    public final native void setLineSize(int size) /*-{
      this.lineSize = size;
    }-*/;
    
    public final native void setPointSize(int size) /*-{
      this.pointSize = size;
    }-*/;
    
    public final native void setSmoothLine(boolean smooth) /*-{
      this.smoothLine = smooth;
    }-*/;
  }

  public static native LineChart create(Element parent) /*-{
    return new $wnd.google.visualization.LineChart(parent);
  }-*/;
  
  public static VisualizationWidget<LineChart, Options> 
  createWidget(AbstractDataTable data, Options options) {
    Element div = DOM.createDiv();
    LineChart viz = create(div);
    return new VisualizationWidget<LineChart, Options>(div, viz, data, 
        options);
  }
  
  public static VisualizationWidget<LineChart, Options> createWidget() {
    Element div = DOM.createDiv();
    LineChart viz = create(div);
    return new VisualizationWidget<LineChart, Options>(div, viz);
  }
  
  protected LineChart() {
  }
  
  public final void addSelectHandler(SelectHandler handler) {
    SelectionHelper.addSelectHandler(this, handler);
  }

  public final Selection getSelection() {
    return SelectionHelper.getSelection(this);
  }

  public final void setSelection(Selection sel) {
    SelectionHelper.setSelection(this, sel);
  }
}
