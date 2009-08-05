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

import com.google.gwt.ajaxloader.client.ArrayHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;
import com.google.gwt.visualization.client.AbstractDataTable;
import com.google.gwt.visualization.client.AbstractDrawOptions;
import com.google.gwt.visualization.client.DateRange;
import com.google.gwt.visualization.client.Selection;
import com.google.gwt.visualization.client.events.Handler;
import com.google.gwt.visualization.client.events.ReadyHandler;
import com.google.gwt.visualization.client.events.SelectHandler;
import com.google.gwt.visualization.client.events.RangeChangeHandler;

import java.util.Date;
import java.util.Map;

/**
 * Annotated timeline visualization. May be loaded by calling: <code>
 * google.load("visualization", "1", {packages:["annotatedtimeline"]});
 * </code>
 * 
 * 
 * @see <a
 *      href="http://code.google.com/apis/visualization/documentation/gallery/annotatedtimeline.html" >
 *      Annotated Timeline Visualization Reference. </a>
 */
public class AnnotatedTimeLine extends Visualization<AnnotatedTimeLine.Options> {
  /**
   * Where to put the colored legend with respect to the date.
   */
  public static enum AnnotatedLegendPosition {
    /**
     * Put the colored legend on a new row.
     */
    NEW_ROW,

    /**
     * Put the colored legend on the same row as the date.
     */
    SAME_ROW;

    @Override
    public String toString() {
      switch (this) {
        case SAME_ROW:
          return "sameRow";
        case NEW_ROW:
          return "newRow";
        default:
          // unreachable
          assert false;
      }
      // unreachable
      return null;
    }
  }

  /**
   * Options for drawing the chart.
   * 
   */
  public static class Options extends AbstractDrawOptions {
    public static Options create() {
      return JavaScriptObject.createObject().cast();
    }

    protected Options() {
    }

    public final native void setAllowHtml(boolean allowHtml) /*-{
      this.allowHtml = allowHtml;
    }-*/;

    public final native void setAllValuesSuffix(String suffix) /*-{
      this.allValuesSuffix = suffix;
    }-*/;

    public final native void setAnnotationsWidth(int width) /*-{
      this.annotationsWidth = width;
    }-*/;

    public final native void setColors(JsArrayString colors) /*-{
      this.colors = colors;
    }-*/;

    public final void setColors(String... colors) {
      setColors(ArrayHelper.createJsArray(colors));
    }

    public final native void setDateFormat(String dateFormat) /*-{
      this.dateFormat = dateFormat;
    }-*/;

    public final native void setDisplayAnnotations(boolean display) /*-{
      this.displayAnnotations = display;
    }-*/;

    public final native void setDisplayAnnotationsFilter(boolean display) /*-{
      this.displayAnnotationsFilter = display;
    }-*/;

    public final native void setDisplayDateBarSeparator(boolean display) /*-{
      this.displayDateBarSeparator = display;
    }-*/;

    public final native void setDisplayExactValues(boolean display) /*-{
      this.displayExactValues = display;
    }-*/;

    public final native void setDisplayLegendDots(boolean display) /*-{
      this.displayLegendDots = display;
    }-*/;

    public final native void setDisplayLegendValues(boolean display) /*-{
      this.displayLegendValues = display;
    }-*/;

    public final native void setDisplayRangeSelector(boolean display) /*-{
      this.displayRangeSelector = display;
    }-*/;

    public final native void setDisplayZoomButtons(boolean display) /*-{
      this.displayZoomButtons = display;
    }-*/;

    public final native void setFill(int fill) /*-{
      this.fill = fill;
    }-*/;

    public final void setHighlightDotMode(HighlightDotMode highlightDotMode) {
      setHighlightDotMode(highlightDotMode.name().toString().toLowerCase());
    }

    public final void setLegendPosition(AnnotatedLegendPosition position) {
      setLegendPosition(position.toString());
    }

    public final native void setMax(int max) /*-{
      this.max = max;
    }-*/;

    public final native void setMin(int min) /*-{
      this.min = min;
    }-*/;

    public final native void setNumberFormat(String numberFormat) /*-{
      this.numberFormats = numberFormat;
    }-*/;

    public final void setNumberFormats(Map<Integer, String> numberFormats) {
      resetNumberFormats();
      for (Integer key : numberFormats.keySet()) {
      String numberFormat = numberFormats.get(key);
        setNumberFormats(key, numberFormat);
      }
    }

    public final void setScaleColumns(int... scaleColumns) {
      setScaleColumns(ArrayHelper.createJsArray(scaleColumns));
    }

    public final native void setScaleColumns(JsArrayInteger scaleColumns) /*-{
      this.scaleColumns = scaleColumns;
    }-*/;

    public final native void setScaleFormat(String scaleFormat) /*-{
      this.scaleFormat = scaleFormat;
    }-*/;

    public final void setScaleType(ScaleType type) {
      setScaleType(type.name().toLowerCase());
    }

    public final native void setThickness(int thickness) /*-{
      this.thickness = thickness;
    }-*/;

    public final void setWindowMode(WindowMode wmode) {
      setWindowMode(wmode.name().toLowerCase());
    }

    public final void setZoomEndTime(Date endTime) {
      setZoomEndTime(endTime.getTime());
    }

    public final void setZoomStartTime(Date startTime) {
      setZoomStartTime(startTime.getTime());
    }

    private native void setHighlightDotMode(String highlightDotMode) /*-{
      this.highlightDot = highlightDotMode;
    }-*/;

    private native void setLegendPosition(String position) /*-{
      this.legendPosition = position;
    }-*/;

    private native void resetNumberFormats() /*-{
      this.numberFormats = {};
    }-*/;
  
    private native void setNumberFormats(int key, String numberFormat) /*-{
      this.numberFormats[key] = numberFormat;
    }-*/;

    private native void setScaleType(String type) /*-{
      this.scaleType = type;
    }-*/;

    private native void setWindowMode(String wmode) /*-{
      this.wmode = wmode;
    }-*/;

    private native void setZoomEndTime(double endTime) /*-{
      this.zoomEndTime = new $wnd.Date(endTime);
    }-*/;

    private native void setZoomStartTime(double startTime) /*-{
      this.zoomStartTime = new $wnd.Date(startTime);
    }-*/;
  }

  /**
   * The highlighting mode: The nearest dot to the mouse (default), or the last one 
   * before the mouse (to the left of it).
   */
  public static enum HighlightDotMode {
    /**
     * Highlight the dot nearest to the mouse.
     */
    NEAREST,

    /**
     * Highlight the last dot before the mouse.
     */
    LAST
  }

  /**
   * Scale type for the timeline.
   * 
   * When ALLFIXED or ALLMAXIMIZE are used, it makes sense to set the
   * scaleColumns option as well, otherwise some of the series will be displayed
   * in a scale that is not the displayed one.
   */
  public static enum ScaleType {
    /**
     * Set the range of the values axis to be from 0 to the maximal value in
     * each series.
     */
    ALLFIXED,

    /**
     * Set the range of the values axis to be from the minimal value of each
     * series to the maximal value of each series.
     */
    ALLMAXIMIZE,

    /**
     * Set the range of the values axis to be from 0 to the maximal value in the
     * input DataTable.
     */
    FIXED,

    /**
     * Set the range of the values axis to be from the minimal value in the
     * input DataTable to the maximal value in the input DataTable.
     */
    MAXIMIZE
  }

  /**
   * Flash/IE "wmode" parameter. The transparent Flash content, absolute
   * positioning, and layering capabilities available in Internet Explorer 4.0.
   */
  public static enum WindowMode {
    /**
     * Makes the application hide everything behind it on the page.
     */
    OPAQUE,

    /**
     * Makes the background of the HTML page show through all the transparent
     * portions of the application and can slow animation performance.
     */
    TRANSPARENT,

    /**
     * Plays the application in its own rectangular window on a web page. WINDOW
     * indicates that the Flash application has no interaction with HTML layers
     * and is always the topmost item.
     */
    WINDOW
  }

  public static final String PACKAGE = "annotatedtimeline";

  /**
   * 
   * @param data data to visualize
   * @param options Optional parameters for the visualization
   * @param width the CSS specifier for the width of the visualization
   * @param height the CSS specifier for the height of the visualization
   */
  public AnnotatedTimeLine(AbstractDataTable data, Options options,
      String width, String height) {
    super(data, options);
    setSize(width, height);
  }

  /**
   * 
   * @param width the CSS specifier for the width of the visualization
   * @param height the CSS specifier for the height of the visualization
   */
  public AnnotatedTimeLine(String width, String height) {
    super();
    setSize(width, height);
  }

  public final void addRangeChangeHandler(RangeChangeHandler handler) {
    Handler.addHandler(this, "rangechange", handler);
  }

  public final void addReadyHandler(ReadyHandler handler) {
  Handler.addHandler(this, "ready", handler);
  }
    
  public final void addSelectHandler(SelectHandler handler) {
  Selection.addSelectHandler(this, handler);
  }

  public final JsArray<Selection> getSelections() {
    return Selection.getSelections(this);
  }

  public final DateRange getVisibleChartRange() {
    Date start = new Date((long)getVisibleChartRangeStartTime());
    Date end = new Date((long)getVisibleChartRangeEndTime());
    return new DateRange(start, end);
  }
  
  public final void hideDataColumns(int... columnIndexes) {
    hideDataColumns(ArrayHelper.createJsArray(columnIndexes));
  }

  public final native void hideDataColumns(JsArrayInteger columnIndexes) /*-{
    this.hideDataColumns(columnIndexes);
  }-*/;

  public final void setVisibleChartRange(Date startTime, Date endTime) {
    setVisibleChartRange(startTime.getTime(), endTime.getTime());
  }

  public final void showDataColumns(int... columnIndexes) {
    showDataColumns(ArrayHelper.createJsArray(columnIndexes));
  }

  public final native void showDataColumns(JsArrayInteger columnIndexes) /*-{
    this.showDataColumns(columnIndexes);
  }-*/;

 
  private native double getVisibleChartRangeEndTime() /*-{
    return this.getVisibleChartRange()['end'].getTime();
  }-*/;

  private native double getVisibleChartRangeStartTime() /*-{
    return this.getVisibleChartRange()['start'].getTime();
  }-*/;

  private native void setVisibleChartRange(double startTime, double endTime) /*-{
    this.setVisibleChartRange(new $wnd.Date(startTime), new $wnd.Date(endTime));
  }-*/;
  
  @Override
  protected native JavaScriptObject createJso(Element parent) /*-{
    return new $wnd.google.visualization.AnnotatedTimeLine(parent);
  }-*/;
}