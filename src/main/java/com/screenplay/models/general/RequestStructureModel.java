package com.screenplay.models.general;

import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestStructureModel {
    private String baseUri;
    private String basePath;
    private String contentType;
    private String token;
    private Map<String, String> formBody;
    private Object jsonBody;
    private Map<String, String> pathParams;
    private Boolean hasPassword;
    private Map<String, String> headers;
    private Map<String, String> queryParams;
    private Multimap<String, String> queryParamsSameKey;
}
