package uk.co.smitek.afe.search.simple;

import uk.co.smitek.afe.search.SearchResult;
import uk.co.smitek.afe.search.ExecutableSearchRequest;

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
