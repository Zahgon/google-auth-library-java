/*
 * Copyright 2022 Google Inc.
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
// [START auth_cloud_verify_google_idtoken]
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.auth.oauth2.TokenVerifier;

public class VerifyGoogleIdToken {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Verifies the obtained Google id token. This is done at the receiving end of the OIDC endpoint.
    // The most common use case for verifying the ID token is when you are protecting
    // your own APIs with IAP. Google services already verify credentials as a platform,
    // so verifying ID tokens before making Google API calls is usually unnecessary.
    public static void verifyGoogleIdToken(String idToken, String audience, String jwkUrl) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
// [END auth_cloud_verify_google_idtoken]
