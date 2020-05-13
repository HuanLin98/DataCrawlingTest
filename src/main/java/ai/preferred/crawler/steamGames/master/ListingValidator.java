package ai.preferred.crawler.steamGames.master;

import ai.preferred.venom.request.Request;
import ai.preferred.venom.response.Response;
import ai.preferred.venom.response.VResponse;
import ai.preferred.venom.validator.Validator;
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

        System.out.println("validating " + document.title());
        if (document.title().startsWith("Browsing")) {
            System.out.println("valid");
            return Status.VALID;
        }

        System.out.println("invalid");
        LOGGER.info("Invalid content");
        return Status.INVALID_CONTENT;
    }

}
