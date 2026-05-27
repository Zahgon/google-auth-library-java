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
// [auth_cloud_idtoken_impersonated_credentials]
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.IdTokenCredentials;
import com.google.auth.oauth2.IdTokenProvider.Option;
import com.google.auth.oauth2.ImpersonatedCredentials;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class IdTokenFromImpersonatedCredentials {

    public static void main(String[] args) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Use a service account (SA1) to impersonate as another service account (SA2) and obtain id token
    // for the impersonated account.
    // To obtain token for SA2, SA1 should have the "roles/iam.serviceAccountTokenCreator" permission
    // on SA2.
    public static void getIdTokenUsingOAuth2(String impersonatedServiceAccount, String scope, String targetAudience) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
// [auth_cloud_idtoken_impersonated_credentials]
