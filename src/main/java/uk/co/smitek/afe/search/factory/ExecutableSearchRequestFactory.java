package uk.co.smitek.afe.search.factory;

import uk.co.smitek.afe.search.ExecutableSearchRequest;
import uk.co.smitek.afe.search.SearchRequest;

public interface ExecutableSearchRequestFactory<T extends SearchRequest> {

  Class<T> getSearchRequestType();

  ExecutableSearchRequest createExecutableSearchRequest(T searchRequest);

}
