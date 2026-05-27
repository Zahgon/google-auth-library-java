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
// [START auth_cloud_idtoken_metadata_server]
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.IdTokenCredentials;
import com.google.auth.oauth2.IdTokenProvider;
import com.google.auth.oauth2.IdTokenProvider.Option;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public class IdTokenFromMetadataServer {

    public static void main(String[] args) throws IOException, GeneralSecurityException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Use the Google Cloud metadata server to create an identity token and add it to the
    // HTTP request as part of an Authorization header.
    public static void getIdTokenFromMetadataServer(String url) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
// [END auth_cloud_idtoken_metadata_server]
