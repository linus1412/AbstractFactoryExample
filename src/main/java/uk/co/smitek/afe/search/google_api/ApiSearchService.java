package uk.co.smitek.afe.search.google_api;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.CustomsearchRequestInitializer;
import com.google.api.services.customsearch.model.Search;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import uk.co.smitek.afe.search.SearchRequest;
import uk.co.smitek.afe.search.SearchResult;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
public abstract class ApiSearchService<T extends SearchRequest> {

    @SneakyThrows
    public List<SearchResult> search(T searchRequest) {


        String searchQuery = searchRequest.getSearchTerm(); //The query to search
        String cx = "004534518815828637225:pr-hegy4fcu"; //Your search engine

        //Instance Customsearch
        Customsearch cs = new Customsearch.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), null)
            .setApplicationName("MyApplication")
            .setGoogleClientRequestInitializer(new CustomsearchRequestInitializer("AIzaSyDVs2NhViiqJyeK0jnrLYS141O77nAX-aw"))
            .build();

        //Set search parameter
        Customsearch.Cse.List list = search(searchRequest, searchQuery, cx, cs);

        //Execute search
        Search result = list.execute();
        return ofNullable(result.getItems())
            .map( items -> items.stream().map(r -> new SearchResult(r.getTitle(), r.getLink())).collect(Collectors.toList()))
            .orElse(Collections.emptyList());


    }

    protected abstract Customsearch.Cse.List search(T searchRequest, String searchQuery, String cx, Customsearch cs) throws IOException;

}


