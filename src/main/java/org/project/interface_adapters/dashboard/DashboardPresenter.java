package org.project.interface_adapters;

import org.project.use_case.DashboardOutputBoundary;
import org.project.use_case.DashboardOutputData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DashboardPresenter implements DashboardOutputBoundary {

    private ResponseEntity<Object> responseEntity;

    @Override
    public void present(DashboardOutputData data) {
        Map<String, Object> responseData = new HashMap<>();

        // Convert DashboardOutputData to a Map
        responseData.put("username", data.getUsername());
        responseData.put("friendCount", data.getFriendCount());
        responseData.put("friends", data.getFriends());
        responseData.put("posts", data.getPosts());
        System.out.println("here");
        responseEntity = ResponseEntity.ok(responseData);
    }


    // Get the ResponseEntity to be sent as the HTTP response
    public ResponseEntity<Object> getResponseEntity() {
        return responseEntity;
    }
}
