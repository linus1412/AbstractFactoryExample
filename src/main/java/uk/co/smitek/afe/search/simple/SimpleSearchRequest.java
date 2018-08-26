package uk.co.smitek.afe.search.simple;

import lombok.Getter;
import lombok.Setter;
import uk.co.smitek.afe.search.SearchRequest;

public class SimpleSearchRequest implements SearchRequest {

    @Getter
    @Setter
    private String searchTerm;

}
