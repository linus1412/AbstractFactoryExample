package uk.co.smitek.afe.search.filtered;

import org.springframework.stereotype.Component;
import uk.co.smitek.afe.search.ExecutableSearchRequest;
import uk.co.smitek.afe.search.factory.ExecutableSearchRequestFactory;

@Component
public class FilteredExecutableSearchRequestFactory implements ExecutableSearchRequestFactory<FilteredSearchRequest> {

  private final FilteredApiSearchService filteredApiSearchService;

  public FilteredExecutableSearchRequestFactory(FilteredApiSearchService filteredApiSearchService) {
    this.filteredApiSearchService = filteredApiSearchService;
  }


  @Override
  public Class getSearchRequestType() {
    return FilteredSearchRequest.class;
  }

  @Override
  public ExecutableSearchRequest createExecutableSearchRequest(FilteredSearchRequest searchRequest) {
    FilteredExecutableSearchRequest executableSearchRequest = new FilteredExecutableSearchRequest(searchRequest, filteredApiSearchService);

    return executableSearchRequest;
  }

}
