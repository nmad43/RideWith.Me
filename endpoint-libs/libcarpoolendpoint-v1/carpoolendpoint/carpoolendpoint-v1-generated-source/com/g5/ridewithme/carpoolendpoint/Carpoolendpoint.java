/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2013-11-22 19:59:01 UTC)
 * on 2013-12-03 at 22:17:18 UTC 
 * Modify at your own risk.
 */

package com.g5.ridewithme.carpoolendpoint;

/**
 * Service definition for Carpoolendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link CarpoolendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Carpoolendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.16.0-rc of the carpoolendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://myapp.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "carpoolendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Carpoolendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Carpoolendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getCarpool".
   *
   * This request holds the parameters needed by the the carpoolendpoint server.  After setting any
   * optional parameters, call the {@link GetCarpool#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetCarpool getCarpool(java.lang.Long id) throws java.io.IOException {
    GetCarpool result = new GetCarpool(id);
    initialize(result);
    return result;
  }

  public class GetCarpool extends CarpoolendpointRequest<com.g5.ridewithme.carpoolendpoint.model.Carpool> {

    private static final String REST_PATH = "carpool/{id}";

    /**
     * Create a request for the method "getCarpool".
     *
     * This request holds the parameters needed by the the carpoolendpoint server.  After setting any
     * optional parameters, call the {@link GetCarpool#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetCarpool#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetCarpool(java.lang.Long id) {
      super(Carpoolendpoint.this, "GET", REST_PATH, null, com.g5.ridewithme.carpoolendpoint.model.Carpool.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetCarpool setAlt(java.lang.String alt) {
      return (GetCarpool) super.setAlt(alt);
    }

    @Override
    public GetCarpool setFields(java.lang.String fields) {
      return (GetCarpool) super.setFields(fields);
    }

    @Override
    public GetCarpool setKey(java.lang.String key) {
      return (GetCarpool) super.setKey(key);
    }

    @Override
    public GetCarpool setOauthToken(java.lang.String oauthToken) {
      return (GetCarpool) super.setOauthToken(oauthToken);
    }

    @Override
    public GetCarpool setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetCarpool) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetCarpool setQuotaUser(java.lang.String quotaUser) {
      return (GetCarpool) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetCarpool setUserIp(java.lang.String userIp) {
      return (GetCarpool) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetCarpool setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetCarpool set(String parameterName, Object value) {
      return (GetCarpool) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertCarpool".
   *
   * This request holds the parameters needed by the the carpoolendpoint server.  After setting any
   * optional parameters, call the {@link InsertCarpool#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.g5.ridewithme.carpoolendpoint.model.Carpool}
   * @return the request
   */
  public InsertCarpool insertCarpool(com.g5.ridewithme.carpoolendpoint.model.Carpool content) throws java.io.IOException {
    InsertCarpool result = new InsertCarpool(content);
    initialize(result);
    return result;
  }

  public class InsertCarpool extends CarpoolendpointRequest<com.g5.ridewithme.carpoolendpoint.model.Carpool> {

    private static final String REST_PATH = "carpool";

    /**
     * Create a request for the method "insertCarpool".
     *
     * This request holds the parameters needed by the the carpoolendpoint server.  After setting any
     * optional parameters, call the {@link InsertCarpool#execute()} method to invoke the remote
     * operation. <p> {@link InsertCarpool#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.g5.ridewithme.carpoolendpoint.model.Carpool}
     * @since 1.13
     */
    protected InsertCarpool(com.g5.ridewithme.carpoolendpoint.model.Carpool content) {
      super(Carpoolendpoint.this, "POST", REST_PATH, content, com.g5.ridewithme.carpoolendpoint.model.Carpool.class);
    }

    @Override
    public InsertCarpool setAlt(java.lang.String alt) {
      return (InsertCarpool) super.setAlt(alt);
    }

    @Override
    public InsertCarpool setFields(java.lang.String fields) {
      return (InsertCarpool) super.setFields(fields);
    }

    @Override
    public InsertCarpool setKey(java.lang.String key) {
      return (InsertCarpool) super.setKey(key);
    }

    @Override
    public InsertCarpool setOauthToken(java.lang.String oauthToken) {
      return (InsertCarpool) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertCarpool setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertCarpool) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertCarpool setQuotaUser(java.lang.String quotaUser) {
      return (InsertCarpool) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertCarpool setUserIp(java.lang.String userIp) {
      return (InsertCarpool) super.setUserIp(userIp);
    }

    @Override
    public InsertCarpool set(String parameterName, Object value) {
      return (InsertCarpool) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listCarpool".
   *
   * This request holds the parameters needed by the the carpoolendpoint server.  After setting any
   * optional parameters, call the {@link ListCarpool#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListCarpool listCarpool() throws java.io.IOException {
    ListCarpool result = new ListCarpool();
    initialize(result);
    return result;
  }

  public class ListCarpool extends CarpoolendpointRequest<com.g5.ridewithme.carpoolendpoint.model.CollectionResponseCarpool> {

    private static final String REST_PATH = "carpool";

    /**
     * Create a request for the method "listCarpool".
     *
     * This request holds the parameters needed by the the carpoolendpoint server.  After setting any
     * optional parameters, call the {@link ListCarpool#execute()} method to invoke the remote
     * operation. <p> {@link
     * ListCarpool#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListCarpool() {
      super(Carpoolendpoint.this, "GET", REST_PATH, null, com.g5.ridewithme.carpoolendpoint.model.CollectionResponseCarpool.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListCarpool setAlt(java.lang.String alt) {
      return (ListCarpool) super.setAlt(alt);
    }

    @Override
    public ListCarpool setFields(java.lang.String fields) {
      return (ListCarpool) super.setFields(fields);
    }

    @Override
    public ListCarpool setKey(java.lang.String key) {
      return (ListCarpool) super.setKey(key);
    }

    @Override
    public ListCarpool setOauthToken(java.lang.String oauthToken) {
      return (ListCarpool) super.setOauthToken(oauthToken);
    }

    @Override
    public ListCarpool setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListCarpool) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListCarpool setQuotaUser(java.lang.String quotaUser) {
      return (ListCarpool) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListCarpool setUserIp(java.lang.String userIp) {
      return (ListCarpool) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListCarpool setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer limit;

    /**

     */
    public java.lang.Integer getLimit() {
      return limit;
    }

    public ListCarpool setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListCarpool set(String parameterName, Object value) {
      return (ListCarpool) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeCarpool".
   *
   * This request holds the parameters needed by the the carpoolendpoint server.  After setting any
   * optional parameters, call the {@link RemoveCarpool#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveCarpool removeCarpool(java.lang.Long id) throws java.io.IOException {
    RemoveCarpool result = new RemoveCarpool(id);
    initialize(result);
    return result;
  }

  public class RemoveCarpool extends CarpoolendpointRequest<Void> {

    private static final String REST_PATH = "carpool/{id}";

    /**
     * Create a request for the method "removeCarpool".
     *
     * This request holds the parameters needed by the the carpoolendpoint server.  After setting any
     * optional parameters, call the {@link RemoveCarpool#execute()} method to invoke the remote
     * operation. <p> {@link RemoveCarpool#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveCarpool(java.lang.Long id) {
      super(Carpoolendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveCarpool setAlt(java.lang.String alt) {
      return (RemoveCarpool) super.setAlt(alt);
    }

    @Override
    public RemoveCarpool setFields(java.lang.String fields) {
      return (RemoveCarpool) super.setFields(fields);
    }

    @Override
    public RemoveCarpool setKey(java.lang.String key) {
      return (RemoveCarpool) super.setKey(key);
    }

    @Override
    public RemoveCarpool setOauthToken(java.lang.String oauthToken) {
      return (RemoveCarpool) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveCarpool setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveCarpool) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveCarpool setQuotaUser(java.lang.String quotaUser) {
      return (RemoveCarpool) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveCarpool setUserIp(java.lang.String userIp) {
      return (RemoveCarpool) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveCarpool setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveCarpool set(String parameterName, Object value) {
      return (RemoveCarpool) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateCarpool".
   *
   * This request holds the parameters needed by the the carpoolendpoint server.  After setting any
   * optional parameters, call the {@link UpdateCarpool#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.g5.ridewithme.carpoolendpoint.model.Carpool}
   * @return the request
   */
  public UpdateCarpool updateCarpool(com.g5.ridewithme.carpoolendpoint.model.Carpool content) throws java.io.IOException {
    UpdateCarpool result = new UpdateCarpool(content);
    initialize(result);
    return result;
  }

  public class UpdateCarpool extends CarpoolendpointRequest<com.g5.ridewithme.carpoolendpoint.model.Carpool> {

    private static final String REST_PATH = "carpool";

    /**
     * Create a request for the method "updateCarpool".
     *
     * This request holds the parameters needed by the the carpoolendpoint server.  After setting any
     * optional parameters, call the {@link UpdateCarpool#execute()} method to invoke the remote
     * operation. <p> {@link UpdateCarpool#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.g5.ridewithme.carpoolendpoint.model.Carpool}
     * @since 1.13
     */
    protected UpdateCarpool(com.g5.ridewithme.carpoolendpoint.model.Carpool content) {
      super(Carpoolendpoint.this, "PUT", REST_PATH, content, com.g5.ridewithme.carpoolendpoint.model.Carpool.class);
    }

    @Override
    public UpdateCarpool setAlt(java.lang.String alt) {
      return (UpdateCarpool) super.setAlt(alt);
    }

    @Override
    public UpdateCarpool setFields(java.lang.String fields) {
      return (UpdateCarpool) super.setFields(fields);
    }

    @Override
    public UpdateCarpool setKey(java.lang.String key) {
      return (UpdateCarpool) super.setKey(key);
    }

    @Override
    public UpdateCarpool setOauthToken(java.lang.String oauthToken) {
      return (UpdateCarpool) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateCarpool setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateCarpool) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateCarpool setQuotaUser(java.lang.String quotaUser) {
      return (UpdateCarpool) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateCarpool setUserIp(java.lang.String userIp) {
      return (UpdateCarpool) super.setUserIp(userIp);
    }

    @Override
    public UpdateCarpool set(String parameterName, Object value) {
      return (UpdateCarpool) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Carpoolendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Carpoolendpoint}. */
    @Override
    public Carpoolendpoint build() {
      return new Carpoolendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link CarpoolendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setCarpoolendpointRequestInitializer(
        CarpoolendpointRequestInitializer carpoolendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(carpoolendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
