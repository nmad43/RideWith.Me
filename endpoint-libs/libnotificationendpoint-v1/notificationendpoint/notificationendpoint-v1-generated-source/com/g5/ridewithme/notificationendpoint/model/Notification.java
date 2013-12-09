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
 * on 2013-12-08 at 23:32:18 UTC 
 * Modify at your own risk.
 */

package com.g5.ridewithme.notificationendpoint.model;

/**
 * Model definition for Notification.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the notificationendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Notification extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String body;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String recipient;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String sender;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getBody() {
    return body;
  }

  /**
   * @param body body or {@code null} for none
   */
  public Notification setBody(java.lang.String body) {
    this.body = body;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getRecipient() {
    return recipient;
  }

  /**
   * @param recipient recipient or {@code null} for none
   */
  public Notification setRecipient(java.lang.String recipient) {
    this.recipient = recipient;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getSender() {
    return sender;
  }

  /**
   * @param sender sender or {@code null} for none
   */
  public Notification setSender(java.lang.String sender) {
    this.sender = sender;
    return this;
  }

  @Override
  public Notification set(String fieldName, Object value) {
    return (Notification) super.set(fieldName, value);
  }

  @Override
  public Notification clone() {
    return (Notification) super.clone();
  }

}
