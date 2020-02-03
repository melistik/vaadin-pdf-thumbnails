package org.vaadin.pdf.client;

import com.vaadin.shared.ui.JavaScriptComponentState;

/**
 * Transfer states to JavaScript connector
 *
 * @author Marten Prieß (http://www.rocketbase.io)
 * @version 1.0
 */
public class PdfThumbnailState extends JavaScriptComponentState {

    public String url;

    public String triggerRepaint = "1";

    public int previewWidth = 0, previewHeight = 0;
}
