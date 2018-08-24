package uk.co.smitek.search.factory;

import org.springframework.stereotype.Component;
import uk.co.smitek.search.SearchRequest;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

@Component
public class AbstractExecutableSearchRequestFactory {

  private final Map<Class<? extends SearchRequest>, ExecutableSearchRequestFactory> factories;

  public AbstractExecutableSearchRequestFactory(List<ExecutableSearchRequestFactory> executableSearchRequestFactories) {
    factories = executableSearchRequestFactories.stream()
      .collect(toMap(ExecutableSearchRequestFactory::getSearchRequestType, Function.identity()));
  }

  public ExecutableSearchRequestFactory getFactory(Class<? extends SearchRequest> searchRequestClass) {
    return factories.get(searchRequestClass);
  }

}

