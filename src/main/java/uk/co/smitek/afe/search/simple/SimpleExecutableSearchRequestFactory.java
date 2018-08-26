package uk.co.smitek.afe.search.simple;

import org.springframework.stereotype.Component;
import uk.co.smitek.afe.search.ExecutableSearchRequest;
import uk.co.smitek.afe.search.factory.ExecutableSearchRequestFactory;

@Component
public class SimpleExecutableSearchRequestFactory implements ExecutableSearchRequestFactory<SimpleSearchRequest> {

  private final SimpleApiSearchService simpleApiSearchService;

  public SimpleExecutableSearchRequestFactory(SimpleApiSearchService simpleApiSearchService) {
    this.simpleApiSearchService = simpleApiSearchService;
  }

  @Override
  public Class getSearchRequestType() {
    return SimpleSearchRequest.class;
  }

  @Override
  public ExecutableSearchRequest createExecutableSearchRequest(SimpleSearchRequest searchRequest) {

    SimpleExecutableSearchRequest executableSearchRequest = new SimpleExecutableSearchRequest(searchRequest, simpleApiSearchService);

    return executableSearchRequest;
  }


}
