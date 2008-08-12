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
package com.google.gwt.visualization.client;

/**
 * Selectable supports selecting rows/columns.
 *
 */
public interface Selectable {
  
  /**
   * Callback for selecting a row/column. 
   */
  public interface SelectCallback {
    void onSelect(Visualization<? extends AbstractDrawOptions> visualization);
  }
 
  /**
   * Add a selection listener.
   * @param callback
   */
  void addListener(SelectCallback callback);
  
  /**
   * Get the selection.
   * @return the selection.
   */
  Selection getSelection();
  
  /**
   * Set the selection.
   * @param sel the new selection.
   */
  void setSelection(Selection sel);
}
