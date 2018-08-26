package uk.co.smitek.afe.search.filtered;

import uk.co.smitek.afe.search.SearchResult;
import uk.co.smitek.afe.search.ExecutableSearchRequest;

import java.util.List;

public class FilteredExecutableSearchRequest implements ExecutableSearchRequest {

  private final FilteredSearchRequest searchRequest;
  private final FilteredApiSearchService searchService;

  public FilteredExecutableSearchRequest(FilteredSearchRequest searchRequest, FilteredApiSearchService searchService) {
    this.searchRequest = searchRequest;
    this.searchService = searchService;
  }

  @Override
    public List<SearchResult> execute() {
      return searchService.search(searchRequest);
    }

}
