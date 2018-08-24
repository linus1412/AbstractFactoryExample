package uk.co.smitek.search.simple;

import com.google.api.services.customsearch.Customsearch;
import org.springframework.stereotype.Service;
import uk.co.smitek.search.google_api.ApiSearchService;

import java.io.IOException;

@Service
public class SimpleApiSearchService extends ApiSearchService<SimpleSearchRequest> {


    @Override
    protected Customsearch.Cse.List search(SimpleSearchRequest searchRequest, String searchQuery, String cx, Customsearch cs) throws IOException {
        return cs.cse().list(searchQuery).setCx(cx);
    }

}


