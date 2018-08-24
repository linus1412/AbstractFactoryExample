package uk.co.smitek.search;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.smitek.search.filtered.FilteredSearchRequest;
import uk.co.smitek.search.simple.SimpleSearchRequest;

import java.util.List;

@RestController
public class SearchController {

  private final SearchService searchService;

  public SearchController(SearchService searchService) {
    this.searchService = searchService;
  }

  @RequestMapping("/search")
  public List<SearchResult> search(SearchRequest searchRequest) {

    return searchService.search(searchRequest);

  }


  @RequestMapping("/simpleSearch")
  public List<SearchResult> simpleSearch() {

    final SimpleSearchRequest searchRequest = new SimpleSearchRequest();
    searchRequest.setSearchTerm("Liverpool Salah");

    return searchService.search(searchRequest);

  }

  @RequestMapping("/filteredSearch")
  public List<SearchResult> filteredSearch() {

    final FilteredSearchRequest searchRequest = new FilteredSearchRequest();
    searchRequest.setSearchTerm("Liverpool Salah");
    searchRequest.setFiltered("Real Madrid");

    return searchService.search(searchRequest);

  }



}
