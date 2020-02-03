package org.vaadin.pdf.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.StreamResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.vaadin.pdf.PdfThumbnail;

import java.io.IOException;
import java.net.URL;


@SpringUI()
@Theme("valo")
public class DemoUI extends UI {

    private final PdfThumbnail pdfThumbnail = new PdfThumbnail();

    private final String exampleUrl = "./VAADIN/pdf/example.pdf";

    @Override
    protected void init(final VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);

        setContent(layout);

        pdfThumbnail.setUrl(exampleUrl);
        pdfThumbnail.setPreviewWidth(400);
        pdfThumbnail.setWidth("300px");
        pdfThumbnail.setHeight("300px");
        layout.addComponent(pdfThumbnail);

        layout.addComponent(new Button("DownloadResource", e -> {
            pdfThumbnail.setPreviewWidth(0);
            pdfThumbnail.setPreviewHeight(500);

            pdfThumbnail.setResource(new DownloadStreamResource("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        }));

        layout.addComponent(new Button("Example embedded", e -> {
            pdfThumbnail.setPreviewWidth(400);
            pdfThumbnail.setPreviewHeight(0);

            pdfThumbnail.setUrl(exampleUrl);
        }));
    }

    public static class DownloadStreamResource extends StreamResource {

        private String url;

        public DownloadStreamResource(String url) {
            super((StreamSource) () -> {
                try {
                    return new URL(url).openStream();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }, "download.pdf");
        }
    }

}
