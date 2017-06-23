package com.helloweenvsfei.test;

import com.yahoo.search.*;

import java.io.IOException;

/**
 * Code sample to demonstrate using the Yahoo! Java API to perform a web
 * search.
 *
 * @author Ryan Kennedy
 */
public class WebSearch {
	
    public static void main(String[] args) {
        // Create the search client. Pass it your application ID.
        SearchClient client = new SearchClient("javasdktest");
        
        // Create the web search request. In this case we're searching for
        // java-related hits.
        WebSearchRequest request = new WebSearchRequest("ͼƬ");
        
        request.setAdultOk(true);
        
        try {
            // Execute the search.
            WebSearchResults results = client.webSearch(request);

            // Print out how many hits were found.
            System.out.println("Found " + results.getTotalResultsAvailable() +
                    " hits for java! Displaying the first " +
                    results.getTotalResultsReturned() + ".");

            // Iterate over the results.
            for (int i = 0; i < results.listResults().length; i++) {
                WebSearchResult result = results.listResults()[i];

                // Print out the document title and URL.
                System.out.println("   " + (i + 1) + ": " + result.getTitle() + " - " +
                        result.getUrl());
                result.getSummary();
            }
        }
        catch (IOException e) {
            // Most likely a network exception of some sort.
            System.err.println("Error calling Yahoo! Search Service: " +
                    e.toString());
            e.printStackTrace(System.err);
        }
        catch (SearchException e) {
            // An issue with the XML or with the service.
            System.err.println("Error calling Yahoo! Search Service: " +
                    e.toString());
            e.printStackTrace(System.err);
        }
    }
}