package uk.co.smitek.afe.search.filtered;

import com.google.api.services.customsearch.Customsearch;
import org.springframework.stereotype.Service;
import uk.co.smitek.afe.search.google_api.ApiSearchService;

import java.io.IOException;

@Service
public class FilteredApiSearchService extends ApiSearchService<FilteredSearchRequest> {


    @Override
    public Customsearch.Cse.List search(FilteredSearchRequest searchRequest, String searchQuery, String cx, Customsearch cs) throws IOException {
        return cs.cse().list(searchQuery).setCx(cx).setExcludeTerms(searchRequest.getFiltered());
    }

}


