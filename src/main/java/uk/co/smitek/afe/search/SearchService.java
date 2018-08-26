package uk.co.smitek.afe.search;

import org.springframework.stereotype.Service;
import uk.co.smitek.afe.search.factory.AbstractExecutableSearchRequestFactory;
import uk.co.smitek.afe.search.factory.ExecutableSearchRequestFactory;

import java.util.List;

@Service
public class SearchService {

  private final AbstractExecutableSearchRequestFactory abstractExecutableSearchRequestFactory;

  public SearchService(AbstractExecutableSearchRequestFactory abstractExecutableSearchRequestFactory) {
    this.abstractExecutableSearchRequestFactory = abstractExecutableSearchRequestFactory;
  }

  public List<SearchResult> search(SearchRequest searchRequest) {
    final ExecutableSearchRequestFactory factory = abstractExecutableSearchRequestFactory.getFactory(searchRequest.getClass());
    final ExecutableSearchRequest executableSearchRequest = factory.createExecutableSearchRequest(searchRequest);

    return executableSearchRequest.execute();

  }

}
