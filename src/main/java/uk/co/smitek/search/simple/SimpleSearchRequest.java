package uk.co.smitek.search.simple;

import lombok.Getter;
import lombok.Setter;
import uk.co.smitek.search.google_api.ApiSearchService;
import uk.co.smitek.search.SearchRequest;
import uk.co.smitek.search.SearchResult;

import java.util.List;

public class SimpleSearchRequest implements SearchRequest {

    private ApiSearchService apiSearchService;

    @Getter
    @Setter
    private String searchTerm;

    @Override
    public List<SearchResult> execute() {

        return apiSearchService.search(this);

    }

}
