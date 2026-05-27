/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.gson.GsonFactory;
import com.google.auth.oauth2.ExternalAccountSupplierContext;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.IdentityPoolCredentials;
import com.google.auth.oauth2.IdentityPoolSubjectTokenSupplier;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.time.Instant;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * This sample demonstrates how to use a custom subject token supplier to authenticate to Google
 * Cloud Storage, using Okta as the identity provider.
 */
public class CustomCredentialSupplierOktaWorkload {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void customCredentialSupplierOktaWorkload(String gcpWorkloadAudience, String serviceAccountImpersonationUrl, String gcsBucketName, String oktaDomain, String oktaClientId, String oktaClientSecret) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * A custom SubjectTokenSupplier that authenticates with Okta using the Client Credentials grant
     * flow.
     */
    private static class OktaClientCredentialsSupplier implements IdentityPoolSubjectTokenSupplier {

        private static final long TOKEN_REFRESH_BUFFER_SECONDS = 60;

        private final String oktaTokenUrl;

        private final String clientId;

        private final String clientSecret;

        private String accessToken;

        private Instant expiryTime;

        public OktaClientCredentialsSupplier(String domain, String clientId, String clientSecret) {
            this.oktaTokenUrl = domain + "/oauth2/default/v1/token";
            this.clientId = clientId;
            this.clientSecret = clientSecret;
            System.out.println("OktaClientCredentialsSupplier initialized.");
        }

        /**
         * Main method called by the auth library. It will fetch a new token if one is not already
         * cached.
         */
        @Override
        public String getSubjectToken(ExternalAccountSupplierContext context) throws IOException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Performs the Client Credentials grant flow by making a POST request to Okta's token endpoint.
         */
        private void fetchOktaAccessToken() throws IOException {
            URL url = new URL(this.oktaTokenUrl);
            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                // The client_id and client_secret are sent in a Basic Auth header, as required by the
                // OAuth 2.0 Client Credentials grant specification. The credentials are Base64 encoded.
                String auth = this.clientId + ":" + this.clientSecret;
                String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
                conn.setRequestProperty("Authorization", "Basic " + encodedAuth);
                conn.setDoOutput(true);
                try (DataOutputStream out = new DataOutputStream(conn.getOutputStream())) {
                    // For the Client Credentials grant, scopes are optional and define the permissions
                    // the access token will have. Replace "gcp.test.read" with the scopes defined in your
                    // Okta authorization server. Multiple scopes can be requested by space-separating them.
                    // In application/x-www-form-urlencoded, a space is represented by '+' or '%20'.
                    // e.g., "scope1%20scope2" or "scope1+scope2".
                    String params = "grant_type=client_credentials&scope=gcp.test.read%20gcp.bucket.read";
                    out.writeBytes(params);
                    out.flush();
                }
                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = in.readLine()) != null) {
                            response.append(line);
                        }
                        GenericJson jsonObject = GsonFactory.getDefaultInstance().createJsonParser(response.toString()).parse(GenericJson.class);
                        if (jsonObject.containsKey("access_token") && jsonObject.containsKey("expires_in")) {
                            this.accessToken = (String) jsonObject.get("access_token");
                            Number expiresInNumber = (Number) jsonObject.get("expires_in");
                            int expiresIn = expiresInNumber.intValue();
                            this.expiryTime = Instant.now().plusSeconds(expiresIn);
                            System.out.println("[Supplier] Successfully received Access Token from Okta. Expires in " + expiresIn + " seconds.");
                        } else {
                            throw new IOException("Access token or expires_in not found in Okta response.");
                        }
                    }
                } else {
                    throw new IOException("Failed to authenticate with Okta using Client Credentials grant. Response code: " + responseCode);
                }
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }
        }
    }
}
