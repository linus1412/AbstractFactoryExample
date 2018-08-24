package uk.co.smitek.search.filtered;

import lombok.Getter;
import lombok.Setter;
import uk.co.smitek.search.SearchRequest;
import uk.co.smitek.search.SearchResult;

import java.util.List;

public class FilteredSearchRequest implements SearchRequest {

    private FilteredApiSearchService searchService;

    @Getter
    @Setter
    private String searchTerm;

    @Getter
    @Setter
    private String filtered;

    @Override
    public List<SearchResult> execute() {

        return searchService.search(this);

    }

}
