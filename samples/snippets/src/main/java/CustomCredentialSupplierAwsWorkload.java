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
import com.google.auth.oauth2.AwsCredentials;
import com.google.auth.oauth2.AwsSecurityCredentials;
import com.google.auth.oauth2.AwsSecurityCredentialsSupplier;
import com.google.auth.oauth2.ExternalAccountSupplierContext;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.regions.providers.DefaultAwsRegionProviderChain;

/**
 * This sample demonstrates how to use a custom AWS security credentials supplier to authenticate to
 * Google Cloud Storage.
 */
public class CustomCredentialSupplierAwsWorkload {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void customCredentialSupplierAwsWorkload(String gcpWorkloadAudience, String saImpersonationUrl, String gcsBucketName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Custom AWS Security Credentials Supplier.
     *
     * <p>This implementation resolves AWS credentials using the default provider chain from the AWS
     * SDK. This allows fetching credentials from environment variables, shared credential files
     * (~/.aws/credentials), or IAM roles for service accounts (IRSA) in EKS, etc.
     */
    private static class CustomAwsSupplier implements AwsSecurityCredentialsSupplier {

        private final AwsCredentialsProvider awsCredentialsProvider;

        private String region;

        public CustomAwsSupplier() {
            // The AWS SDK handles memoization (caching) and proactive refreshing internally.
            this.awsCredentialsProvider = DefaultCredentialsProvider.create();
        }

        /**
         * Returns the AWS region. This is required for signing the AWS request. It resolves the region
         * automatically by using the default AWS region provider chain, which searches for the region
         * in the standard locations (environment variables, AWS config file, etc.).
         */
        @Override
        public String getRegion(ExternalAccountSupplierContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Retrieves AWS security credentials using the AWS SDK's default provider chain.
         */
        @Override
        public AwsSecurityCredentials getCredentials(ExternalAccountSupplierContext context) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
