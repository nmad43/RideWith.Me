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
 * on 2013-12-03 at 23:41:53 UTC 
 * Modify at your own risk.
 */

package com.g5.ridewithme.carpoolendpoint.model;

/**
 * Model definition for Carpool.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the carpoolendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Carpool extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String destination;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Customer driver;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Key key;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String lastRoute;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<Customer> riders;

  static {
    // hack to force ProGuard to consider Customer used, since otherwise it would be stripped out
    // see http://code.google.com/p/google-api-java-client/issues/detail?id=528
    com.google.api.client.util.Data.nullOf(Customer.class);
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDestination() {
    return destination;
  }

  /**
   * @param destination destination or {@code null} for none
   */
  public Carpool setDestination(java.lang.String destination) {
    this.destination = destination;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Customer getDriver() {
    return driver;
  }

  /**
   * @param driver driver or {@code null} for none
   */
  public Carpool setDriver(Customer driver) {
    this.driver = driver;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Key getKey() {
    return key;
  }

  /**
   * @param key key or {@code null} for none
   */
  public Carpool setKey(Key key) {
    this.key = key;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getLastRoute() {
    return lastRoute;
  }

  /**
   * @param lastRoute lastRoute or {@code null} for none
   */
  public Carpool setLastRoute(java.lang.String lastRoute) {
    this.lastRoute = lastRoute;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<Customer> getRiders() {
    return riders;
  }

  /**
   * @param riders riders or {@code null} for none
   */
  public Carpool setRiders(java.util.List<Customer> riders) {
    this.riders = riders;
    return this;
  }

  @Override
  public Carpool set(String fieldName, Object value) {
    return (Carpool) super.set(fieldName, value);
  }

  @Override
  public Carpool clone() {
    return (Carpool) super.clone();
  }

}
