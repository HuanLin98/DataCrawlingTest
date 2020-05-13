package ai.preferred.crawler.steamGames.master;

import ai.preferred.venom.request.Request;
import ai.preferred.venom.response.Response;
import ai.preferred.venom.response.VResponse;
import ai.preferred.venom.validator.Validator;
// import org.apache.log4j.net.SyslogAppender;
// import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jsoup.select.Elements;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import java.io.IOException;
import java.net.URISyntaxException;


public class ListingValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListingValidator.class);

    @Override
    public Validator.Status isValid(Request request, Response response) {
        
        final VResponse vResponse = new VResponse(response);

        final Document document = vResponse.getJsoup();
        
        // to make sure it is the first tab of the genre
        // boolean firstTab = false;
        // // System.out.println("validating " + document.getElementsByClass("tab") + "ending");
        // // Elements tabs = document.select("div[class=tab tab_filler active]");
        // Elements tabs = document.select("#")
        // // document.getE
        // if (tabs.first().text().equals("New and Trending")) {
        //     firstTab = true;
        // }

        // // to check whether it is under the page limit needed (3)
        // Integer pageLimit = 3;
        // boolean underLimit = false;
        // Elements pages = document.select("span.paged_items_paging_pagelink.active");
        // if (Integer.parseInt(pages.first().text()) <= pageLimit) {
        //     underLimit = true;
        // }

        // // // Crawl another page if there's a next page
        // final String url = request.getUrl();
        // try {
        //     final URIBuilder builder = new URIBuilder(url);
        //     int currentPage = 1;
        //     for (final NameValuePair param : builder.getQueryParams()) {
        //         if ("page".equals(param.getName())) {
        //         currentPage = Integer.parseInt(param.getValue());
        //         System.out.println("page number: " + currentPage);
        //         }
        //     }
        //     builder.setParameter("page", String.valueOf(currentPage + 1));
        //     final String nextPageUrl = builder.toString();
        // } catch (URISyntaxException | NumberFormatException e) {
        // LOGGER.error("unable to parse url: ", e);
        // }

        System.out.println("validating " + document.title());
        if (document.title().startsWith("Browsing")  /* && firstTab&& underLimit*/) {
            System.out.println("valid");
            return Status.VALID;
        }

        System.out.println("invalid");
        LOGGER.info("Invalid content");
        return Status.INVALID_CONTENT;
    }

}