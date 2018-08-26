package uk.co.smitek.afe.search.filtered;

import lombok.Getter;
import lombok.Setter;
import uk.co.smitek.afe.search.SearchRequest;

public class FilteredSearchRequest implements SearchRequest {

    @Getter
    @Setter
    private String searchTerm;

    @Getter
    @Setter
    private String filtered;

}
