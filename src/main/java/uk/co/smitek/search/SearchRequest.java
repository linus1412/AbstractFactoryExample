package uk.co.smitek.search;

import java.util.List;

public interface SearchRequest {

  List<SearchResult> execute();

  String getSearchTerm();

}
