package uk.co.smitek.search.factory;

import uk.co.smitek.search.ExecutableSearchRequest;
import uk.co.smitek.search.SearchRequest;

public interface ExecutableSearchRequestFactory<T extends SearchRequest> {

  Class<T> getSearchRequestType();

  ExecutableSearchRequest createExecutableSearchRequest(T searchRequest);

}
