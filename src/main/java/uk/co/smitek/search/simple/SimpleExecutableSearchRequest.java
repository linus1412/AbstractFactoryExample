package uk.co.smitek.search.simple;

import uk.co.smitek.search.ExecutableSearchRequest;
import uk.co.smitek.search.SearchResult;

import java.util.List;

public class SimpleExecutableSearchRequest implements ExecutableSearchRequest {

    private SimpleSearchRequest searchRequest;
    private SimpleApiSearchService searchService;

    public SimpleExecutableSearchRequest(SimpleSearchRequest searchRequest, SimpleApiSearchService searchService) {
        this.searchRequest = searchRequest;
        this.searchService = searchService;
    }

    @Override
    public List<SearchResult> execute() {
        return searchService.search(searchRequest);
    }

}
