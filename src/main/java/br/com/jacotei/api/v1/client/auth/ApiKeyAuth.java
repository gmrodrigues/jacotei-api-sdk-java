package br.com.jacotei.api.v1.client.auth;

import java.util.Map;

public class ApiKeyAuth implements Authentication {

	private final String location;
	private final String paramName;

	private String apiKey;
	private String apiKeyPrefix;

	public ApiKeyAuth(String location, String paramName) {
		this.location = location;
		this.paramName = paramName;
	}

	public String getLocation() {
		return location;
	}

	public String getParamName() {
		return paramName;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getApiKeyPrefix() {
		return apiKeyPrefix;
	}

	public void setApiKeyPrefix(String apiKeyPrefix) {
		this.apiKeyPrefix = apiKeyPrefix;
	}

	public void applyToParams(Map<String, String> queryParams, Map<String, String> headerParams) {
		String value;
		if (apiKeyPrefix != null) {
			value = apiKeyPrefix + " " + apiKey;
		} else {
			value = apiKey;
		}
		if (location == "query") {
			queryParams.put(paramName, value);
		} else if (location == "header") {
			headerParams.put(paramName, value);
		}
	}
}
